package com.example.reddit.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private String message;

    public CustomException(String s) {
        super(s);
    }

    public CustomException() {
    }

    public CustomException(HttpStatus status, String msg) {
        super(msg);
        this.message = msg;
    }
}
