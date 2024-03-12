package com.ssafy.backend.user.service;

import com.ssafy.backend.user.entity.UserInfo;
import com.ssafy.backend.user.dao.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    Optional<UserInfo> findUserInfoByUserCode(String userCode){
        return userInfoRepository.findByUserCode(userCode);
    }

    public boolean existsUserByUserCode(String userCode) {
        return findUserInfoByUserCode(userCode).isPresent();
    }
}
