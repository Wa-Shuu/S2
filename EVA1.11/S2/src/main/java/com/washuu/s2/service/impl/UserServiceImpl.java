package com.washuu.s2.service.impl;

import com.washuu.s2.domain.User;
import com.washuu.s2.domain.UserAuth;
import com.washuu.s2.domain.UserExample;
import com.washuu.s2.mapper.UserAuthMapper;
import com.washuu.s2.mapper.UserMapper;
import com.washuu.s2.service.UserAuthService;
import com.washuu.s2.service.UserService;
import com.washuu.s2.util.DateUtil;
import com.washuu.s2.util.Enum.RespEnum;
import com.washuu.s2.util.Enum.Result;
import com.washuu.s2.util.JWTUtil;
import com.washuu.s2.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public User queryUserByUserName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() != 1)
            return null;
        return users.get(0);
    }

    /**
     * 此方法只有当
     * 1、user的用户名唯一
     * 2、密码与账号吻合
     * 3、成功修改数据库中的状态——update后的返回值为1
     * 这三个条件同时满足时，才会返回true，否则返回false
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria =  userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() != 1) {
            return ResultUtil.failed("用户名重复");
        }
        User userTemp = users.get(0);
        if(userTemp.getPassword().equals(user.getPassword())) {
//          同步userAuth状态
//          因为数据库中还没有建立外键，所以暂时不走这段逻辑
//          等之后补上外键再开启，现在只是测试
//            UserAuth userAuth = userAuthService.getUserAuth(userTemp);
//            userAuth.setLastLoginTime(DateUtil.getDateTime());
//            if(userAuth.getLoginCount() == null) {
//                userAuth.setLoginCount(0);
//            }
//            userAuth.setLoginCount(userAuth.getLoginCount() + 1);
//            userAuth.setState("Logged_In");
//            if(userAuthService.updateUserAuth(userAuth) == 1) {
//                return ResultUtil.success(JWTUtil.getToken(user));
//            }
            return ResultUtil.success(jwtUtil.getToken(user));
            }
        return ResultUtil.failed("账号密码错误");
//        return ResultUtil.error("未知错误");
    }

    /**
     * 更新数据库状态，返回值表示数据库中受影响的记录条数
     * @param user
     * @return
     */
    public int updateDatabase(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUidEqualTo(user.getUid());
        return userMapper.updateByExampleSelective(user, userExample);
    }


    @Override
    public String loginVerify(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria =  userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()) {
            return "true";
        }
        return RespEnum.FAILED.toString();
    }

    @Override
    public User queryUserByUid(Integer uid) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(uid);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()) {
            return new User();
        }
        return users.get(0);

    }

    @Override
    @Transactional
    //这个方法需要开启事务
    public String register(User user) {
        if(userMapper.insertSelective(user) == 1) {
            UserAuth userAuth = userAuthService.getUserAuth(user);
//        userAuth.setRole("ROLE_USER"); //角色根据注册信息分配：校内人员还是校外人员，学生还是老师
        //或者说开放不同的地址，授予对应的角色；现在默认设置为ROLE_USER吧
            userAuth.setCreateTime(DateUtil.getDateTime());
            userAuth.setLoginCount(0);
//        user.setUid(1);//这里需要调用查询方法，查找对应的Uid;Uid是默认自增的吧我记得
        //不过uid也可以专门用一个方法来生成，这样会不会方便管理?
        //可以专门整一个util，用来处理这样的信息
        //这里还有一个问题，就是user里面有Img属性，怎么处理这个图片属性
            if(userAuthMapper.insertSelective(userAuth) == 0) {
                return RespEnum.SUCCESS.toString();
            }
            return RespEnum.FAILED.toString();
        }
        return RespEnum.FAILED.toString();
    }
}
