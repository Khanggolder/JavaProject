package com.example.jpademo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    // Secret key nên dài ít nhất 32 ký tự cho HS512
    private final String secret = "your-very-secure-secret-key-1234567890"; // Nên lưu trong application.properties
    private final long expiration = 1000 * 60 * 60; // 1 giờ
    private final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username) // Thay setSubject
                .issuedAt(new Date()) // Thay setIssuedAt
                .expiration(new Date(System.currentTimeMillis() + expiration)) // Thay setExpiration
                .signWith(key) // Thay signWith(SignatureAlgorithm, byte[])
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token, String username) {
        Claims claims = getClaims(token);
        return (username.equals(claims.getSubject()) && !claims.getExpiration().before(new Date()));
    }

    private Claims getClaims(String token) {
        JwtParser parser = Jwts.parser()
                .verifyWith(key) // Thay setSigningKey
                .build(); // Chuyển từ JwtParserBuilder sang JwtParser
        return parser.parseSignedClaims(token).getPayload(); // Thay parseClaimsJws và getBody
    }
}