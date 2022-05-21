package com.example.springredditclone.repo;

import com.example.springredditclone.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubredditRepo extends JpaRepository<Subreddit,Long> {

    Optional<Subreddit> findByName(String subredditName);

}
