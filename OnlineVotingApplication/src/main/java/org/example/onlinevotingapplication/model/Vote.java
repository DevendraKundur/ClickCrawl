package org.example.onlinevotingapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voter_id", nullable = false)
    private Long voterId;

    @Column(name = "candidate_id", nullable = false)
    private Long candidateId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Long getVoterId() {
        return voterId;
    }

    public void setVoterId(Long voterId) {
        this.voterId = voterId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}
