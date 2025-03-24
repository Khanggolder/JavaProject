package com.example.jpademo.controller;

import com.example.jpademo.models.Service;
import com.example.jpademo.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceService.findAll();
    }

    @PostMapping("/service")
    public Service createService(@RequestBody Service service) {
        return serviceService.createService(service);
    }

    @PutMapping("/service/{id}")
    public Service updateService(@RequestBody Service service) {
        return serviceService.updateService(service);
    }
}