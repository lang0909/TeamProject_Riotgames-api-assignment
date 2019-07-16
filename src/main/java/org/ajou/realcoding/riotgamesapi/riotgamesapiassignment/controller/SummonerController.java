package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    @Autowired
    RiotGamesApiService riotGamesApiService;

    @GetMapping("/league")
    public League getLeagueBySummonerName(@RequestParam String summonerName){
        Summoner summoner = riotGamesApiService.getSummonerBySummonerName(summonerName);
        League league = riotGamesApiService.getLeagueBySummoner(summoner);
        return league;
    }

}
