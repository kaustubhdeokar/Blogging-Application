package com.example.reddit.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Service
@Getter
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private long expirationDate;

    public String generateToken(Authentication authentication) {
        return generateToken(authentication.getName());
    }

    public String generateToken(String name) {
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + expirationDate);

        return Jwts.builder().
                setSubject(name)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, getKey())
                .compact();
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtSecret));
    }

    public String getUsernameFromJWTToken(String token) {
        return Jwts.parser()
                .setSigningKey(getKey())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(HttpServletResponse response, String token) throws IOException {
        try {
            Jwts.parser()
                    .setSigningKey(getKey())
                    .parse(token);
        } catch (JwtException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return true;
    }

}