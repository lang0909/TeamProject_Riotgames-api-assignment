package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.RiotGamesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SummonerController {

    @Autowired
    RiotGamesApiService riotGamesApiService;

}
