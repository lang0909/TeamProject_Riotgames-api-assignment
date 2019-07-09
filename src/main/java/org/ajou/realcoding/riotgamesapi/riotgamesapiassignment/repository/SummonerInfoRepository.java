package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository;


import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerInfoRepository {

    @Autowired
    MongoTemplate mongoTemplate;


    public void insertSummonerEncryptedId(SummonerId summonerId) {

        mongoTemplate.insert(summonerId);
    }

    public SummonerId findSummonerId(String summonerId) {
        Query query = Query.query(Criteria.where("id").is((summonerId)));
        return mongoTemplate.findOne(query, SummonerId.class);

        /**
         *
         * 추후 과제에 remove와 update를 사용
         *
         * */
        //mongoTemplate.remove()
        //mongoTemplate.update()
        //findOne했을때, 이미 데이터가 있다면 update가 되도록 만들기
    }
}
