package com.example.reddit.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "comments")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDocument {

    @Id
    public Long postId;
    private List<Comment> commentList;

}
