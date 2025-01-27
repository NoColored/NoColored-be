package com.ssafy.backend.websocket.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public enum SendTextMessageType {
    // sendbinarymessagetype처럼 만들고
    // synchronizedsend 참고해서 보내면 된다
    UNKNOWN_ACTION("unknownAction"),
    WEBSOCKET_TIME_OUT("websocketTimeOut"),
    INVALID_TOKEN("invalidToken"),
    AUTHORIZED("authorized"),
    MATCHING("matching"),
    MATCHING_CANCEL("matchingCancel"),
    GAME_START("gameStart"),
    ROOM_INFO("roomInfo");

    private final String value;
    private static final Map<String, SendTextMessageType> textMap = new HashMap<>();

    SendTextMessageType(String value) {this.value = value;}
    static {
        for (SendTextMessageType messageType : SendTextMessageType.values()) {
            textMap.put(messageType.value, messageType);
        }
    }

    public static SendTextMessageType valueOfString(String value) {
        SendTextMessageType result = textMap.get(value);
        if (result == null) {
            return null;
//            throw new IllegalArgumentException("No enum constant for value: " + value);
        }
        return result;
    }


}
