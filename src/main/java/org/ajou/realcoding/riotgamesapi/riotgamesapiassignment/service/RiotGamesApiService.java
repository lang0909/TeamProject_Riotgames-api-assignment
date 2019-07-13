package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerEntry;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerName;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.RiotGamesApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators;
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
        SummonerName summonerName = riotGamesApiClient.requestSummonerName("hide on bush");
        SummonerEntry[] summonerEntry = riotGamesApiClient.requestSummonerEntry(summonerName.getId());
        riotGamesApiRepository.insertRiotGamesApi(summonerEntry);
        log.info("riot games api has been inserted successfully. {}", summonerEntry);
    }
}
