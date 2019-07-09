package org.ajou.realcoding.riotgamesapi.riotgamesapiassignment.domain;


import lombok.Data;

/**
 * 응답받은 Body String을 그냥 돌려준다..? 담을 그릇을 하나 만드는게 좋지 않을까?
 * domain 패키지에 SummonerId 클래스를 정의해서 데이터를 한 그릇에 담기
 * */

@Data
public class SummonerId {

    private String id; //	Encrypted summoner ID. Max length 63 characters.
}
