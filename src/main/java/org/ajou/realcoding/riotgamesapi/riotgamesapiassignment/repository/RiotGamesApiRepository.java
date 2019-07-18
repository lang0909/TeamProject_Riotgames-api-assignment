package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
//import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RiotGamesApiRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertLeague(League league){ mongoTemplate.insert(league);};

//    public League findLeague(String encryptedid){
//        Query query = Query.query(Criteria.where("id").is(encryptedid));
//        return mongoTemplate.findOne(query,League.class);
//    }
}

