package com.example.reddit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication auth) {

        //String scope = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
        //.collect(Collectors.joining(" "));
        //todo: set roles - admin, user. hardcoded to user for now.

        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(Instant.now().plusMillis(1000000000))
                .subject(auth.getName())
                .claim("roles", "ROLE_USER")
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String generateJwt(String username) {

        //String scope = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
        //.collect(Collectors.joining(" "));
        //todo: set roles - admin, user. hardcoded to user for now.

        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(Instant.now().plusMillis(1000000000))
                .subject(username)
                .claim("roles", "ROLE_USER")
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public Long getJwtExpirationInMillis() {
        return 1000000000L;
    }


}
