package com.example.jpademo.controller;

import com.example.jpademo.models.Booking;
import com.example.jpademo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    @PostMapping("/booking")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/booking/{id}/checkin")
    public Booking checkIn(@PathVariable Long id) {
        return bookingService.checkIn(id);
    }

    @PutMapping("/booking/{id}/assign/{therapistId}")
    public Booking assignTherapist(@PathVariable Long id, @PathVariable Long therapistId) {
        return bookingService.assignTherapist(id, therapistId);
    }

    @PutMapping("/booking/{id}/complete")
    public Booking completeService(@PathVariable Long id, @RequestBody String result) {
        return bookingService.completeService(id, result);
    }

    @PutMapping("/booking/{id}/checkout")
    public Booking checkOut(@PathVariable Long id) {
        return bookingService.checkOut(id);
    }

    @PutMapping("/booking/{id}/cancel")
    public Booking cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }

    @PutMapping("/booking/{id}/pay")
    public Booking processPayment(@PathVariable Long id) {
        return bookingService.processPayment(id);
    }
}