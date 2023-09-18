package com.example.reddit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long commentid;

    private String text;

    private Instant createddate;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    @ManyToOne
    private Post post;

    public Comment(String text, User user, Post post) {
        this.text = text;
        this.createddate = Instant.now();
        this.user = user;
        this.post = post;
    }
}
