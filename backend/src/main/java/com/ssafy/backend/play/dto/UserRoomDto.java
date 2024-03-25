package com.ssafy.backend.play.dto;

import com.ssafy.backend.user.dto.UserProfileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoomDto {

    private int userIndex;
    private boolean isReady;
    String userCode;
    String nickName;
    String tier;
    String skin;
    String title;

    public UserRoomDto(int userIndex, UserProfileDto userProfileDto){
        this.userIndex = userIndex;
        isReady = false;
        userCode = userProfileDto.getUserCode();
        nickName = userProfileDto.getNickname();
        tier = userProfileDto.getTier();
        skin = userProfileDto.getSkin();
        title = userProfileDto.getTitle();
    }

}
