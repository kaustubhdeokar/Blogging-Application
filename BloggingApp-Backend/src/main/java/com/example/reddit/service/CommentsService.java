package com.example.reddit.service;

import com.example.reddit.dto.CommentsDto;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Comment;
import com.example.reddit.model.CommentDocument;
import com.example.reddit.model.User;
import com.example.reddit.repo.CommentRepo;
import com.example.reddit.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CommentsService {
    @Autowired
    private CommentRepo commentRepository;
    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private IdGeneratorService idGeneratorService;
    @Autowired
    private UserRepo userRepo;

    public void addCommentToPost(CommentsDto commentsDto) {

        Optional<CommentDocument> commentsForPost = commentRepository.findByPostId(commentsDto.getPostId());
        CommentDocument commentDocument = getCommentsDocument(commentsDto, commentsForPost);
        User currentUser = userService.getPrincipalUser();
        Comment newComment = new Comment(generateCommentId(), commentsDto.getText(), currentUser.getUsername(), commentsDto.getPostId());
        commentDocument.getCommentList().add(newComment);
        commentRepository.save(commentDocument);
    }

    private CommentDocument getCommentsDocument(CommentsDto commentsDto, Optional<CommentDocument> commentsForPost) {
        return commentsForPost.orElseGet(() -> createCommentDocumentForPostId(commentsDto.getPostId()));
    }

    private CommentDocument createCommentDocumentForPostId(Long postId) {
        return new CommentDocument(postId, new ArrayList<Comment>());
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        CommentDocument commentDocument = commentRepository.findByPostId(postId).orElseThrow(() -> new CustomException("Post does not exist."));
        return commentDocument.getCommentList().stream().map(this::getCommentDtoFromComment).collect(Collectors.toList());
    }

    public Long generateCommentId() {
        return idGeneratorService.getCommentsId(Comment.ID_KEY, Comment.ID_VAL, Comment.GENERATED_ID);
    }

    public CommentsDto getCommentDtoFromComment(Comment comment) {
        return new CommentsDto(comment.getCommentId(), comment.getText(), comment.getCreateddate(), comment.getUsername(), comment.getPostId());
    }

}

