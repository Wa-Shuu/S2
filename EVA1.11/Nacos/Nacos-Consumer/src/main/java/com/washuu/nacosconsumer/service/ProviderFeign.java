package com.washuu.nacosconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("alibaba-nacos-provider")
public interface ProviderFeign {
    /**
     * 远程调用打招呼的接口
     *
     * @param name
     * @return
     */
    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}