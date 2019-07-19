package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiotGamesApiController {

    @Autowired
    RiotGamesApiService riotGamesApiService;

    @GetMapping("/riot-games-api-assignment/leagues/by-user-name/{userName}")
    public List<League> getLeague(@PathVariable String userName) {
        return riotGamesApiService.getLeagueInfo(userName);
    }
}