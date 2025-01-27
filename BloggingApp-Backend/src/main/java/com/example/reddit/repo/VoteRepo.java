package com.example.reddit.repo;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VoteRepo extends JpaRepository<Vote,Long> {

    Optional<Vote> findVoteByPostAndUser(Post post, User user);

}
