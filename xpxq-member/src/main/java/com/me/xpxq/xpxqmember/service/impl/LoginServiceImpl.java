package com.me.xpxq.xpxqmember.service.impl;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqcommon.util.TokenUtils;
import com.me.xpxq.xpxqmember.dao.UInfoDao;
import com.me.xpxq.xpxqmember.pojo.UInfo;
import com.me.xpxq.xpxqmember.service.LoginService;
import com.me.xpxq.xpxqmember.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UInfoDao uInfoDao;
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Override
    public Res login(UInfo uInfo) {
        //TODO 密码加密
        uInfo.setPassword(PasswordUtils.encode(uInfo.getPassword()));
        Integer uid = uInfoDao.selectByUsernamePassword(uInfo);
        if (!Objects.isNull(uid) && uid != 0){
            //TODO 加token
            String token = TokenUtils.encode(uInfo.getUsername());
            // 存redis
            ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
            stringStringValueOperations.set(token,"exists",60L, TimeUnit.MINUTES);
            Map<String,String> map = new HashMap<>();
            map.put("token",token);
            map.put("uid",uid.toString());
            return Res.ok(map);
        }
        return Res.fail();
    }
}
