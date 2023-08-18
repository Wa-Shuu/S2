package com.washuu.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "EUREKA-SERVER", fallback = OrderServiceHystrix.class)
public interface UserOrderFeign {
    /**
     * 描述: 下单的方法 这里的路径必须和提供者的路径一致
     *
     * @param :
     * @return java.lang.String
     */
    @GetMapping("doOrder")
    String doOrder();
}

