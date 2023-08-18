package com.washuu.eurekaserver.controller;

import com.washuu.eurekaserver.domain.BaseResult;
import com.washuu.eurekaserver.domain.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("server")
public class TestParamController {
    /**
     * 测试单个参数
     *
     * @param name
     * @return
     */
    @GetMapping("testOneParam")
    public BaseResult oneParam(@RequestParam("name") String name) {
        System.out.println(name);
        return BaseResult.success(200, "成功", "ok");
    }
    /**
     * 测试两个参数
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping("testTwoParam")
    public BaseResult twoParam(@RequestParam("name") String name,@RequestParam("age") Integer age) {
        System.out.println(name + ":" + age);
        return BaseResult.success(200, "ok", "ok");
    }
    /**
     * 测试一个对象的传参
     *
     * @param order
     * @return
     */
    @PostMapping("testObjectParam")
    public BaseResult objectParam(@RequestBody Order order) {
        System.out.println(order);
        return BaseResult.success(200, "ok", order);
    }
    /**
     * 测试一个对象 一个参数
     *
     * @param order
     * @param name
     * @return
     */
    @PostMapping("testOneObjectOneParam")
    public BaseResult oneObjectOneParam(@RequestBody Order order,
                                        @RequestParam String name) {
        System.out.println(order);
        System.out.println(name);
        return BaseResult.success(200, "ok", order);
    }
    /**
     * 测试 url 传参
     *
     * @param id
     * @return
     */
    @GetMapping("testUrlParam/{id}")
    public BaseResult testUrlParam(@PathVariable("id") Integer id) {
        System.out.println(id);
        return BaseResult.success(200, "ok", id);
    }
}

