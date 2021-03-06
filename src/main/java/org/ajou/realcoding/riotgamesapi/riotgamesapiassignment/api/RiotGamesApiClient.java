package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RiotGamesApiClient {
    private final String apikey = "RGAPI-a509ecf8-7003-4cab-9e53-9e4276ac7a2a";
    private final String name_url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{user_name}?api_key={apikey}";
    private final String entry_url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encrytedId}?api_key={apikey}";
    
    @Autowired
    RestTemplate restTemplate;

    public Summoner requestSummoner(String user_name) {
        return restTemplate.exchange(name_url, HttpMethod.GET, null, Summoner.class, user_name, apikey).getBody();
    }

    public League[] requestLeague(String encrytedId) {
        return restTemplate.exchange(entry_url, HttpMethod.GET, null, League[].class, encrytedId, apikey).getBody();
    }
}