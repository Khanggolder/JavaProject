package com.example.jpademo.services;

import com.example.jpademo.models.SkinTest;
import com.example.jpademo.repositories.SkinTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkinTestService {
    @Autowired
    private SkinTestRepository skinTestRepository;

    @Autowired
    private ServiceService serviceService;

    public SkinTest saveSkinTest(SkinTest skinTest) {
        return skinTestRepository.save(skinTest);
    }

    public List<com.example.jpademo.models.Service> recommendServices(SkinTest skinTest) {
        // Simplified logic: Recommend services based on skin type
        String skinType = skinTest.getSkinType().toLowerCase();
        return serviceService.findAll().stream()
                .filter(service -> service.getDescription().toLowerCase().contains(skinType))
                .collect(Collectors.toList());
    }
}