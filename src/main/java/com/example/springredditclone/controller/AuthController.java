package com.example.springredditclone.controller;

import com.example.springredditclone.dto.AuthenticationResponse;
import com.example.springredditclone.dto.LoginRequest;
import com.example.springredditclone.dto.RefreshTokenRequest;
import com.example.springredditclone.dto.RegisterRequest;
import com.example.springredditclone.service.AuthService;
import com.example.springredditclone.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller

@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        System.out.println("Here in signup.");
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration successful!", HttpStatus.OK);

    }

    @PostMapping("/api/auth/login")
    public  ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        //we should check if the account is verified or not.
        AuthenticationResponse login = authService.login(loginRequest);
        return new ResponseEntity<>(login.toString(),HttpStatus.OK);
    }

    @GetMapping("/api/auth/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account verified!", HttpStatus.OK);
    }

    @PostMapping("/api/auth/refresh/token")
    public ResponseEntity<String> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        AuthenticationResponse authenticationResponse = authService.refreshToken(refreshTokenRequest);
        return new ResponseEntity<>(authenticationResponse.toString(), HttpStatus.OK);
    }

    @PostMapping("/api/auth/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return new ResponseEntity<>("Token deleted successfully.", HttpStatus.OK);
    }


}
