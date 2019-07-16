package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Summoner {
    @Id
    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private long revisionDate;
    private String id;      //encryptedSummonerId
    private String accountId;
}
