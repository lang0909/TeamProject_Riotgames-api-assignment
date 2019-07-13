package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
            Query query = Query.query((Criteria.where("summonerName").is(summonerEntry[i].getSummonerName())));
            if(mongoTemplate.findOne(query,SummonerEntry.class)==null)
            {
                mongoTemplate.insert(summonerEntry[i]);
            }
            else
            {
                mongoTemplate.findAndReplace(query,summonerEntry[i]);
            }
        }
    }

}
