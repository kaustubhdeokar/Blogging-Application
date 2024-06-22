package com.example.reddit.service;

import com.example.reddit.dto.CommentsDto;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.Comment;
import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.repo.CommentRepo;
import com.example.reddit.repo.PostRepo;
import com.example.reddit.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CommentsService {

    @Autowired
    private PostRepo postRepository;
    private final CommentRepo commentRepository;
    @Autowired
    private final UserDetailsServiceImpl userService;
    @Autowired
    private final MailService mailService;
    private final MailContentBuilder mailContentBuilder;
    @Autowired
    private UserRepo userRepo;

    public void save(CommentsDto commentsDto) {

        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(() -> new CustomException(commentsDto.getPostId().toString()));
        User currentUser = userService.getPrincipalUser();
        Comment comment = new Comment(commentsDto.getText(), currentUser, post);
        commentRepository.save(comment);
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(postId.toString()));
        return commentRepository.findByPost(post).stream().map(this::getCommentDtoFromComment).collect(Collectors.toList());

    }

    public CommentsDto getCommentDtoFromComment(Comment comment) {
        return new CommentsDto(comment.getCommentid(), comment.getPost().getPostid(), comment.getText(), comment.getUser().getUsername());
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepo.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("no usere with username " + userName));
        return commentRepository.findAllByUser(user).stream().map(this::getCommentDtoFromComment).collect(Collectors.toList());
    }
}

