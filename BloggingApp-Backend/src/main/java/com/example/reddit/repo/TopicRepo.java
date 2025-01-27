package com.example.reddit.repo;

import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepo extends JpaRepository<Topic, Long> {

    Optional<Topic> findByName(String topicName);

}
