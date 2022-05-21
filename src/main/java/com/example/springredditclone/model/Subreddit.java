package com.example.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.SEQUENCE;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @NotBlank(message = "Community name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @OneToMany(fetch = LAZY)
    private List<Post> posts;

    private Instant createdDate;

    @ManyToOne
    private User user;
}
