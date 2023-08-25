package com.example.reddit.controller;

import com.example.reddit.dto.AuthenticationResponse;
import com.example.reddit.dto.LoginRequest;
import com.example.reddit.dto.RefreshTokenRequest;
import com.example.reddit.dto.RegisterUser;
import com.example.reddit.model.VerificationToken;
import com.example.reddit.service.AuthService;
import com.example.reddit.service.RefreshTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private RefreshTokenService refreshTokenService;

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
    public AuthenticationResponse loginUser(@RequestBody LoginRequest registerUserDTO) {
        return service.loginUser(registerUserDTO.getUsername(), registerUserDTO.getPassword());
    }

    @PostMapping("/refresh/token")
    public ResponseEntity<String> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        AuthenticationResponse authenticationResponse = service.refreshToken(refreshTokenRequest);
        return new ResponseEntity<>(authenticationResponse.toString(), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Logged out.");
    }


}
