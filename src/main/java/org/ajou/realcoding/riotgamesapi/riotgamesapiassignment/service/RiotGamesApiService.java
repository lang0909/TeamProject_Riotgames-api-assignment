package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.RiotGamesApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RiotGamesApiService
{
    @Autowired
    RiotGamesApiClient riotGamesApiClient;

    @Autowired
    RiotGamesApiRepository riotGamesApiRepository;

    @Scheduled(fixedDelay = 4000L)
    public void getRiotGamesApiPeriodically()
    {
        Summoner summoner = riotGamesApiClient.requestSummoner("hide on bush");
        League[] league = riotGamesApiClient.requestLeague(summoner.getId());
        riotGamesApiRepository.insertRiotGamesApi(league);
        log.info("riot games api has been inserted successfully. {}", league);
    }
}
