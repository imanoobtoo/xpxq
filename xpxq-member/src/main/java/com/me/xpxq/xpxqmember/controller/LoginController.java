package com.me.xpxq.xpxqmember.controller;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqmember.pojo.UInfo;
import com.me.xpxq.xpxqmember.service.LoginService;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 用户登录请求
 */
@RestController
@RequestMapping("/member")
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @PostMapping("/login")
    public Res login(@RequestBody() UInfo uInfo){
        return loginService.login(uInfo);
    }

    @GetMapping("/getCaptcha")
    public Res getCaptcha(HttpServletRequest request, HttpServletResponse response){
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为30分钟
        redisTemplate.opsForValue().set(key,verCode,3,TimeUnit.MINUTES);
        // 将key和base64返回给前端
        Map<String,String> map = new HashMap();
        map.put("key",key);
        map.put("image",specCaptcha.toBase64());
        return Res.ok(map);
    }


}
