package com.example.springredditclone.service;

import com.example.springredditclone.dto.AuthenticationResponse;
import com.example.springredditclone.dto.LoginRequest;
import com.example.springredditclone.dto.RegisterRequest;
import com.example.springredditclone.exception.SpringRedditException;
import com.example.springredditclone.model.NotificationEmail;
import com.example.springredditclone.model.User;
import com.example.springredditclone.model.VerificationToken;
import com.example.springredditclone.repo.UserRepo;
import com.example.springredditclone.repo.VerificationTokenRepo;
import com.example.springredditclone.security.JWTProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final MailService mailService;
    private final VerificationTokenRepo verificationTokenRepo;
    private final String ACCOUNT_ACTIVATION = "Please activate your account";

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        createUser(user, registerRequest);
        userRepo.save(user);
        System.out.println("User saved.");
        String token = generateVerificationToken(user);
        mailService.sendEmail(new NotificationEmail(ACCOUNT_ACTIVATION, user.getEmail(), formMailBody(token)));
    }

    @Transactional
    public void verifyAccount(String token) {
        Optional<VerificationToken> byToken = verificationTokenRepo.findByToken(token);
        VerificationToken verificationToken = byToken.orElseThrow(() -> new SpringRedditException("token invalid!"));
        System.out.println("Token found!");
        String username = verificationToken.getUser().getUserName();
        User user = userRepo.findByUserName(username).orElseThrow(() -> new SpringRedditException("invalid user!"));
        user.setEnabled(true);
        userRepo.save(user);
    }

    private String formMailBody(String token) {
        return "Thank you for signing up, please click on the url to activate your account:" +
                "http://localhost:8080/api/auth/accountVerification/" + token + ":";
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepo.save(verificationToken);
        System.out.println("Verification token repo saved");
        return token;
    }

    public void createUser(User user, RegisterRequest registerRequest) {
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);
    }

    public AuthenticationResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new AuthenticationResponse(token,request.getUserName());
    }



}
