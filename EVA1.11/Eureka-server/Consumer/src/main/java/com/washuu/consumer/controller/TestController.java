package com.washuu.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@ResponseBody
@RequestMapping("consumer")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    static Random random = new Random();
    @RequestMapping("/testBalance")
    public String testBalance(String serviceId) {
//获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if (ObjectUtils.isEmpty(instances)) {
            return "服务列表为空";
        }
//如果服务列表不为空，先自己做一个负载均衡
        ServiceInstance serviceInstance = loadBalance(instances);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        System.out.println("host = " + host);
        String url = "http://" + host + ":" + port + "/s2";
        System.out.println("本次我调用的是" + url);
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;
    }
    private ServiceInstance loadBalance(List<ServiceInstance> instances) {
//拼接 url 去调用 ip:port 先自己实现不用 ribbon
        ServiceInstance serviceInstance =
                instances.get(random.nextInt(instances.size()));
        return serviceInstance;
    }

    @GetMapping("testRibbon")
    public String testRibbonBalance(String serviceId) {
            String url = "http://" + serviceId + "/s2";
            String forObject = restTemplate.getForObject(url, String.class);
            System.out.println(forObject);
            return forObject;
    }

}