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
        return new ResponseEntity<>("Topic: " + topicDto.getName() + " created.", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TopicDto>> getAllTopics() {
        List<Topic> topics = topicService.getAll();
        List<TopicDto> toReturn = topics.stream().map(topic -> new TopicDto(topic.getTopicid(), topic.getName(), topic.getDescription())).collect(Collectors.toList());
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<TopicDto> getTopic(@PathVariable Long id) {
        TopicDto topic = topicService.getTopic(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping("/get-id/{name}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Long> getTopicIdByName(@PathVariable String name) {
        Long topicId = topicService.getTopicByName(name);
        return new ResponseEntity<>(topicId, HttpStatus.OK);
    }

    @GetMapping("/get-name/{topicId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> getTopicNameById(@PathVariable Long topicId) {
        TopicDto topic = topicService.getTopic(topicId);
        return new ResponseEntity<>(topic.getName(), HttpStatus.OK);
    }

}
