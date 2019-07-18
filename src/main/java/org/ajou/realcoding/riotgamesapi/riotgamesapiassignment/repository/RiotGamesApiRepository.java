package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RiotGamesApiRepository {
    @Autowired
    MongoTemplate mongoTemplate;


}

