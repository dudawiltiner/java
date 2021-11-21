package com.challenge.entity;

import com.challenge.SpringChallengeApplication;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(SpringChallengeApplication.class)
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "challenge")
    private List<Submission> submissions;

    @OneToMany(mappedBy = "challenge")
    private List<Acceleration> accelerations;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
