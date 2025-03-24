package com.example.jpademo.services;

import com.example.jpademo.models.Center;
import com.example.jpademo.repositories.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {
    @Autowired
    private CenterRepository centerRepository;

    public List<Center> findAll() {
        return centerRepository.findAll();
    }

    public Center createCenter(Center center) {
        return centerRepository.save(center);
    }

    public Center updateCenter(Center center) {
        return centerRepository.save(center);
    }
}