package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class RiotGamesApiRepository
{
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertRiotGamesApi(League[] league)
    {
        for(int i = 0; i< league.length; i++)
        {
            Query query = Query.query((Criteria.where("leagueId").is(league[i].getLeagueId())));
            if(mongoTemplate.findOne(query, League.class)==null)
            {
                mongoTemplate.insert(league[i]);
            }
            else
            {
                mongoTemplate.findAndReplace(query, league[i]);
            }
        }
    }

}
