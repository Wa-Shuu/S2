package com.washuu.s2.service.impl;

import com.washuu.s2.domain.User;
import com.washuu.s2.domain.UserAuth;
import com.washuu.s2.domain.UserAuthExample;
import com.washuu.s2.domain.UserExample;
import com.washuu.s2.mapper.UserAuthMapper;
import com.washuu.s2.mapper.UserMapper;
import com.washuu.s2.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    private UserAuthMapper userAuthMapper;
    private UserMapper userMapper;
    @Override
    public UserAuth getUserAuth(User user) {
        if(user.getUid() == null) {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserNameEqualTo(user.getUserName());
            user.setUid(userMapper.selectByExample(userExample).get(0).getUid());
        }

        UserAuthExample userAuthExample = new UserAuthExample();
        UserAuthExample.Criteria criteria = userAuthExample.createCriteria();
        criteria.andUidEqualTo(user.getUid());


        List<UserAuth> userAuths = userAuthMapper.selectByExample(userAuthExample);
        if(userAuths.size() == 1) {
            return userAuths.get(0);
        }
        return null;
    }

    @Override
    public int updateUserAuth(UserAuth userAuth) {
        UserAuthExample userAuthExample = new UserAuthExample();
        userAuthExample.createCriteria().andAidEqualTo(userAuth.getAid());
        return userAuthMapper.updateByExampleSelective(userAuth, userAuthExample);
    }
}
