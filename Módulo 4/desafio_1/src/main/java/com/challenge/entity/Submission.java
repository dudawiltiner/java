package com.challenge.entity;

import com.challenge.SpringChallengeApplication;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(SpringChallengeApplication.class)
public class Submission {
    @EmbeddedId
    private SubmissionId submissionId;

    @NotNull
    private Float score;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
