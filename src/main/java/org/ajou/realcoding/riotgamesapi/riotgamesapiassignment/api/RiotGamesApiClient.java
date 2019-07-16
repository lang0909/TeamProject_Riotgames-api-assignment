package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String api_key = "RGAPI-3a704312-5430-44dd-a9b9-470904dfd4ef";
    private final String summonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{user_name}?api_key={apikey}";
    private final String LeagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encrytedId}?api_key={apikey}";

    public Summoner getSummoner(String user_name){
        Summoner summoner = restTemplate.exchange(summonerUrl, HttpMethod.GET,null,Summoner.class,user_name,api_key).getBody();
        return summoner;
    }

    public League getLeague(String encryptedId) {
        League league = restTemplate.exchange(LeagueUrl,HttpMethod.GET,null,League.class,encryptedId,api_key).getBody();
        return league;
    }
}
