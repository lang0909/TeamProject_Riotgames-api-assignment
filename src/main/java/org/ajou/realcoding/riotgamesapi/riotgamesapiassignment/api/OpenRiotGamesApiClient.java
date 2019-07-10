package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;


import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenRiotGamesApiClient {

    private final String appid = "RGAPI-016e5e31-63ea-4dd5-a2e9-66ee1d8b908f"; //Api Key
    private final String openRiotGamesApiUrl = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";


    /**
     * Response 주소 양식
     * https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/RiotSchmick?api_key=<key>
     * */


    @Autowired
    RestTemplate restTemplate;
    public SummonerId requestSummonerId(String summonerId) {
        //exchange method
        return restTemplate.exchange(openRiotGamesApiUrl, HttpMethod.GET,null, SummonerId.class, summonerId, appid)
                .getBody(); //응답받은 response의 body를 꺼내서 리턴
    }
}
