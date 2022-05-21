package com.example.springredditclone.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue
    private Long voteId;

    private VoteType voteType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
