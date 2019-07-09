package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.api.OpenRiotGamesApiClient;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerId;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.repository.SummonerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class ApiService {

    List<String> summoners = null;

    /**Spring boot의 라이브러리인 ObjectMapper를 사용
     */
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    OpenRiotGamesApiClient openRiotGamesApiClient;

    @PostConstruct
    public List<String> loadAvailableSummonerNameFromFile() throws IOException {
        File file = new File("availableCityNames");

        return objectMapper.readValue(file, new TypeReference<List<String>>(){});
    }

    public SummonerId getSummonerIdById(String summonerId){
        return summonerInfoRepository.findSummonerId(summonerId);

    }


    LinkedList<String> citiesQueue = new LinkedList<>();

    @Autowired
    SummonerInfoRepository summonerInfoRepository;

    @Scheduled(fixedDelay = 2000L) //2초마다 메소드가 실행되도록
    public void getCurrentWeatherPeriodically() throws IOException {
        if(citiesQueue.isEmpty()){
            citiesQueue.addAll(loadAvailableSummonerNameFromFile());
        }

        String targetSummonerId = citiesQueue.pop();
        citiesQueue.addLast(targetSummonerId);

        SummonerId summonerId = openRiotGamesApiClient.requestSummonerId(targetSummonerId);
        summonerInfoRepository.insertSummonerEncryptedId(summonerId);

        //Lombok Library 기능
        log.info("Current weather has been inserted successfully. {}",targetSummonerId);
    }


}
