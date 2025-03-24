<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Dịch Vụ</title>
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
    <h1>Danh Sách Dịch Vụ</h1>
    <div id="service-list"></div>
</div>
<script src="/js/script.js"></script>
<script>
    fetchServices();
</script>
</body>
</html>