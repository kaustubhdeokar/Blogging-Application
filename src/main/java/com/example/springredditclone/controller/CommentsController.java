package com.example.springredditclone.controller;


import com.example.springredditclone.dto.CommentsDto;
import com.example.springredditclone.service.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/api/comments")
    public ResponseEntity<String> createComment(@RequestBody CommentsDto commentsDto) {
        commentsService.save(commentsDto);
        return new ResponseEntity<>("Comment added!", HttpStatus.OK);
    }

    @GetMapping("/api/comments/by-post/{postId}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
        return status(HttpStatus.OK)
                .body(commentsService.getAllCommentsForPost(postId));
    }

    @GetMapping("/api/comments/by-user/{userName}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsByUser(@PathVariable String userName){
        return status(HttpStatus.OK)
                .body(commentsService.getAllCommentsForUser(userName));
    }

}
