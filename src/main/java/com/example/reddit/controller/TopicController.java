package com.example.reddit.controller;

import com.example.reddit.dto.TopicDto;
import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import com.example.reddit.service.TopicService;
import com.example.reddit.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserDetailsServiceImpl userService;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody TopicDto topicDto) {
        User user = userService.getPrincipalUser();
        topicService.save(new Topic(topicDto.getName(), topicDto.getDescription(), user));
        return new ResponseEntity<>("Subreddit: " + topicDto.getName() + " created.", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TopicDto>> getAllSubreddits() {
        List<Topic> topics = topicService.getAll();
        List<TopicDto> toReturn = topics.stream().map(subreddit -> new TopicDto(subreddit.getName(), subreddit.getDescription())).collect(Collectors.toList());
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<TopicDto> getSubReddit(@PathVariable Long id) {
        TopicDto subReddit = topicService.getSubReddit(id);
        return new ResponseEntity<>(subReddit, HttpStatus.OK);
    }


}
