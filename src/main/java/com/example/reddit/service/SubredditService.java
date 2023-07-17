package com.example.reddit.service;

import com.example.reddit.dto.SubredditDto;
import com.example.reddit.exception.SpringRedditException;
import com.example.reddit.model.Subreddit;
import com.example.reddit.repo.SubredditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubredditService {

    @Autowired
    private SubredditRepo subredditRepo;

    public void save(Subreddit subreddit) {
        subredditRepo.save(subreddit);
    }


    public List<Subreddit> getAll() {
        return subredditRepo.findAll();
    }

    public Subreddit getSubReddit(Long id) {
        return subredditRepo.findById(id)
                .orElseThrow(() -> new SpringRedditException("Subreddit not found with id -" + id));
    }

}
