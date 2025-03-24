package com.example.jpademo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "skin_tests")
public class SkinTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "skin_type", length = 50)
    private String skinType; // e.g., "Oily", "Dry"

    @Column(name = "concerns", length = 255)
    private String concerns; // e.g., "Acne, Dryness"

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getSkinType() { return skinType; }
    public void setSkinType(String skinType) { this.skinType = skinType; }
    public String getConcerns() { return concerns; }
    public void setConcerns(String concerns) { this.concerns = concerns; }
}