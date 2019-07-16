package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RiotGamesApiRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    //DB에다가 소환사의 리그 정보 넣거나 업데이트
    public League insertOrUpdateLeague(League league){
        return mongoTemplate.save(league);
    }

}
