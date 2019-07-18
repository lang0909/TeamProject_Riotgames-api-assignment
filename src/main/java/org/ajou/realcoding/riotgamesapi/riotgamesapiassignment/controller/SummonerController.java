package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SummonerController {
    @Autowired
    RiotGamesApiService riotGamesApiService;

    @GetMapping("/league/{summonerName}")
    public List<League> getLeagueBySummonerName(@PathVariable String summonerName){
        return riotGamesApiService.getLeagueBySummoner(summonerName);
    }

}
