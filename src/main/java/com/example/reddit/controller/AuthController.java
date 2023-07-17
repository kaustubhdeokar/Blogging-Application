package com.example.reddit.controller;

import com.example.reddit.dto.AuthenticationResponse;
import com.example.reddit.dto.LoginRequest;
import com.example.reddit.dto.RegisterUser;
import com.example.reddit.model.VerificationToken;
import com.example.reddit.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterUser registerUser) {
        service.signup(registerUser);
        return new ResponseEntity<>("registeration done.", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        VerificationToken verificationToken = service.verifyToken(token);
        service.enableUserHavingToken(verificationToken);
        return new ResponseEntity<>("account verified.", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest registerUserDTO) {
        AuthenticationResponse authenticationResponse = service.loginUser(registerUserDTO.getUserName(), registerUserDTO.getPassword());
        return new ResponseEntity<>(authenticationResponse.getJwt(), HttpStatus.OK);
    }

}
