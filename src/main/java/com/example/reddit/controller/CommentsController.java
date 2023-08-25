package com.example.reddit.controller;

import com.example.reddit.dto.CommentsDto;
import com.example.reddit.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @PostMapping("")
    public ResponseEntity<Void> createComment(@RequestBody CommentsDto commentsDto) {
        commentsService.save(commentsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
        return status(HttpStatus.OK)
                .body(commentsService.getAllCommentsForPost(postId));
    }

    @GetMapping("/by-user/{userName}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsByUser(@PathVariable String userName){
        return status(HttpStatus.OK)                .body(commentsService.getAllCommentsForUser(userName));
    }
}
