package com.example.reddit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentsDto {
    private Long commentId;
    @NotBlank
    private String text;
    private Instant createdDate;
    private String userName;
    private Long postId;


}
