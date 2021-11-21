package com.challenge.entity;

import com.challenge.SpringChallengeApplication;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(SpringChallengeApplication.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Candidate> cadidates;

    @OneToMany(mappedBy = "user")
    private List<Submission> submissions;

    @NotNull
    @Size(max = 100)
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;

    public User() {
    }
}
