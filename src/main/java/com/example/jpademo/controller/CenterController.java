package com.example.jpademo.controller;

import com.example.jpademo.models.Center;
import com.example.jpademo.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    private CenterService centerService;

    @GetMapping("/centers")
    public List<Center> getAllCenters() {
        return centerService.findAll();
    }

    @PostMapping("/center")
    public Center createCenter(@RequestBody Center center) {
        return centerService.createCenter(center);
    }

    @PutMapping("/center/{id}")
    public Center updateCenter(@RequestBody Center center) {
        return centerService.updateCenter(center);
    }
}