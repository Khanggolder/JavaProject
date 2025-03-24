package com.example.jpademo;

import com.example.jpademo.models.User;
import com.example.jpademo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Thêm người dùng mẫu
        if (!userService.existsByUsername("admin")) {
            User admin = new User("admin", "password", "MANAGER");
            userService.createUser(admin); // Mật khẩu sẽ tự động được mã hóa
        }
        if (!userService.existsByUsername("staff")) {
            User staff = new User("staff", "password", "STAFF");
            userService.createUser(staff);
        }
        if (!userService.existsByUsername("customer")) {
            User customer = new User("customer", "password", "CUSTOMER");
            userService.createUser(customer);
        }
    }
}