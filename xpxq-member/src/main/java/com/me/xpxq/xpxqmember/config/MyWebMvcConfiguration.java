package com.me.xpxq.xpxqmember.config;

import com.me.xpxq.xpxqmember.interceptor.CaptchaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    CaptchaInterceptor captchaInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(captchaInterceptor).addPathPatterns("/member/login");
    }
}
