package com.me.xpxq.xpxqmember.service.impl;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqmember.dao.UFavoriteDao;
import com.me.xpxq.xpxqmember.dao.UHistoryDao;
import com.me.xpxq.xpxqmember.dao.UInfoDao;
import com.me.xpxq.xpxqmember.feign.NoteFeignClientService;
import com.me.xpxq.xpxqmember.pojo.UFavorite;
import com.me.xpxq.xpxqmember.pojo.UHistory;
import com.me.xpxq.xpxqmember.pojo.UInfo;
import com.me.xpxq.xpxqmember.service.MemberService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    UInfoDao uInfoDao;
    @Autowired
    UHistoryDao uHistoryDao;
    @Autowired
    UFavoriteDao uFavoriteDao;
    @Autowired
    NoteFeignClientService noteFeignClientService;
    @Override
    public Res getMemeberInfo(Integer uid) {
        UInfo info = uInfoDao.selectByPrimaryKey(uid);
        if (!Objects.isNull(info)){
            return Res.ok(info);
        }
        return Res.fail();
    }

    @Override
    public Res getMemberHistory(Integer uid) {
        List<Integer> nids = uInfoDao.selectNidByUid(uid);
        if (!Objects.isNull(nids) && nids.size()>0){
            return noteFeignClientService.getMemberHistoryShipList(nids);
        }
        return Res.fail();
    }

    @Override
    public Res getMemberFavorite(Integer uid) {
        List<Integer> nids = uInfoDao.selectFavoriteNidByUid(uid);
        if (!Objects.isNull(nids) && nids.size()>0){
            return noteFeignClientService.getMemberFavoriteShipList(nids);
        }
        return Res.fail();
    }

    @Override
    public Res addMemberHistory(UHistory history) {
        Assert.notNull(history);
        int insert = uHistoryDao.insert(history);
        if (insert>0){
            return Res.ok();
        }
        return Res.fail();
    }

    @Override
    public Res addMemberFavorite(UFavorite favorite) {
        Assert.notNull(favorite);
        int insert = uFavoriteDao.insert(favorite);
        if (insert>0){
            return Res.ok();
        }
        return Res.fail();
    }

    @Override
    public Res removeMemberHistory(Integer uid) {
        int delete = uHistoryDao.deleteByUid(uid);
        if (delete>0){
            return Res.ok();
        }
        return Res.fail();
    }

    @Override
    public Res removeMemberFavorite(Integer uid, Integer nid) {
        int delete = uFavoriteDao.deleteByUidAndNid(uid,nid);
        if (delete>0){
            return Res.ok();
        }
        return Res.fail();
    }
}
