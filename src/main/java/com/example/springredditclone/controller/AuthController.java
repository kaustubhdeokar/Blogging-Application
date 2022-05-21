package com.example.springredditclone.controller;

import com.example.springredditclone.dto.AuthenticationResponse;
import com.example.springredditclone.dto.LoginRequest;
import com.example.springredditclone.dto.RegisterRequest;
import com.example.springredditclone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        System.out.println("Here in signup.");
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration successful!", HttpStatus.OK);

    }

    @PostMapping("/api/auth/login")
    public  ResponseEntity<String>  login(@RequestBody LoginRequest loginRequest) {
        //we should check if the account is verified or not.
        AuthenticationResponse login = authService.login(loginRequest);
        return new ResponseEntity<>(login.getAuthenticationToken(),HttpStatus.OK);
    }

    @GetMapping("/api/auth/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account verified!", HttpStatus.OK);
    }

}
