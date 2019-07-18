package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class League {

    private String queueType;       //RANKED_SOLO_5x5 || RANKED_FLEX_SR
    private String summonerName;    //Summoner의 encryptedId랑 동일
    private boolean hotStreak;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String leagueId;
    private boolean inactive;
    private boolean freshBlood;
    private String tier;
    private String summonerId;
    private int leaguePoints;
}