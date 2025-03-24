package com.example.jpademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Trả về index.jsp
    }

    @GetMapping("/services")
    public String services() {
        return "services"; // Trả về services.jsp
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking"; // Trả về booking.jsp
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog"; // Trả về blog.jsp
    }
}