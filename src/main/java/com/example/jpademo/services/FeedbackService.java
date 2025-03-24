package com.example.jpademo.services;

import com.example.jpademo.models.Feedback;
import com.example.jpademo.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }
}