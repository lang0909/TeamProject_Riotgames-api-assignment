package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository
public class RiotGamesApiRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public League findLeagueInfo(String summonername){
        Query query = Query.query(Criteria.where("name").is(summonername));
        return mongoTemplate.findOne(query, League.class);
    }
    public void insertRiotGamesApi(League[] league){
        Query query = Query.query(Criteria.where("summonerName").is(league[0].getSummonerId()));
        mongoTemplate.insert(league[0]);
    }
}
