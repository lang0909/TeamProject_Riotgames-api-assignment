package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;


import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RiotGamesApiClient {
    private final String apikey = "RGAPI-029da036-16be-4ba8-a903-e7dac8283871";
    private final String name_url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{user_name}?api_key={apikey}";
    private final String league_url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encrytedId}?api_key={apikey}";

    @Autowired
    RestTemplate restTemplate;

    public Summoner requestSumonerInfo(String name){
        return restTemplate.exchange(name_url, HttpMethod.GET, null, Summoner.class, name, apikey).getBody();
    }

    public League[] requestLeagueInfo(String encrytedId){
        return restTemplate.exchange(league_url,HttpMethod.GET, null, League[].class,encrytedId,apikey).getBody();
    }
}