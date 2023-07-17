package com.example.reddit.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class SampleController {

    @GetMapping("/path1")
    public String path1Entry() {
        return "path 1 access";
    }

    @GetMapping("/path2")
    public String path2Entry() {
        return "path 2 access";
    }



}

