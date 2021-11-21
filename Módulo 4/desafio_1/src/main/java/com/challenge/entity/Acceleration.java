package com.challenge.entity;

import com.challenge.SpringChallengeApplication;
import org.springframework.data.annotation.CreatedDate;
import sun.security.util.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(SpringChallengeApplication.class)
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "acceleration")
    private List<Candidate> candidates;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
