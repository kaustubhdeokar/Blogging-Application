package com.example.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import com.example.springredditclone.model.User;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    @NotBlank(message = "The postname cannot be empty")
    private String postName;

    @Nullable
    private String url;

    @Nullable @Lob
    private String description;

    private Integer voteCount;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private Instant createdDate;

    @ManyToOne
    @JoinColumn(name = "subreddit", referencedColumnName = "id")
    private Subreddit subreddit;

}
