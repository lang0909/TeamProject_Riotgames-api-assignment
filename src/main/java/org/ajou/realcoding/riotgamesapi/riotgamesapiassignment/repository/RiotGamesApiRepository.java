package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators;
import org.springframework.stereotype.Repository;


@Repository
public class RiotGamesApiRepository
{
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertRiotGamesApi(SummonerEntry[] summonerEntry)
    {
        for(int i=0;i<summonerEntry.length;i++)
        {
            mongoTemplate.insert(summonerEntry[i]);
        }
    }

}
