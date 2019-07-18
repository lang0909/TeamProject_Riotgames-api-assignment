package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class RiotGamesApiRepository {
    @Autowired
    MongoTemplate mongoTemplate;

        public void insertAndUpdateRiotGamesApi(League[] league) {

            for (int i = 0; i < league.length; i++) {
                Query query = Query.query((Criteria
                        .where("summonerName").is(league[i].getSummonerName())
                        .and("queueType").is(league[i].getQueueType())));
                if (mongoTemplate.findOne(query, League.class) == null) {
                    mongoTemplate.insert(league[i]);
                    log.info("< Inserting Hide on bush's League Information. Please wait. >");
                } else {
                    //TODO
                    mongoTemplate.findAndReplace(query, league[i]);
                    log.info("< Updating Hide on bush's League Information. Please wait. >");
                }
            }
        }

    public League findSummonerLeagueInfo(String summonerName) {
        Query query = Query.query(Criteria.where("summonerName").is((summonerName)));
        return mongoTemplate.findOne(query, League.class);
    }

}