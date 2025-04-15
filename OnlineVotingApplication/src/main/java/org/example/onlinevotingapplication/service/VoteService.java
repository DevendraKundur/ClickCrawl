package org.example.onlinevotingapplication.service;

import org.example.onlinevotingapplication.model.User;
import org.example.onlinevotingapplication.model.Vote;
import org.example.onlinevotingapplication.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    // Cast a new vote
    public Vote castVote(User voter, User candidate) {
        Vote vote = new Vote();
        vote.setVoterId(voter.getId());           // Store voter ID
        vote.setCandidateId(candidate.getId());  // Store candidate ID
        return voteRepository.save(vote);
    }

    // Get votes for a specific candidate
    public List<Vote> getVotesForCandidate(User candidate) {
        return voteRepository.findByCandidateId(candidate.getId());
    }
    public long countVotesForCandidate(Long candidateId) {
        return voteRepository.countByCandidateId(candidateId);
    }


}
