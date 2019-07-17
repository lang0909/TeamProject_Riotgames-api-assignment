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

    public void insertAndUpdateRiotGamesApi(League[] league) {
        for (int i = 0; i < league.length; i++) {
            Query query = Query.query((Criteria.where("summonerName").is(league[i].getSummonerName())));
            if (mongoTemplate.findOne(query, League.class) == null) {
                mongoTemplate.insert(league[i]);
            } else {
//                mongoTemplate.update();
            }
        }
    }

    public League findSummonerLeagueInfo(String summonerName) {
        Query query = Query.query(Criteria.where("summonerName").is((summonerName)));
        return mongoTemplate.findOne(query, League.class);
    }

}