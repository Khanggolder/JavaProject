package com.example.jpademo.services;

import com.example.jpademo.models.Booking;
import com.example.jpademo.models.SkinTherapist;
import com.example.jpademo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SkinTherapistService therapistService;

    public Booking createBooking(Booking booking) {
        booking.setStatus("PENDING");
        booking.setPaymentStatus("PENDING");
        booking.setPaymentAmount(booking.getService().getPrice());
        return bookingRepository.save(booking);
    }

    public Booking checkIn(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            if (!"PAID".equals(booking.getPaymentStatus())) {
                throw new RuntimeException("Payment not completed");
            }
            booking.setStatus("CHECKED_IN");
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    public Booking assignTherapist(Long bookingId, Long therapistId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            SkinTherapist therapist = therapistService.findAll().stream()
                    .filter(t -> t.getId().equals(therapistId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Therapist not found"));
            booking.setTherapist(therapist);
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    public Booking completeService(Long bookingId, String result) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setResult(result);
            booking.setStatus("COMPLETED");
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    public Booking checkOut(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus("CHECKED_OUT");
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    public Booking cancelBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            if (LocalDateTime.now().isAfter(booking.getBookingTime().minusHours(24))) {
                throw new RuntimeException("Cannot cancel within 24 hours of booking time");
            }
            booking.setStatus("CANCELLED");
            if ("PAID".equals(booking.getPaymentStatus())) {
                booking.setPaymentStatus("REFUNDED");
                // In a real app, integrate with payment gateway for refund
            }
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    public Booking processPayment(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setPaymentStatus("PAID");
            // In a real app, integrate with payment gateway
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found");
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}