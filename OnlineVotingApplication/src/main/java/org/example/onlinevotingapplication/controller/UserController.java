package org.example.onlinevotingapplication.controller;

import org.example.onlinevotingapplication.model.User;
import org.example.onlinevotingapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Fetch All Users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Fetch only Candidates
    @GetMapping("/candidates")
    public List<User> getCandidates() {
        return userRepository.findAll().stream()
                .filter(user -> "candidate".equalsIgnoreCase(user.getRole()))
                .toList();
    }
}
