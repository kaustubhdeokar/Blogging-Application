package com.example.reddit.dto;

import com.example.reddit.model.User;

public class AuthenticationResponse {

    private User user;
    private String jwt;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "user=" + user + ", jwt='" + jwt + '\'' + '}';
    }
}
