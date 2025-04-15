package org.example.onlinevotingapplication.controller;

import org.example.onlinevotingapplication.model.Admin;
import org.example.onlinevotingapplication.model.User;
import org.example.onlinevotingapplication.service.AdminService;
import org.example.onlinevotingapplication.service.VoteService;
import org.example.onlinevotingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    // Admin login
    @PostMapping("/login")
    public Optional<Admin> login(@RequestParam String username, @RequestParam String password) {
        return adminService.login(username, password);
    }

    // Declare voting results after 5:30 PM
    @GetMapping("/declareResults")
    public String declareResults() {
        LocalTime now = LocalTime.now();
        LocalTime allowedTime = LocalTime.of(17, 30);  // 5:30 PM

        if (now.isBefore(allowedTime)) {
            return "Results cannot be declared before 5:30 PM!";
        }

        List<User> candidates = userService.getAllCandidates();
        StringBuilder result = new StringBuilder("🗳️ Voting Results:\n");

        for (User candidate : candidates) {
            long voteCount = voteService.countVotesForCandidate(candidate.getId());
            result.append(candidate.getUsername())
                    .append(" - ")
                    .append(voteCount)
                    .append(" votes\n");
        }

        return result.toString();
    }
}
