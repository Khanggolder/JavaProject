// Xử lý đăng nhập
document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('login-form');
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;

            fetch('http://localhost:8080/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, password })
            })
                .then(response => {
                    if (!response.ok) throw new Error('Đăng nhập thất bại');
                    return response.json();
                })
                .then(data => {
                    localStorage.setItem('token', data.token);
                    alert('Đăng nhập thành công!');
                    window.location.href = '/booking';
                })
                .catch(error => {
                    console.error('Error logging in:', error);
                    alert('Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin.');
                });
        });
    }

    // Gửi form đặt lịch với token
    const bookingForm = document.getElementById('booking-form');
    if (bookingForm) {
        bookingForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const token = localStorage.getItem('token');
            if (!token) {
                alert('Vui lòng đăng nhập trước!');
                window.location.href = '/login.jsp'; // Chuyển tới trang đăng nhập
                return;
            }

            const data = {
                customer: { id: document.getElementById('customerId').value },
                service: { id: document.getElementById('serviceId').value },
                therapist: document.getElementById('therapistId').value ? { id: document.getElementById('therapistId').value } : null,
                bookingTime: document.getElementById('bookingTime').value
            };

            fetch('http://localhost:8080/booking/booking', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify(data)
            })
                .then(response => {
                    if (!response.ok) throw new Error('Đặt lịch thất bại');
                    return response.json();
                })
                .then(data => alert('Đặt lịch thành công! ID: ' + data.id))
                .catch(error => {
                    console.error('Error booking:', error);
                    alert('Đặt lịch thất bại. Vui lòng thử lại.');
                });
        });
    }
});