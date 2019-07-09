package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api;


import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenRiotGamesApiClient {

    private final String appid = ""; //Api Key
    private final String openRiotGamesApiUrl = "";

    @Autowired
    RestTemplate restTemplate;

    public SummonerId requestSummonerId(String summonerId) {
        //exchange method
        return restTemplate.exchange(openRiotGamesApiUrl, HttpMethod.GET,null, SummonerId.class, summonerId, appid)
                .getBody(); //응답받은 response의 body를 꺼내서 리턴
    }

}
