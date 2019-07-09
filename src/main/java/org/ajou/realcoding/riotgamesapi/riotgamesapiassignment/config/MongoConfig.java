package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.config;


import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {


    public MongoTemplate createMongoTemplate() {

        return new MongoTemplate(new MongoClient(), "RiotGamesUserInfoDB");

    }
}
