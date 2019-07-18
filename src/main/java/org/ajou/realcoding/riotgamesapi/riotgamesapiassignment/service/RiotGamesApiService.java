package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.League;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.Summoner;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.RiotGamesApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RiotGamesApiService {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private RiotGamesApiClient riotGamesApiClient;

	public League getLeagueBySummoner(String summonerName){
		Summoner summoner = riotGamesApiClient.getSummoner(summonerName);
		String encryptedId = summoner.getId();
		League league = riotGamesApiClient.getLeague(encryptedId);
		return league;
	}

}
