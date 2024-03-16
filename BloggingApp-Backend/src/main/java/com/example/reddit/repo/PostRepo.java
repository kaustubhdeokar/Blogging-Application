package com.example.reddit.repo;

import com.example.reddit.model.Post;
import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByTopic(Topic topic);

    List<Post> findAllByUser(User user);
}
