package com.example.springredditclone.service;

import com.example.springredditclone.dto.VoteDto;
import com.example.springredditclone.exception.PostNotFoundException;
import com.example.springredditclone.exception.SpringRedditException;
import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.User;
import com.example.springredditclone.model.Vote;
import com.example.springredditclone.repo.PostRepo;
import com.example.springredditclone.repo.VoteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.springredditclone.model.VoteType.UPVOTE;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class VoteService {

    private final VoteRepo voteRepo;
    private final PostRepo postRepo;
    private final AuthService authService;

    public void vote(VoteDto voteDto) {

        Post post = postRepo.findById(voteDto.getPostId()).orElseThrow(() -> new PostNotFoundException("Not post with id" + voteDto.getPostId().toString()));
        User currentUser = authService.getCurrentUser();
        Optional<Vote> voteByPostAndUser = voteRepo.findVoteByPostAndUser(post, currentUser);

        if (voteByPostAndUser.isPresent() && voteByPostAndUser.get().getVoteType().equals(voteDto.getVoteType())) {
            throw new SpringRedditException("You have already "
                    + voteDto.getVoteType() + "'d for this post");
        }

        if (UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount()==null?0:post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount()==null?0:post.getVoteCount() - 1);
        }

        Vote vote = mapToVote(voteDto, post);
        voteRepo.save(vote);

        postRepo.save(post);

    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}
