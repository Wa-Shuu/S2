package com.washuu.nacosprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /**
     * 打招呼的接口
     *
     * @param name
     * @return
     */
    @GetMapping("hello")
    public String hello(String name) {
//    public String hello(@RequestParam("name") String name) {
        return "hello:"+name;
    }
}
