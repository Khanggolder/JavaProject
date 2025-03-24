package com.example.jpademo.services;

import com.example.jpademo.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<com.example.jpademo.models.Service> findAll() {
        return serviceRepository.findAll();
    }

    public com.example.jpademo.models.Service createService(com.example.jpademo.models.Service service) {
        return serviceRepository.save(service);
    }

    public com.example.jpademo.models.Service updateService(com.example.jpademo.models.Service service) {
        return serviceRepository.save(service);
    }
}