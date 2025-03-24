package com.example.jpademo.controller;

import com.example.jpademo.models.SkinTherapist;
import com.example.jpademo.services.SkinTherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/therapist")
public class SkinTherapistController {
    @Autowired
    private SkinTherapistService therapistService;

    @GetMapping("/therapists")
    public List<SkinTherapist> getAllTherapists() {
        return therapistService.findAll();
    }

    @PostMapping("/therapist")
    public SkinTherapist createTherapist(@RequestBody SkinTherapist therapist) {
        return therapistService.createTherapist(therapist);
    }

    @PutMapping("/therapist/{id}")
    public SkinTherapist updateTherapist(@RequestBody SkinTherapist therapist) {
        return therapistService.updateTherapist(therapist);
    }
}