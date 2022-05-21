package com.example.springredditclone.controller;

import com.example.springredditclone.dto.SubredditDto;
import com.example.springredditclone.model.Subreddit;
import com.example.springredditclone.service.SubredditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class SubredditController {

    private final SubredditService subredditService;

    @GetMapping("/api/subreddit")
    public List<SubredditDto> getSubreddits() {
        return subredditService.getAll();
    }

    @GetMapping("/api/subreddit/{id}")
    public SubredditDto getSubreddit(@PathVariable Long id) {
        return subredditService.getSubReddit(id);
    }

    @PostMapping("/api/subreddit")
    public ResponseEntity<String> create(@RequestBody @Valid SubredditDto subRedditDto) {
        SubredditDto save = subredditService.save(subRedditDto);
        return new ResponseEntity<String>(save.getDescription() +""+save.getName(), HttpStatus.OK);
    }


}
