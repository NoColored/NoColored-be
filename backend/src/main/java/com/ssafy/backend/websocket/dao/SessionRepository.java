package com.ssafy.backend.websocket.dao;


import com.ssafy.backend.websocket.domain.GameInfo;
import com.ssafy.backend.websocket.user.entity.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class SessionRepository {//redis 고려
    public final static CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    public final static HashMap<WebSocketSession, GameInfo> inGameUser = new HashMap<>();
    public final static LinkedList<GameInfo> inGameList = new LinkedList<>();

    //세션으로 유저찾기
    public final static HashMap<WebSocketSession, UserInfo> loginUserMap = new HashMap<>();

    // 유저로 세션찾기
    public final static HashMap<UserInfo, WebSocketSession> userSessionMap = new HashMap<>();

}
