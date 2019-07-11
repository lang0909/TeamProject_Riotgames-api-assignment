package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;

import lombok.Data;

@Data
public class SummonerEntry
{
    private String queueType;
    private String summonerName;
    private String hotStreak;
    private int wins;
    private String veteran;
    private int losses;
    private String rank;
    private String tier;
    private String inactive;
    private String freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;
}
