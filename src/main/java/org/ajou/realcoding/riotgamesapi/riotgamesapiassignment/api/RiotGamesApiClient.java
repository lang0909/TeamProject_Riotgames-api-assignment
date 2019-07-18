
package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;


import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RiotGamesApiClient {
    private final String apikey = "RGAPI-a1f2d8d1-3b73-4ec7-aa0d-19afc1dd4d42"; //Expires: Thu, Jul 18th, 2019 @ 11:26pm (PT)
    private final String name_url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{user_name}?api_key={apikey}";
    private final String entry_url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encrytedId}?api_key={apikey}";

    /**
     * Response 주소 양식
     * https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/RiotSchmick?api_key=<key>
     */

    @Autowired
    RestTemplate restTemplate;

    public Summoner requestSummoner(String user_name) {
        return restTemplate.exchange(name_url, HttpMethod.GET, null, Summoner.class, user_name, apikey).getBody();
    }

    public League[] requestLeagueInfo(String encrytedId) {
        return restTemplate.exchange(entry_url, HttpMethod.GET, null, League[].class, encrytedId, apikey).getBody();
    }

}



