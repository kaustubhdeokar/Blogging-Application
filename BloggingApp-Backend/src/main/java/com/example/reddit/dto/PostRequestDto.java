package com.example.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {

    private String postName;
    private String topicName;
    private String url;
    private String description;


}