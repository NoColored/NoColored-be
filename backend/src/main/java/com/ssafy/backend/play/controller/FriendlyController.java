package com.ssafy.backend.play.controller;



import com.ssafy.backend.websocket.domain.UserAccessInfo;
import com.ssafy.backend.play.dto.RoomDto;
import com.ssafy.backend.play.dto.UserRoomDto;
import com.ssafy.backend.play.service.FriendlyService;
import com.ssafy.backend.user.dto.UserProfileDto;
import com.ssafy.backend.user.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/play/friendly")
public class FriendlyController {
    private final FriendlyService friendlyService;
    private final JwtUtil jwtUtil;

    public FriendlyController(FriendlyService friendlyService, JwtUtil jwtUtil){
        this.friendlyService = friendlyService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("list/{offset}")
    private ResponseEntity<?> getRoomList(@PathVariable("offset") int offset){
        return friendlyService.getRoomList(offset);
    }

    @PostMapping("uuid")
    private ResponseEntity<?> findRoomUuId(@RequestBody Map<String, Object> requestBody){
        int code = Integer.parseInt((requestBody.get("roomCode").toString()));
        String password=(String) requestBody.get("roomPassword");

        return ResponseEntity.ok("");
    }

    @PatchMapping("enter")
    private ResponseEntity<?> enterRoom(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody ){

        int code=Integer.parseInt(requestBody.get("roomCode").toString());
        String password=(String) requestBody.get("roomPassword");
        UserAccessInfo userAccessInfo = jwtUtil.getUserAccessInfoRedis(token);

        return friendlyService.enterRoom(code, password, userAccessInfo);
    }

    @PostMapping
    private ResponseEntity<?> createRoom(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody){
        // requestbody를 service로 보내서 한번에 처리 가능한거 아님??? 나중에 고쳐라
        String roomTitle = (String) requestBody.get("roomTitle");
        String roomPassword = (String) requestBody.get("roomPassword");
        int mapId = Integer.parseInt(requestBody.get("mapId").toString());
        UserAccessInfo userAccessInfo = jwtUtil.getUserAccessInfoRedis(token);

        return friendlyService.createRoom(roomTitle,roomPassword,mapId,userAccessInfo);
    }

    @PatchMapping("/ready")
    private ResponseEntity<?> readyRoom(@RequestHeader("Authorization") String token){
        UserAccessInfo userAccessInfo = jwtUtil.getUserAccessInfoRedis(token);
        return friendlyService.readyRoom(userAccessInfo);
    }

    @PostMapping("/renew")
    private ResponseEntity<?> renewRoom(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody){
        String roomTitle=(String) requestBody.get("roomTitle");
        String roomPassword = (String) requestBody.get("roomPassword");
        int mapId = Integer.parseInt(requestBody.get("mapId").toString());
        UserAccessInfo userAccessInfo = jwtUtil.getUserAccessInfoRedis(token);
        return friendlyService.renewRoom(userAccessInfo, roomTitle, roomPassword, mapId);
    }

    @PatchMapping("/out")
    private ResponseEntity<?> quitRoom(@RequestHeader("Authorization") String token){
        UserAccessInfo userAccessInfo = jwtUtil.getUserAccessInfoRedis(token);
        return friendlyService.quitRoom(userAccessInfo);
    }

}
