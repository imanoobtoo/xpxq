package com.me.xpxq.xpxqnote.service.impl;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.dao.CLinksDao;
import com.me.xpxq.xpxqnote.pojo.CLinks;
import com.me.xpxq.xpxqnote.service.ShipDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class ShipDetailServiceImpl implements ShipDetailService {
    @Autowired
    CLinksDao cLinksDao;

    @Override
    public Res getShipDetail(Integer nid) {
        List<CLinks> cLinks = cLinksDao.selectLinksByNoteId(nid);
        if (!Objects.isNull(cLinks) && cLinks.size()>0){
            return Res.ok(cLinks);
        }
        return Res.fail();
    }
}
