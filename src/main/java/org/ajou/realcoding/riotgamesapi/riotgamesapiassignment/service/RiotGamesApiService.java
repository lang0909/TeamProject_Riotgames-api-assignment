package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.RiotGamesApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@Slf4j
public class RiotGamesApiService {

    @Autowired
    private RiotGamesApiClient riotGamesApiClient;
    @Autowired
    private RiotGamesApiRepository riotGamesApiRepository;

    public String getEncryptedSummonerIdBySummonerName(String summonerName) {
        String encryptedSummonerId = riotGamesApiClient.getSummoner(summonerName).getId();
        return encryptedSummonerId;
    }

    public League[] getLeagueBySummoner(String summonerName) {
        String encryptedId = getEncryptedSummonerIdBySummonerName(summonerName);
        League[] league = riotGamesApiClient.getLeague(encryptedId);

        riotGamesApiRepository.insertOrUpdateLeague(league);

        log.info("League of User has been inserted successfully. {}", league);
        return league;
    }

}
