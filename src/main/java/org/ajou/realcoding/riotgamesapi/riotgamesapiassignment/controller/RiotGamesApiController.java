package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotGamesApiController {
    @Autowired
    RiotGamesApiService riotGamesApiService;

    @GetMapping("/league/{summonerName}")
    public League getLeagueFromSummonerName(@PathVariable String summonerName){
        return riotGamesApiService.getLeagueInfo(summonerName);
    }

}
