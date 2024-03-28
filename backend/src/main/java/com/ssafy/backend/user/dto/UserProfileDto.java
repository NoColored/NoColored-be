package com.ssafy.backend.user.dto;

import com.ssafy.backend.user.entity.UserProfile;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {
    String userCode;
    String nickname;
    long exp; //현재 경험치
    long expRequire; //현재 레벨 필요경험치
    int level;
    boolean isGuest;
    int rating;
    String tier;
    int rank;
    String skin;
    String label;
    
    // exp, expRequire, level, 묶어서 계산
    // tier, rank 묶어서 계산
    
    public UserProfileDto(UserProfile userProfile){
        this.userCode = userProfile.getUserCode();
        this.nickname = userProfile.getUserNickname();
        this.exp = userProfile.getUserExp();
        this.isGuest = userProfile.isGuest();
        this.rating = userProfile.getUserRating();
//        this.tier = "nocolored"; //로직
        this.skin = userProfile.getUserSkin();
        this.label = userProfile.getUserLabel();
    }
}
