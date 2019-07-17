package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {

    private final String api_key = "RGAPI-026c885b-d114-4572-a40e-40507829455b";
    private final String summonerUrl = "https://kr.api.riotgames.com/lol/summoners/v4/summoners/by-name/{summonerName}?api_key={apikey}";
    private final String LeagueUrl ="https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key={apikey}";

    @Autowired
    RestTemplate restTemplate;
    public Summoner getSummoner(String summonerName){
        Summoner summoner = restTemplate.exchange(summonerUrl, HttpMethod.GET,null,Summoner.class,summonerName,api_key).getBody();
        return summoner;
    }

    public League getLeague(String encryptedSummonerId) {
        League league = restTemplate.exchange(LeagueUrl,HttpMethod.GET,null,League.class,encryptedSummonerId,api_key).getBody();
        return league;
    }

}
