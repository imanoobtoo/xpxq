package com.me.xpxq.xpxqmember.interceptor;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CaptchaInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("接收到登录请求，进行验证码验证...");


        String captchaKey = request.getHeader("captchaKey");
        String captcha = request.getHeader("captcha");
        logger.info("---------" + captcha + "//" + captchaKey);
        try {
            if (Strings.isNotBlank(captcha) && Strings.isNotBlank(captchaKey)){
                System.out.println(redisTemplate.opsForValue().get(captchaKey) + "------redis");
                if (captcha.equals(redisTemplate.opsForValue().get(captchaKey))){
                    logger.info("验证通过");
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("发生异常，验证失败");
            return false;
        }

        logger.info("验证失败");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
