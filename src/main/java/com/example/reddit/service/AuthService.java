package com.example.reddit.service;

import com.example.reddit.dto.AuthenticationResponse;
import com.example.reddit.dto.RegisterUser;
import com.example.reddit.exception.SpringRedditException;
import com.example.reddit.model.NotificationEmail;
import com.example.reddit.model.User;
import com.example.reddit.model.VerificationToken;
import com.example.reddit.repo.UserRepo;
import com.example.reddit.repo.VerificationTokenRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AuthService {

    @Autowired private MailService mailService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserRepo userRepo;
    @Autowired private VerificationTokenRepo tokenRepo;

    @Autowired private TokenService tokenService;
    @Autowired private AuthenticationManager authenticationManager;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void signup(RegisterUser registerUser) {

        User user = new User(registerUser.getUsername(), passwordEncoder.encode(registerUser.getPassword()),
                registerUser.getEmail());
        userRepo.save(user);
        logger.info("{}", "User saved.");

        String verificationToken = generateVerificationToken(user);
        mailService.sendEmail(new NotificationEmail("Account activation", user.getEmail(),
                formMailBody(verificationToken)));
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
        return verificationToken.orElseThrow(() -> new SpringRedditException("Invalid token"));
    }

    public void enableUserHavingToken(VerificationToken verificationToken) {
        User user = verificationToken.getUser();
        Optional<User> optionalUser = userRepo.findById(user.getUserid());
        if(!optionalUser.isPresent()){
            throw new SpringRedditException("User not present, invalid token");
        }
        User verifiedUser = optionalUser.get();
        verifiedUser.setEnabled(true);
        userRepo.save(verifiedUser);
    }

    public AuthenticationResponse loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            String token = tokenService.generateJwt(auth);
            return new AuthenticationResponse(userRepo.findByUsername(username).get(), token);
        } catch (AuthenticationServiceException e) {
            return new AuthenticationResponse(null, e.getMessage());
        }
        catch (DisabledException e){
            return new AuthenticationResponse(null, "User is disabled. Please verify the user.");
        }

    }
}
