package com.example.reddit.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long postid;

    @NotBlank(message = "postname cannot be empty.")
    private String postname;

    @Nullable
    private String url;

    @Nullable
    @Lob
    private String description;

    private Integer votecount;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private Instant createddate;

    @ManyToOne
    @JoinColumn(name = "subreddit", referencedColumnName = "id")
    private Subreddit subreddit;

    public Post(String postname, String url, String description, User user, Subreddit subreddit) {
        this.postname = postname;
        this.url = url;
        this.description = description;
        this.user = user;
        this.subreddit = subreddit;
    }

    public Integer getVotecount() {
        return votecount;
    }

    public void setVotecount(Integer votecount) {
        this.votecount = votecount;
    }
}
