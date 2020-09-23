package com.me.xpxq.xpxqmember.service;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqmember.pojo.UFavorite;
import com.me.xpxq.xpxqmember.pojo.UHistory;

public interface MemberService {
    Res getMemeberInfo(Integer uid);

    Res getMemberHistory(Integer uid);

    Res getMemberFavorite(Integer uid);

    Res addMemberHistory(UHistory history);

    Res addMemberFavorite(UFavorite favorite);

    Res removeMemberHistory(Integer uid);

    Res removeMemberFavorite(Integer uid, Integer nid);
}
