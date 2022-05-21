package com.example.springredditclone.repo;

import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.User;
import com.example.springredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepo extends JpaRepository<Vote,Long> {

    Optional<Vote> findVoteByPostAndUser(Post post, User user);

}
