package com.example.reddit.repo;

import com.example.reddit.model.CommentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepo extends MongoRepository<CommentDocument, Long> {
    Optional<CommentDocument> findByPostId(Long postId);

}
