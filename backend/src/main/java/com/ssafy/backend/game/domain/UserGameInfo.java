package com.ssafy.backend.game.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGameInfo {
    private WebSocketSession webSocketSession;
    private byte characterNum;
    private byte playerNum;
    private byte score;
    private boolean isAccess;

    public UserGameInfo(WebSocketSession webSocketSession,
                        byte characterNum,
                        byte playerNum){
        this.webSocketSession = webSocketSession;
        this.characterNum = characterNum;
        this.playerNum = playerNum;
        score = 0;
        isAccess = false;
    }

}
