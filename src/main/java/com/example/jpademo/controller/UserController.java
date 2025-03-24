package com.example.jpademo.controller;

import com.example.jpademo.models.User;
import com.example.jpademo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll(); // This should now work
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}