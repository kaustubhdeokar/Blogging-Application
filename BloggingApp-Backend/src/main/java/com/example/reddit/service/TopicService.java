package com.example.reddit.service;

import com.example.reddit.dto.TopicDto;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import com.example.reddit.repo.TopicRepo;
import com.example.reddit.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TopicService {

    private ModelMapper modelMapper;

    public TopicService() {
        this.modelMapper = new ModelMapper();
    }

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private UserRepo userRepo;

    public void save(Topic topic) {
        topicRepo.save(topic);
    }


    public List<Topic> getAll() {
        return topicRepo.findAll();
    }

    public TopicDto getTopic(Long id) {
        Topic topic = topicRepo.findById(id).orElseThrow(() -> new CustomException("Topic not found with id -" + id));
        return modelMapper.map(topic, TopicDto.class);
    }

    public Long getTopicByName(String name) {
        Topic topic = topicRepo.findByName(name).orElseThrow(() -> new CustomException("Topic not found with name -" + name));
        return topic.getTopicid();
    }

//    public void getTopicsSubscribedByUser(String username) {
//        User user = userRepo.findByUsername(username).orElseThrow(() -> new CustomException("User not found with id -" + username));
//        topicRepo.findUsersById()
//    }

}
