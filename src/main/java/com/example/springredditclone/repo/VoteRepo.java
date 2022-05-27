package com.example.springredditclone.repo;

import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.User;
import com.example.springredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VoteRepo extends JpaRepository<Vote,Long> {

    Optional<Vote> findVoteByPostAndUser(Post post, User user);

}
