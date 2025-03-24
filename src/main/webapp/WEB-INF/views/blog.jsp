<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Blog</title>
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
    <h1>Blog Chăm Sóc Da</h1>
    <div id="blog-list"></div>
</div>
<script src="/js/script.js"></script>
<script>
    fetchBlogs();
</script>
</body>
</html>