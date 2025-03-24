package com.example.jpademo.services;

import com.example.jpademo.models.SkinTherapist;
import com.example.jpademo.repositories.SkinTherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinTherapistService {
    @Autowired
    private SkinTherapistRepository therapistRepository;

    public List<SkinTherapist> findAll() {
        return therapistRepository.findAll();
    }

    public SkinTherapist createTherapist(SkinTherapist therapist) {
        return therapistRepository.save(therapist);
    }

    public SkinTherapist updateTherapist(SkinTherapist therapist) {
        return therapistRepository.save(therapist);
    }
}