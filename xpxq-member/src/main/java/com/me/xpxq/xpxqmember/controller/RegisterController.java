package com.me.xpxq.xpxqmember.controller;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqmember.pojo.UInfo;
import com.me.xpxq.xpxqmember.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册请求
 */
@RestController
@RequestMapping("/member")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public Res register(@RequestBody() UInfo uInfo){
        return registerService.register(uInfo);
    }
}
