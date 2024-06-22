package com.example.reddit.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "token")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String token;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    private Instant expiryDate;

    Instant now = Instant.now();
    public static final Instant THREE_DAYS_FROM_TODAY = Instant.now().plus(3, ChronoUnit.DAYS);

    public VerificationToken() {
    }

    public VerificationToken(String token, User user, Instant expiryDate) {
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }
}
