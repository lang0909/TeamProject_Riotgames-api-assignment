package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RiotGamesApiRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;
  
    public void insertRiotGamesApi(League[] league) {
        for (int i = 0; i < league.length; i++) {
            Query query = Query.query((Criteria.where("summonerName").is(league[i].getSummonerName())).and("queueType").is(league[i].getQueueType()));
            if (mongoTemplate.findOne(query, League.class) == null) {
                mongoTemplate.insert(league[i]);
            }
            mongoTemplate.findAndReplace(query, league[i]);
        }
    }


    public List<League> findLeagueInfo(String userName) {
        Query query = Query.query((Criteria.where("summonerName").regex(userName, "i")));
        return mongoTemplate.find(query, League.class);
    }
}