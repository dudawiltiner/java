package com.challenge.entity;

import com.challenge.SpringChallengeApplication;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@EntityListeners(SpringChallengeApplication.class)
public class Candidate extends User {
    @ManyToOne
    @Column(name = "user_id")
    private User user;

    @EmbeddedId
    private CandidateId candidateId;

    @NotNull
    private  Integer status;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
