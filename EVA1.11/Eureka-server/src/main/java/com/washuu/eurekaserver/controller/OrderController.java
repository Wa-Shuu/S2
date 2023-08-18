package com.washuu.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class OrderController {
    /**
     * 订单服务下单接口
     *
     * @return
     */
    @GetMapping("doOrder")
    public String doOrder() {
        System.out.println("有用户来下单了");
        return "下单成功 2333";
    }
}
