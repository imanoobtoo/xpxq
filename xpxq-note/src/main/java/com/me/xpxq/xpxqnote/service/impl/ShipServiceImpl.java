package com.me.xpxq.xpxqnote.service.impl;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.dao.CLinksDao;
import com.me.xpxq.xpxqnote.dao.CNoteDao;
import com.me.xpxq.xpxqnote.pojo.CLinks;
import com.me.xpxq.xpxqnote.pojo.CNote;
import com.me.xpxq.xpxqnote.service.ShipService;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    CNoteDao cNoteDao;
    @Autowired
    CLinksDao cLinksDao;
//    @Autowired
//    RabbitTemplate rabbitTemplate;

    /**
     * 根据page获取分页数据
     * 默认每次获取20条
     * @param page 页数
     * @return
     */
    @Override
    public Res getShipList(Integer page) {
        System.out.println("page = " + page);
        List<CNote> notes = cNoteDao.selectListByPage(page * 20);
        if (!Objects.isNull(notes) && notes.size()>0){
            return Res.ok(notes);
        }
        return Res.fail();
    }

    @Override
    public Res getDetailLinks(Integer nid, Integer uid) {
//        Map<String,Integer> map = new HashMap<>();
//        map.put("uid",uid);
//        map.put("nid",nid);
        // 发送消息增加历史记录
//        rabbitTemplate.convertAndSend("xpxq","member:info:history",map);
        // 发送消息增加exp
//        rabbitTemplate.convertAndSend("xpxq","member:info:exp",uid);
        List<CLinks> links = cLinksDao.selectLinksByNoteId(nid);
        if (!Objects.isNull(links) && links.size()>0){
            return Res.ok(links);
        }
        return Res.fail();
    }

    @Override
    public Res save(CLinks cLinks) {
        int insert = cLinksDao.insert(cLinks);
        if (insert>0){
            return Res.ok();
        }
        return Res.fail();
    }

    /**
     * 根据noteId获取对应历史记录的船厂列表
     * @param nids
     * @return
     */
    @Override
    public Res getMemberHistoryShipList(List<Integer> nids) {
        List<CNote> notes = cNoteDao.selectListByUid(nids);
        if (!Objects.isNull(notes) && notes.size()>0){
            return Res.ok(notes);
        }
        return Res.fail();
    }

    @Override
    public Res getMemberFavoriteShipList(List<Integer> nids) {
        List<CNote> notes = cNoteDao.selectListByUid(nids);
        if (!Objects.isNull(notes) && notes.size()>0){
            return Res.ok(notes);
        }
        return Res.fail();
    }
}
