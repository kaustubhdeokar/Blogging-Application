package com.example.reddit.service;

import com.example.reddit.repo.IdSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class IdGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Long getCommentsId(String collectionId, String collectionIdVal, String generatedIdValue) {

        Query query = new Query(Criteria.where(collectionId).is(collectionIdVal));
        //update the sequence no
        Update update = new Update().inc(generatedIdValue, 1);
        //modify in document

        IdSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        IdSequence.class);

        return Objects.isNull(counter) ? 1 : counter.getCommentId();
    }

}
