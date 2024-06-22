package com.example.reddit.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ServiceUtils {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
