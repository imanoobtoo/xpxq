package com.me.xpxq.xpxqnote.service;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.pojo.CLinks;

import java.util.List;

public interface ShipService {
    Res getShipList(Integer page);

    Res getDetailLinks(Integer nid,Integer uid);

    Res save(CLinks cLinks);

    Res getMemberHistoryShipList(List<Integer> nids);

    Res getMemberFavoriteShipList(List<Integer> nids);
}
