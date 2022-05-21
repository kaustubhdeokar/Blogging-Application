package com.example.springredditclone.exception;

public class SubredditNotFoundException extends RuntimeException {
    public SubredditNotFoundException(String s) {
        super(s);
    }
}
