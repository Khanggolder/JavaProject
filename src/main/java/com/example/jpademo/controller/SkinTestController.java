package com.example.jpademo.controller;

import com.example.jpademo.models.Service;
import com.example.jpademo.models.SkinTest;
import com.example.jpademo.services.SkinTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skintest")
public class SkinTestController {
    @Autowired
    private SkinTestService skinTestService;

    @PostMapping("/test")
    public SkinTest saveSkinTest(@RequestBody SkinTest skinTest) {
        return skinTestService.saveSkinTest(skinTest);
    }

    @PostMapping("/test/recommend")
    public List<Service> recommendServices(@RequestBody SkinTest skinTest) {
        return skinTestService.recommendServices(skinTest);
    }
}