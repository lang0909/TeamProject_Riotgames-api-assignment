package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;

import lombok.Data;


@Data
public class Summoner {
    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private long revisionDate;
    private String id;
    private String accountId;

}
