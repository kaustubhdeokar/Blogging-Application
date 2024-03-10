package com.example.reddit.service;

import com.example.reddit.dto.PostRequest;
import com.example.reddit.dto.PostResponse;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Post;
import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import com.example.reddit.repo.PostRepo;
import com.example.reddit.repo.TopicRepo;
import com.example.reddit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private UserRepo userRepo;

    public PostResponse getPost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new CustomException("No post found for id:" + id));
        return getPostResponse(post);
    }

    public PostResponse getPostResponse(Post post) {
        return new PostResponse(post.getPostid(), post.getPostname(),
                post.getUrl(), post.getDescription(), post.getUser().getUsername(),
                post.getTopic().getName(), 0, 0, "0",0,0);
    }


    public List<PostResponse> getAll() {
        return postRepo.findAll().stream().map(this::getPostResponse).collect(Collectors.toList());
    }

    public void save(PostRequest postRequest) {
        Topic topic = topicRepo.findByName(postRequest.getTopicName())
                .orElseThrow(() -> new CustomException(postRequest.getTopicName()));
        postRepo.save(new Post(postRequest.getPostName(), postRequest.getUrl(),
                postRequest.getDescription(), userService.getPrincipalUser(), topic));
    }


    public List<PostResponse> getPostsByTopic(Long id) {
        Topic topic = topicRepo.findById(id)
                .orElseThrow(() -> new CustomException(id.toString()));
        List<Post> posts = postRepo.findAllByTopic(topic);
        return posts.stream().map(this::getPostResponse).collect(Collectors.toList());
    }

    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepo.findAllByUser(user).stream()
                .map(this::getPostResponse).collect(Collectors.toList());
    }
}