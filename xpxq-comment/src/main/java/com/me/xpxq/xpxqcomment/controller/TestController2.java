package com.me.xpxq.xpxqcomment.controller;

import com.me.xpxq.xpxqcomment.feign.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    @Autowired
    FeignClientService feignClient;

    @GetMapping("/testGet")
    public void test2(){
        String test = feignClient.test();
        System.out.println("从远程服务获取到的测试内容为:" + test);
    }
}
