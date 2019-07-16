package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    @Autowired
    RiotGamesApiService riotGamesApiService;
    @Autowired
    RiotGamesApiClient riotGamesApiClient;

    @GetMapping("/league/{summonerName}")
    public League[] getLeagueBySummonerName(@PathVariable String summonerName){
        League[] league = riotGamesApiService.getLeagueBySummoner(summonerName);
        return league;
    }

}
