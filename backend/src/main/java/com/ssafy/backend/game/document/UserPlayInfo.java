package com.ssafy.backend.game.document;

import com.ssafy.backend.game.type.GameItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

//@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPlayInfo {
    int rank;
    int step;
    int stepped;
    int itemCount;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String gameType;
    List<String[]> users; //code, nickname
    Map<String, Integer> itemCountMap;
    public UserPlayInfo(String gameType){
        users = new LinkedList<>();
        itemCountMap = new LinkedHashMap<>();

        for (GameItemType type: GameItemType.values()) {
            itemCountMap.put(type.name().toLowerCase(),0);
        }
    }

}
