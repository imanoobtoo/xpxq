package com.me.xpxq.xpxqmember.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class TestController {

    @GetMapping("/getTest")
    public String test(){
        return "test data";
    }
}
