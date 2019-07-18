package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {

    private final String api_key = "RGAPI-d1a42a3a-11da-4cf5-85ee-118c552b09e8";
    private final String summonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={api_key}";
    private final String LeagueUrl ="https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={api_key}";

    @Autowired
    RestTemplate restTemplate;
    public Summoner getSummoner(String summonerName){
        Summoner summoner = restTemplate.exchange(summonerUrl, HttpMethod.GET,null,Summoner.class,summonerName,api_key).getBody();
        return summoner;
    }

    public League[] getLeague(String encryptedSummonerId) {
        return restTemplate.exchange(LeagueUrl,HttpMethod.GET,null,League[].class,encryptedSummonerId,api_key).getBody();
    }

}
