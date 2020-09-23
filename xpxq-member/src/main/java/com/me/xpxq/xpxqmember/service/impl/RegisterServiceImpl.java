package com.me.xpxq.xpxqmember.service.impl;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqmember.dao.UInfoDao;
import com.me.xpxq.xpxqmember.pojo.UInfo;
import com.me.xpxq.xpxqmember.service.RegisterService;
import com.me.xpxq.xpxqmember.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UInfoDao uInfoDao;

    @Override
    public Res register(UInfo uInfo) {
        if (preRegister(uInfo.getUsername())){
            System.out.println(uInfo.getUsername() + " ==  =" + uInfo.getPassword());
            uInfo.setNickname(uInfo.getUsername());
            //TODO 密码加密
            System.out.println("-------------");
            System.out.println(PasswordUtils.encode(uInfo.getPassword()));
            System.out.println("-------------");
            uInfo.setPassword(PasswordUtils.encode(uInfo.getPassword()));
            int insert = uInfoDao.insert(uInfo);
            if (insert>0){
                return Res.ok();
            }
        }
        return Res.fail();
    }

    /**
     * 检查账号是否可以注册,true表示可以注册
     * @return
     */
    private boolean preRegister(String username) {
        UInfo u = uInfoDao.selectByUsername(username);
        if (Objects.isNull(u)){
            return true;
        }
        return false;
    }
}
