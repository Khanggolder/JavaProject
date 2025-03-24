package com.example.jpademo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "therapist_id", referencedColumnName = "id")
    private SkinTherapist therapist;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "result", length = 255)
    private String result;

    @Column(name = "payment_status", length = 50)
    private String paymentStatus; // e.g., "PENDING", "PAID", "REFUNDED"

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }
    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }
    public SkinTherapist getTherapist() { return therapist; }
    public void setTherapist(SkinTherapist therapist) { this.therapist = therapist; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public BigDecimal getPaymentAmount() { return paymentAmount; }
    public void setPaymentAmount(BigDecimal paymentAmount) { this.paymentAmount = paymentAmount; }
}