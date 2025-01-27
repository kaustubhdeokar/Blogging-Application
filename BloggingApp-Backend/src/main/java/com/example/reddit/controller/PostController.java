package com.example.reddit.controller;

import com.example.reddit.dto.PostRequestDto;
import com.example.reddit.dto.PostResponse;
import com.example.reddit.service.PostService;
import com.example.reddit.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private TopicService topicService;

    @PostMapping("")
    public ResponseEntity<Void> createPosts(@RequestBody PostRequestDto postRequestDto) {
        postService.save(postRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> allPosts = postService.getAll().stream().collect(Collectors.toList());
        return status(HttpStatus.OK).body(allPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    @GetMapping("/by-topic/{id}")
    public ResponseEntity<List<PostResponse>> getPostsByTopic(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPostsByTopic(id));
    }

    @GetMapping("/by-topic-name/{name}")
    public ResponseEntity<List<PostResponse>> getPostsByTopicName(@PathVariable String name) {
        Long topicId = topicService.getTopicByName(name);
        List<PostResponse> postsByTopic = postService.getPostsByTopic(topicId);
        return status(HttpStatus.OK).body(postsByTopic);
    }

    @GetMapping("/by-user/{name}")
    public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String name) {
        return status(HttpStatus.OK).body(postService.getPostsFromSubscribedTopics(name));
    }

}
