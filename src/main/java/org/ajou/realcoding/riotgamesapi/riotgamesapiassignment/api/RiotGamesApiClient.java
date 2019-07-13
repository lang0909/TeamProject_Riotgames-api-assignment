package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerEntry;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RiotGamesApiClient
{
    private final String apikey = "RGAPI-ba0b9cf3-c26a-4894-ad3e-584b31fb3cd4";
    private final String name_url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{user_name}?api_key={apikey}";
    private final String entry_url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encrytedId}?api_key={apikey}";

    @Autowired
    RestTemplate restTemplate;

    public SummonerName requestSummonerName(String user_name)
    {
        return restTemplate.exchange(name_url, HttpMethod.GET,null,SummonerName.class,user_name,apikey).getBody();
    }

    public SummonerEntry[] requestSummonerEntry(String encrytedId)
    {
        return restTemplate.exchange(entry_url,HttpMethod.GET,null,SummonerEntry[].class,encrytedId,apikey).getBody();
    }

}
