package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    RiotGamesApiService riotGamesApiService;

    @GetMapping("/riotgamesapi/SummonerId/searchLeagueInfo/{id}")
    public League getSummonerLeagueInfo(@PathVariable String summonerName) {
        return riotGamesApiService.getSummonerLeagueInfo(summonerName);
    }

}
