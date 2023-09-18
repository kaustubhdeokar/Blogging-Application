package com.example.reddit.repo;

import com.example.reddit.model.Comment;
import com.example.reddit.model.Post;
import com.example.reddit.model.Subreddit;
import com.example.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findAllByUser(User user);
}
