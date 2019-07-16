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
    private MongoTemplate mongoTemplate;

    //DB에다가 소환사를 넣거나 업데이트
    public Summoner insertOrUpdateSummoner(Summoner summoner){
        return mongoTemplate.save(summoner);
    }

    //DB에다가 소환사의 리그 정보 넣거나 업데이트
    public League insertOrUpdateSummoner(League league){
        return mongoTemplate.save(league);
    }

    //DB에서 소환사 이름을 가지고 소환사의 암호화된 ID를 꺼내줌
    public String findEncryptedIdBySummonerName(String summonerName){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(summonerName));

        return mongoTemplate.findOne(query, Summoner.class).getId();
    }
}
