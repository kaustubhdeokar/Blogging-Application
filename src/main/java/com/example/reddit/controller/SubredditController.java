package com.example.reddit.controller;

import com.example.reddit.dto.SubredditDto;
import com.example.reddit.model.Subreddit;
import com.example.reddit.model.User;
import com.example.reddit.service.SubredditService;
import com.example.reddit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/subreddit")
public class SubredditController {

    @Autowired
    private SubredditService subredditService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody SubredditDto subRedditDto) {
        User user = userService.getPrincipalUser();
        subredditService.save(new Subreddit(subRedditDto.getName(), subRedditDto.getDescription(), user));
        return new ResponseEntity<>("Subreddit: " + subRedditDto.getName() + " created.", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubredditDto>> getAllSubreddits() {
        List<Subreddit> subreddits = subredditService.getAll();
        List<SubredditDto> toReturn = subreddits.stream().map(subreddit -> new SubredditDto(subreddit.getName(), subreddit.getDescription())).collect(Collectors.toList());
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Subreddit> getSubReddit(@PathVariable Long id) {
        return new ResponseEntity<>(subredditService.getSubReddit(id), HttpStatus.OK);
    }


}
