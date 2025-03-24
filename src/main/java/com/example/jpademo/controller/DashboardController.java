package com.example.jpademo.controller;

import com.example.jpademo.services.BookingService;
import com.example.jpademo.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalBookings", bookingService.findAll().size());
        stats.put("completedBookings", bookingService.findAll().stream()
                .filter(b -> "COMPLETED".equals(b.getStatus())).count());
        stats.put("averageRating", feedbackService.findAll().stream()
                .mapToInt(f -> f.getRating()).average().orElse(0.0));
        return stats;
    }
}