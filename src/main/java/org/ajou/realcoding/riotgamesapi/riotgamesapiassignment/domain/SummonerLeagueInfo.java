package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;


import lombok.Data;

@Data
public class SummonerLeagueInfo {

    private String queueType;
    private String summonerName;
    private boolean hotStreak;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private boolean inactive;
    private boolean freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;
}
