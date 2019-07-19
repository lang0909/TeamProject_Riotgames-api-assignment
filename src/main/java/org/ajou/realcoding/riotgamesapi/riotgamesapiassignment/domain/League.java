package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;

import lombok.Data;


@Data
public class League {
    private String queueType;
    private String summonerName;
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