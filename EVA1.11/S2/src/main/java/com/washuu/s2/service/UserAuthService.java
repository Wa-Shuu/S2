package com.washuu.s2.service;

import com.washuu.s2.domain.User;
import com.washuu.s2.domain.UserAuth;

public interface UserAuthService {
    UserAuth getUserAuth(User user);
    int updateUserAuth(UserAuth userAuth);
}
