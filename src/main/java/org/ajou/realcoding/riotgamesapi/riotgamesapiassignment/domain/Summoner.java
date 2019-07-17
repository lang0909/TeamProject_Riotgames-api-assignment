package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;

        import lombok.Data;

@Data
public class Summoner {
    private String name;
    private String id; //Encrypted Id
    private String accountId;
}