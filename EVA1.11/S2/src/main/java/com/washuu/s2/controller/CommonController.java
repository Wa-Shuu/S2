package com.washuu.s2.controller;

import com.washuu.s2.domain.User;
import com.washuu.s2.service.UserService;
import com.washuu.s2.util.Enum.TokenEnum;
import com.washuu.s2.util.FileUploadUtil;
import com.washuu.s2.util.Enum.HttpCodeEnum;
import com.washuu.s2.util.HttpUtil;
import com.washuu.s2.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@CrossOrigin
public class CommonController {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/uploadImage")
    @CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public Map<String, Object> editorUpload(
            @RequestParam("avatar") MultipartFile img, HttpSession session
    ) {
        System.out.println("已接收到请求");
        User user = new User();
        user.setUserName("Test_Account");
        session.setAttribute("user", user);
        Map<String, Object> map = FileUploadUtil.uploadCOS(img, session);
        return map;
    }

    @PostMapping("/validlogin")
    public Map<String, Object> validLogin(@RequestBody User user, HttpServletRequest req, HttpServletResponse resp) {
        User user1 = userService.queryUserByUid(user.getUid());
        if(user1.getPassword().equals(user.getPassword())){
            Map<String, String> respInfo = new HashMap<>();
            respInfo.put("token", jwtUtil.getToken(user));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
//            return HttpUtil.buildResponse(HttpCodeEnum.OK, respInfo);
//            这里有个问题哈，就是如果我通过dispatcher转发到/login，那么我这里的return值怎么办?
//            前端是收到这里的return呢还是/login的return呢？
            return null;
        }
        return HttpUtil.buildResponse(HttpCodeEnum.FORBIDDEN, HttpCodeEnum.FORBIDDEN.getDescription());
    }

//    @GetMapping("/tokenlogin")
//    public Map<String, Object> validLogin(@RequestParam("token") String token) {
//
//        Map<String, Object> payLoad = JWTUtil.resolveTokenPayLoad(token);
//
//        User user1 = userService.queryUserByUserName((String)payLoad.get(TokenEnum.USER_NAME));
//        if(user1.getPassword().equals((String)payLoad.get(TokenEnum.PASSWORD))){
//            Map<String, String> resp = new HashMap<>();
//            return HttpUtil.buildResponse(HttpCodeEnum.OK, resp);
//        }
//        return HttpUtil.buildResponse(HttpCodeEnum.FORBIDDEN, HttpCodeEnum.FORBIDDEN.getDescription());
//    }



}
