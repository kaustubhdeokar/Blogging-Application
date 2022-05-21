package com.example.springredditclone.repo;

import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.Subreddit;
import com.example.springredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Long> {

    Optional<Post> findAllBySubreddit(Subreddit subreddit);

    Optional<Post> findAllByUser(User user);
}
