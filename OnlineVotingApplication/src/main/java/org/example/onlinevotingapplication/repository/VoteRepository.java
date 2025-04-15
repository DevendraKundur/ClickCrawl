package org.example.onlinevotingapplication.repository;

import org.example.onlinevotingapplication.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByCandidateId(Long candidateId);

    long countByCandidateId(Long candidateId);  // Add this line!
}
