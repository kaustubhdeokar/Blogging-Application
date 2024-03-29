package com.example.reddit.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue
    private Long voteId;

    private int voteType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postid", referencedColumnName = "postid")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    public Vote(int voteType, Post post, User user) {
        this.voteType = voteType;
        this.post = post;
        this.user = user;
    }
}
