package com.example.reddit.model;

import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @org.springframework.data.annotation.Transient
    public static final String ID_VAL = "sequence_generator";
    @org.springframework.data.annotation.Transient
    public static final String GENERATED_ID = "commentId";
    @org.springframework.data.annotation.Transient
    public static final String ID_KEY = "id";
    @Id
    private Long commentId;
    private String text;
    private Instant createddate;
    private String username;
    private Long postId;

    public Comment(Long commentId, String text, String user, Long postId) {
        this.commentId = commentId;
        this.text = text;
        this.createddate = Instant.now();
        this.username = user;
        this.postId = postId;
    }
}
