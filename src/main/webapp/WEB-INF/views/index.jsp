<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="navbar">
    <a href="/">Trang Chủ</a>
    <a href="/services">Dịch Vụ</a>
    <a href="/booking">Đặt Lịch</a>
    <a href="/blog">Blog</a>
</div>
<div class="container">
    <h1>Đăng Nhập</h1>
    <form id="login-form">
        <div class="form-group">
            <label for="username">Tên Đăng Nhập:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Mật Khẩu:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="button">Đăng Nhập</button>
    </form>
</div>
<script src="/js/script.js"></script>
</body>
</html>