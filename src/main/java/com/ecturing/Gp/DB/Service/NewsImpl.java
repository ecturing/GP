package com.ecturing.Gp.DB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class NewsImpl implements News {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void insert() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {

    }
}
