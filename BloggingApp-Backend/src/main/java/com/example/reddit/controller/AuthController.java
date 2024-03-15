package com.example.reddit.controller;

import com.example.reddit.dto.AuthenticationResponse;
import com.example.reddit.dto.LoginRequestDto;
import com.example.reddit.dto.RefreshTokenRequest;
import com.example.reddit.dto.RegisterUserDto;
import com.example.reddit.model.VerificationToken;
import com.example.reddit.service.AuthService;
import com.example.reddit.service.RefreshTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
