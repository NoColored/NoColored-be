package com.ssafy.backend.websocket.domain;

import com.ssafy.backend.game.domain.GameInfo;
import com.ssafy.backend.play.domain.MatchingInfo;
import com.ssafy.backend.play.domain.RoomInfo;
import com.ssafy.backend.user.dto.UserProfileDto;
import com.ssafy.backend.user.entity.UserProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;


@Getter
@Setter
@NoArgsConstructor
public class UserAccessInfo {
    private WebSocketSession session;
    private UserProfile userProfile;
    private UserProfileDto userProfileDto;
    private Object position;//사용할때 상태 확인해야함

    public UserAccessInfo(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public RoomInfo getRoomInfo(){
       if (position instanceof RoomInfo) return (RoomInfo) position;
       else return null;
    }

    public GameInfo getGameInfo(){
        if (position instanceof GameInfo) return (GameInfo) position;
        else return null;
    }

    public void setGameInfo(GameInfo gameInfo){
        if (!(position instanceof RoomInfo || position instanceof MatchingInfo)) throw new RuntimeException("Position conflict");
        position = gameInfo;
    }

    public void setMatchingInfo(MatchingInfo matchingInfo){
        if (position instanceof GameInfo || position instanceof MatchingInfo || position instanceof RoomInfo) throw new RuntimeException("Position conflict");
        position = matchingInfo;
    }
    public void setRoomInfo(RoomInfo roomInfo){
        if (position instanceof MatchingInfo || position instanceof RoomInfo) throw new RuntimeException("Position conflict");
        position = roomInfo;
    }

    public void clearPosition(){
        position = null;
    }
}
