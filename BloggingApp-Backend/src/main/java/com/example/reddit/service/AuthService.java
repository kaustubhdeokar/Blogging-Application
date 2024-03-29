package com.example.reddit.service;

import com.example.reddit.dto.AuthenticationResponse;
import com.example.reddit.dto.RefreshTokenRequest;
import com.example.reddit.dto.RegisterUserDto;
import com.example.reddit.exception.CustomException;
import com.example.reddit.model.*;
import com.example.reddit.repo.RoleRepo;
import com.example.reddit.repo.TopicRepo;
import com.example.reddit.repo.UserRepo;
import com.example.reddit.repo.VerificationTokenRepo;
import com.example.reddit.security.JwtTokenProvider;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;

@Service
@Transactional
@Getter
public class AuthService {
    @Autowired
    private MailService mailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private VerificationTokenRepo tokenRepo;
    @Autowired
    private JwtTokenProvider jwtProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RefreshTokenService refreshTokenService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean signup(RegisterUserDto registerUserDto) throws DataIntegrityViolationException {

        checkIfUserAlreadyExists(registerUserDto);

        List<Role> roles = new ArrayList<>();
        Role roleUser = roleRepo.findByName("ROLE_USER");
        if (roleUser == null) {
            roleRepo.save(new Role("ROLE_USER", List.of()));
        }
        roles.add(roleRepo.findByName("ROLE_USER"));

        User user = new User(registerUserDto.getUsername(),
                passwordEncoder.encode(registerUserDto.getPassword()),
                registerUserDto.getEmail(), roles);
        userRepo.save(user);
        logger.info("{}", "User saved.");

        String verificationToken = generateVerificationToken(user);
        mailService.sendEmail(new NotificationEmail("Account activation", user.getEmail(), formMailBody(verificationToken)));
        return true;
    }

    private void checkIfUserAlreadyExists(RegisterUserDto registerDto) {
        String username = registerDto.getUsername();
        if (userRepo.existsByUsername(username)) {
            throw new CustomException(HttpStatus.BAD_REQUEST,
                    String.format("Username %s exists in the database", username));
        }
        String email = registerDto.getEmail();
        if (userRepo.existsByEmail(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST,
                    String.format("Email %s exists in the database", email));
        }

    }

    private String formMailBody(String token) {
        return "Thank you for signing up, please click on the url to activate your account:\n" +
                "http://localhost:8080/api/auth/accountVerification/" + token;
    }

    private String generateVerificationToken(User user) {
        String generatedToken = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(generatedToken, user, VerificationToken.THREE_DAYS_FROM_TODAY);
        tokenRepo.save(verificationToken);
        logger.info("{}", "Token saved.");
        return generatedToken;
    }

    public VerificationToken verifyToken(String token) {
        Optional<VerificationToken> verificationToken = tokenRepo.findByToken(token);
        return verificationToken.orElseThrow(() -> new CustomException("Invalid token"));
    }

    public void enableUserHavingToken(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepo.findByUsername(username).orElseThrow(() -> new CustomException("User not present, invalid token"));
        user.setEnabled(true);
        userRepo.save(user);
    }

    public AuthenticationResponse loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String jwtToken = jwtProvider.generateToken(auth);
            String refreshToken = refreshTokenService.generateRefreshToken().getToken();
            Instant expiry = Instant.now().plusMillis(jwtProvider.getExpirationDate());
            return new AuthenticationResponse(username, jwtToken, refreshToken, expiry);
        } catch (AuthenticationServiceException e) {
            return new AuthenticationResponse(null, e.getMessage(), null, null);
        } catch (DisabledException e) {
            return new AuthenticationResponse(null, "User is disabled. Please verify the user.", null, null);
        }

    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateToken(refreshTokenRequest.getUsername());
        String refreshToken = refreshTokenRequest.getRefreshToken();
        Instant expiry = Instant.now().plusMillis(jwtProvider.getExpirationDate());
        return new AuthenticationResponse(refreshTokenRequest.getUsername(), token, refreshToken, expiry);
    }

    public boolean addTopicForUser(String username, String topicName) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new CustomException("User not found with id -" + username));
        Topic topic = topicRepo.findByName(topicName).orElseThrow(() -> new CustomException("User not found with id -" + username));
        List<Topic> topics = user.getTopics();
        if (!topics.contains(topic)) {
            user.getTopics().add(topic);
            userRepo.save(user);
            return true;
        }
        return false;
    }


    public void removeTopicForUser(String username, String topicName) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new CustomException("User not found with id -" + username));
        Topic topic = topicRepo.findByName(topicName).orElseThrow(() -> new CustomException("User not found with id -" + username));
        List<Topic> topics = user.getTopics();
        if (topics.contains(topic)) {
            user.getTopics().remove(topic);
            userRepo.save(user);
        }
    }

    public User getUser(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new CustomException("User not found with id -" + username));
    }


    public void getRolesForUser(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new CustomException("User not found with id -" + username));
        Optional<List<Object[]>> rolesByUserid = userRepo.findRolesByUserid(user.getUserid());
        for (Object role : rolesByUserid.get()) {
            System.out.println(role);
        }
    }
}
