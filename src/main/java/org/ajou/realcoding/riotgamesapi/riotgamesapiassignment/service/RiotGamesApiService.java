package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.RiotGamesApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RiotGamesApiService {

	@Autowired
	private RiotGamesApiClient riotGamesApiClient;

	@Autowired
	private RiotGamesApiRepository riotGamesApiRepository;

	public List<League> getLeagueBySummoner(String summonerName){
		return riotGamesApiRepository.findLeagueInfo(summonerName);
	}

	@Scheduled(fixedDelay = 5000L)
	public void getRiotGamesApiPeriodically()
	{
		Summoner summoner = riotGamesApiClient.getSummoner("hide on bush");
		League[] league = riotGamesApiClient.getLeague(summoner.getId());
		riotGamesApiRepository.insertLeague(league);
		log.info("riot games api has been inserted successfully. {}", league);
	}

}
