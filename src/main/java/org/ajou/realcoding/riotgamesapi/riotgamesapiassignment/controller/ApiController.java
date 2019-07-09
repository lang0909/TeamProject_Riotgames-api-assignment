package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.controller;

import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain.SummonerId;
import org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;


    @GetMapping("")
    public List<String> getAvailableSummonerIds() throws IOException {

        return apiService.loadAvailableSummonerNameFromFile();
    }

    @GetMapping("")
    public SummonerId getSummonerId(@PathVariable String id){
        return apiService.getSummonerIdById(id);
    }
}