package com.example.springredditclone.service;

import com.example.springredditclone.dto.CommentsDto;
import com.example.springredditclone.exception.PostNotFoundException;
import com.example.springredditclone.mapper.CommentMapper;
import com.example.springredditclone.model.Comment;
import com.example.springredditclone.model.NotificationEmail;
import com.example.springredditclone.model.Post;
import com.example.springredditclone.model.User;
import com.example.springredditclone.repo.CommentRepo;
import com.example.springredditclone.repo.PostRepo;
import com.example.springredditclone.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CommentsService {

    private final PostRepo postRepository;
    private final CommentRepo commentRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final MailService mailService;
    private final MailContentBuilder mailContentBuilder;
    private final UserRepo userRepo;

    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        User currentUser = authService.getCurrentUser();
        Comment comment = commentMapper.map(commentsDto, post, currentUser);
        commentRepository.save(comment);

        String message = mailContentBuilder.build(post.getUser().getUserName() + " posted a comment on your post." + "<url>");
        sendCommentNotification(message, post.getUser());
    }
    private void sendCommentNotification(String message, User user) {
        mailService.sendEmail(new NotificationEmail(user.getUserName() + " Commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post).stream().map(commentMapper::mapToDto).collect(Collectors.toList());

    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepo.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("no usere with username " + userName));
        return commentRepository.findAllByUser(user).stream().map(commentMapper::mapToDto).collect(Collectors.toList());
    }
}

