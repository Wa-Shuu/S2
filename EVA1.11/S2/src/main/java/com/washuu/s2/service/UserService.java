package com.washuu.s2.service;

import com.washuu.s2.domain.User;
import com.washuu.s2.util.Enum.Result;

import java.util.List;
import java.util.Map;

public interface UserService {
    Result login(User user);
    int updateDatabase(User user);
    String register(User user);
    String loginVerify(String userName);
    User queryUserByUid(Integer uid);
    User queryUserByUserName(String userName);
//    String createToken(User user);
}
