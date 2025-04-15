package org.example.onlinevotingapplication.controller;

import org.example.onlinevotingapplication.model.User;
import org.example.onlinevotingapplication.model.Vote;
import org.example.onlinevotingapplication.repository.UserRepository;
import org.example.onlinevotingapplication.repository.VoteRepository;
import org.example.onlinevotingapplication.service.UserService;
import org.example.onlinevotingapplication.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("/api/vote")
public class VoteController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;



    @Autowired
    private VoteRepository voteRepository;

    @GetMapping("/allCandidatesVotes")
    public List<Map<String, Object>> getAllCandidatesVotes() {
        List<User> candidates = userService.getAllCandidates();
        List<Map<String, Object>> result = new ArrayList<>();

        for (User candidate : candidates) {
            Map<String, Object> map = new HashMap<>();
            map.put("username", candidate.getUsername());
            map.put("voteCount", voteService.countVotesForCandidate(candidate.getId()));
            result.add(map);
        }
        return result;
    }


    @PostMapping("/cast")
    public String castVote(@RequestParam Long voterId, @RequestParam Long candidateId) {

        // Time restriction check
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(17, 0);

        if (now.isBefore(start) || now.isAfter(end)) {
            return "⚠️ Voting is allowed only between 8:00 AM and 5:00 PM.";
        }

        // Fetch Voter and Candidate
        Optional<User> voterOpt = userRepository.findById(voterId);
        Optional<User> candidateOpt = userRepository.findById(candidateId);

        if (voterOpt.isPresent() && candidateOpt.isPresent()) {
            User voter = voterOpt.get();
            User candidate = candidateOpt.get();

            if (voter.isHasVoted()) {
                return "⚠️ You have already voted!";
            }

            // Create and Save Vote
            Vote vote = new Vote();
            vote.setVoterId(voter.getId());
            vote.setCandidateId(candidate.getId());
            voteRepository.save(vote);

            // Update voter status
            voter.setHasVoted(true);
            userRepository.save(voter);

            return "✅ Your vote has been successfully cast!";
        } else {
            return "Invalid Voter or Candidate ID!";
        }
    }
}
