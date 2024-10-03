package com.example.reddit.repo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "id_sequence")
@Getter
@Setter
public class FormIdSequence {

    @Id
    private String id;
    private Long formId;

}
