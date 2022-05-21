package com.example.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {

    @Id
    @GeneratedValue
    private Long id;
    private String token;

    @OneToOne(fetch = LAZY)
    private User user;
    private Instant employee;

}
