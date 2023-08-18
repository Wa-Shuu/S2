package com.washuu.nacosconsumer.controller;

import com.washuu.nacosconsumer.service.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    /**
     * 注入服务发现组件 在 eureka 中也用过
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProviderFeign providerFeign;
    /**
     * 服务发现的接口
     *
     * @param serviceId
     * @return
     */
    @GetMapping("discovery")
    public String discoveryService(String serviceId) {
// 根据实例名称拿到实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
// 从实例集合列表中获取一个实例对象
        ServiceInstance serviceInstance = instances.get(0);
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }

    @GetMapping("rpc")
//    public String testRpc(@RequestParam String name) {
    public String testRpc(String name) {
        String result = providerFeign.hello(name);
        System.out.println(result);
        return result;
    }

}
