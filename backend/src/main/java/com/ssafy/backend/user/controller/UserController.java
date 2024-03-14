package com.ssafy.backend.user.controller;

import com.ssafy.backend.user.dto.UserLoginDto;
import com.ssafy.backend.user.entity.UserProfile;
import com.ssafy.backend.user.service.UserService;
import com.ssafy.backend.user.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService, JwtUtil jwtUtil){
        this.userService = userService;

    }
    @PostMapping("/signup")
    private ResponseEntity<String> signup(@RequestBody UserLoginDto user){
        UserProfile userProfile = userService.signUp(user.getId(), user.getPassword(), user.getNickname());
        String jwtToken = userService.generateToken(userProfile);
        return ResponseEntity.ok(jwtToken);
    }
    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody UserLoginDto user){
        return ResponseEntity.ok(userService.login(user.getId(),user.getPassword()));
    }

}
