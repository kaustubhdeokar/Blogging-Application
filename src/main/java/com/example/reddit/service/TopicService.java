package com.example.reddit.service;

import com.example.reddit.dto.TopicDto;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Topic;
import com.example.reddit.repo.TopicRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicService {

    private ModelMapper modelMapper;

    public TopicService() {
        this.modelMapper = new ModelMapper();
    }

    @Autowired
    private TopicRepo topicRepo;

    public void save(Topic topic) {
        topicRepo.save(topic);
    }


    public List<Topic> getAll() {
        return topicRepo.findAll();
    }

    public TopicDto getSubReddit(Long id) {
        Topic topic = topicRepo.findById(id).orElseThrow(() -> new CustomException("Subreddit not found with id -" + id));
        return modelMapper.map(topic, TopicDto.class);
    }

}
