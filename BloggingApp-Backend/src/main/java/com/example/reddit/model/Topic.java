package com.example.reddit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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

    @JsonIgnore
    @ManyToMany(mappedBy = "topics")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User createdby;

    public Topic(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.posts = new ArrayList<>();
        this.createddate = Instant.now();
        this.createdby = user;
    }

    @Override
    public String toString() {
        return "id=" + topicid + ", name='" + name + '\'' + '}';
    }
}
