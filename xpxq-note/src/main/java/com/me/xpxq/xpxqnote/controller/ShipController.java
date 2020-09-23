package com.me.xpxq.xpxqnote.controller;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.pojo.CLinks;
import com.me.xpxq.xpxqnote.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class ShipController {
    @Autowired
    ShipService shipService;

    /**
     * 获取船厂列表
     * @param page
     * @return
     */
    @GetMapping("/getShipList")
    public Res getShipList(Integer page){
        return shipService.getShipList(page);
    }

    /**
     * 获取列表内单项具体url
     * @param nid
     * @return
     */
    @GetMapping("/getDetailLinks")
    public Res getDetailLinks(@RequestParam("nid") Integer nid,@RequestParam("uid") Integer uid){
        return shipService.getDetailLinks(nid,uid);
    }

    /**
     * 数据入库 TODO
     * @param cLinks
     * @return
     */
    @PostMapping("/save")
    public Res save(@RequestBody CLinks cLinks){
        return shipService.save(cLinks);
    }


}
