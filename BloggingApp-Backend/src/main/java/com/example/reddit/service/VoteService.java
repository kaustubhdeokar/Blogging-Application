package com.example.reddit.service;

import com.example.reddit.dto.VoteDto;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import com.example.reddit.model.VoteType;
import com.example.reddit.repo.PostRepo;
import com.example.reddit.repo.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VoteService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private VoteRepo voteRepo;

    public void vote(VoteDto voteDto) {

        Post post = postRepo.findById(voteDto.getPostId()).orElseThrow(() -> new CustomException("Not post with id" + voteDto.getPostId().toString()));
        User currentUser = userService.getPrincipalUser();

        post.setVotecount(post.getVotecount() == null ? 1 : post.getVotecount() + voteDto.getVoteType());

        Vote vote = new Vote(voteDto.getVoteType(), post, currentUser);
        voteRepo.save(vote);
        postRepo.save(post);

    }
}
