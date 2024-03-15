package com.example.reddit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Data
@Table(name = "topic")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue
    private Long topicid;

    @NotBlank(message = "Community name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Post> posts;

    private Instant createddate;

    @ManyToOne
    private User user;

    public Topic(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.posts = new ArrayList<>();
        this.createddate = Instant.now();
        this.user = user;
    }

    @Override
    public String toString() {
        return "id=" + topicid + ", name='" + name + '\'' + '}';
    }
}
