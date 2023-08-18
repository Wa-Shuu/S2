package com.washuu.consumer.service;


import org.springframework.stereotype.Service;

@Service
public class OrderServiceHystrix implements UserOrderFeign{
    @Override
    public String doOrder() {
        System.out.println("调用下单服务失败，我走了hystrix了");

        return "我是 hystrix 的 doOrder，说明下单失败了";
    }
}
