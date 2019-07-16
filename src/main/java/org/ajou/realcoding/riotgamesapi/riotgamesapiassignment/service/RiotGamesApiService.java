package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.RiotGamesApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class RiotGamesApiService {

    @Autowired
    private RiotGamesApiClient riotGamesApiClient;
    @Autowired
    private RiotGamesApiRepository riotGamesApiRepository;

    public Summoner getSummonerBySummonerName(String summonerName) {
        riotGamesApiRepository.insertOrUpdateSummoner(riotGamesApiClient.getSummoner(summonerName));
        Summoner summoner = riotGamesApiRepository.findSummonerBySummonerName(summonerName);

        return summoner;
    }

    public League getLeagueBySummoner(Summoner summoner){
        String encryptedId = summoner.getId();
        League league = riotGamesApiClient.getLeague(encryptedId);
        riotGamesApiRepository.insertOrUpdateLeague(league);

        return league;
    }

}
