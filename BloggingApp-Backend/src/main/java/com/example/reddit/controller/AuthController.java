package com.example.reddit.controller;

import com.example.reddit.dto.*;
import com.example.reddit.model.User;
import com.example.reddit.model.VerificationToken;
import com.example.reddit.service.AuthService;
import com.example.reddit.service.RefreshTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterUserDto registerUserDto) {
        try {
            service.signup(registerUserDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Duplicate username/email.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registration done. Check mail to verify signup.", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        VerificationToken verificationToken = service.verifyToken(token);
        service.enableUserHavingToken(verificationToken);
        return new ResponseEntity<>("account verified.", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginRequestDto registerUserDTO) {
        return new ResponseEntity<>(service.loginUser(registerUserDTO.getUsername(), registerUserDTO.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/refresh/token")
    public ResponseEntity<AuthenticationResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        AuthenticationResponse authenticationResponse = service.refreshToken(refreshTokenRequest);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Logged out.");
    }

    @PostMapping("/add-topic")
    public ResponseEntity<String> addTopicForUser(@RequestBody UserTopicDto userTopicDto) {
        String username = userTopicDto.getUserName();
        String topicId = userTopicDto.getTopicName();
        if (service.addTopicForUser(username, topicId)) {
            return ResponseEntity.status(HttpStatus.OK).body("Topic added.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Topic already added.");
        }
    }

    @PostMapping("/remove-topic")
    public ResponseEntity<String> removeTopicForUser(@RequestBody UserTopicDto userTopicDto) {
        String username = userTopicDto.getUserName();
        String topicId = userTopicDto.getTopicName();
        service.removeTopicForUser(username, topicId);
        return ResponseEntity.status(HttpStatus.OK).body("Topic removed.");
    }

    @GetMapping("/get-roles/{username}")
    public ResponseEntity<String> getRolesForUser(@PathVariable String username) {
        service.getRolesForUser(username);
        return ResponseEntity.status(HttpStatus.OK).body("Roles queried.");
    }

    @GetMapping("/topics/{username}")
    public ResponseEntity<List<TopicDto>> getTopicsSubscribedByUser(@PathVariable String username) {
        User user = service.getUser(username);
        List<TopicDto> collect = user.getTopics().stream().map(topic -> new TopicDto(topic.getTopicid(), topic.getName(), topic.getDescription())).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(collect);
    }

    @GetMapping("/topic-ids/{username}")
    public ResponseEntity<List<Long>> getTopicIdSubscribedByUser(@PathVariable String username) {
        User user = service.getUser(username);
        List<Long> topicIds = user.getTopics().stream().map(topic -> topic.getTopicid()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(topicIds);
    }

}
