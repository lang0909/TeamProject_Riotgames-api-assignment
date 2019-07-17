
package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;


import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RiotGamesApiClient {
    private final String apikey = "RGAPI-c02188ab-d8a6-496c-b921-3f8bac5627b3"; //Expires: Wed, Jul 17th, 2019 @ 10:16pm (PT)
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



