<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đặt Dịch Vụ</title>
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
    <h1>Đặt Dịch Vụ Chăm Sóc Da</h1>
    <form id="booking-form">
        <div class="form-group">
            <label for="customerId">ID Khách Hàng:</label>
            <input type="number" id="customerId" name="customerId" required>
        </div>
        <div class="form-group">
            <label for="serviceId">ID Dịch Vụ:</label>
            <input type="number" id="serviceId" name="serviceId" required>
        </div>
        <div class="form-group">
            <label for="therapistId">ID Chuyên Viên (tuỳ chọn):</label>
            <input type="number" id="therapistId" name="therapistId">
        </div>
        <div class="form-group">
            <label for="bookingTime">Thời Gian Đặt:</label>
            <input type="datetime-local" id="bookingTime" name="bookingTime" required>
        </div>
        <button type="submit" class="button">Đặt Lịch</button>
    </form>
</div>
<script src="/js/script.js"></script>
</body>
</html>