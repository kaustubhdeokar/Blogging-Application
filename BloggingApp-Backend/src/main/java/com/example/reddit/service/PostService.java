package com.example.reddit.service;

import com.example.reddit.dto.PostRequestDto;
import com.example.reddit.dto.PostResponse;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Post;
import com.example.reddit.model.Topic;
import com.example.reddit.model.User;
import com.example.reddit.repo.PostRepo;
import com.example.reddit.repo.TopicRepo;
import com.example.reddit.repo.UserRepo;
import com.example.reddit.repo.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private AuthService authService;

    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VoteRepo voteRepo;

    public PostResponse getPost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new CustomException("No post found for id:" + id));
        return getPostResponse(post);
    }

    public PostResponse getPostResponse(Post post) {
        return new PostResponse(post.getPostid(), post.getPostname(),
                post.getUrl(), post.getDescription(), post.getUser().getUsername(),
                post.getTopic().getName(), post.getVotecount(), 0, post.getCreateddate().toString(), post.getVotecount(), 0);
    }


    public List<PostResponse> getAll() {
        return postRepo.findAll().stream().map(this::getPostResponse).collect(Collectors.toList());
    }

    public void save(PostRequestDto postRequestDto) {
        Topic topic = topicRepo.findByName(postRequestDto.getTopicName())
                .orElseThrow(() -> new CustomException(postRequestDto.getTopicName()));
//        voteRepo.findVoteByPostAndUser(postRequest.getPostName(), userService.getPrincipalUser());
        postRepo.save(new Post(postRequestDto.getPostName(), postRequestDto.getUrl(),
                postRequestDto.getDescription(), userService.getPrincipalUser(), topic));
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

    public List<PostResponse> getPostsFromSubscribedTopics(String name) {

        User user = userRepo.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException(name));
        List<Long> topicIds = user.getTopics().stream().map(topic -> topic.getTopicid()).collect(Collectors.toList());
        List<PostResponse> allSubscribedPosts = new ArrayList<>();
        Set<Long> collect = topicIds.stream().collect(Collectors.toSet());
        for (Long topicId : collect) {
            allSubscribedPosts.addAll(getPostsByTopic(topicId));
        }
        return allSubscribedPosts;
    }
}