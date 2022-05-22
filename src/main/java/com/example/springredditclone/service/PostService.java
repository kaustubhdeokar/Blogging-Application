package com.example.springredditclone.service;

import com.example.springredditclone.dto.PostRequest;
import com.example.springredditclone.dto.PostResponse;
import com.example.springredditclone.exception.PostNotFoundException;
import com.example.springredditclone.exception.SubredditNotFoundException;
import com.example.springredditclone.mapper.PostMapper;
import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.Subreddit;
import com.example.springredditclone.model.User;
import com.example.springredditclone.repo.PostRepo;
import com.example.springredditclone.repo.SubredditRepo;
import com.example.springredditclone.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final SubredditRepo subredditRepo;
    private final PostMapper postMapper;
    private final AuthService authService;
    private final UserRepo userRepo;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException("No post found for id:" + id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAll() {
        return postRepo.findAll().stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    public void save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepo.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
        postRepo.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubreddit(Long id) {
        Subreddit subreddit = subredditRepo.findById(id)
                .orElseThrow(() -> new SubredditNotFoundException(id.toString()));
        List<Post> posts = postRepo.findAllBySubreddit(subreddit);
        return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepo.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepo.findAllByUser(user).stream()
                .map(postMapper::mapToDto).collect(Collectors.toList());
    }
}
