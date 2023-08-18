package com.washuu.s2.controller;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.model.ciModel.auditing.UserInfo;
import com.washuu.s2.domain.User;
import com.washuu.s2.domain.UserAuth;
import com.washuu.s2.dto.RegisterDTO;
import com.washuu.s2.service.CollegeService;
import com.washuu.s2.service.SchoolService;
import com.washuu.s2.service.UserAuthService;
import com.washuu.s2.service.UserService;
import com.washuu.s2.util.Enum.Result;
import com.washuu.s2.util.JWTUtil;
import com.washuu.s2.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("/queryUserInfo")
    public List<UserInfo> queryUserInfo(String uidOrUserName) {



        return null;
    }


    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public Result login(@RequestBody User user) {
        log.info("用户名：[{}]",user.getUserName());
        log.info("密码：[{}]",user.getPassword());
        return userService.login(user);
    }

    @PostMapping("/loginVerify")
    @ResponseBody
    @CrossOrigin
    public String loginVerify(@RequestBody JSONObject json) {
        System.out.println("已收到请求");
        String statue = userService.loginVerify(json.getString("nickName"));
        return statue;
    }

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private CollegeService collegeService;

    @PostMapping("/register")
    @ResponseBody
    @CrossOrigin
    //注意
    //这里出现了一个问题，就是dto里面是传了gender的，
    public String register(@RequestBody RegisterDTO dto) {
        User user = new User();
//        user.setCreatetime(DateUtil.getDateTime());
        user.setGender(dto.getGender());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        Integer sid = schoolService.querySid(dto.getSchoolName());
        if(sid < 0) {
            return "Failed";
        }
        Integer cid = collegeService.queryCid(dto.getCollegeName());
        if(cid < 0) {
            return "Failed";
        }
        user.setCid(cid);
        user.setSid(sid);
        userService.register(user);
        return "Succeed";
    }






}
