package com.washuu.consumer.controller;

import com.washuu.consumer.service.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")

public class UserController {
    @Autowired
    private UserOrderFeign userOrderFeign;
    /**
     * 用户远程调用下单的接口
     *
     * @return
     */
    @GetMapping("userDoOrder")
    public String userDoOrder() {
        String result = userOrderFeign.doOrder();
        System.out.println(result);
        return result;
    }
}
