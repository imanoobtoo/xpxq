package com.me.xpxq.xpxqnote.controller;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.service.ShipDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class ShipDetailController {
    @Autowired
    ShipDetailService shipDetailService;

    @GetMapping("/getShipDetail")
    public Res getShipDetail(Integer nid){
        return shipDetailService.getShipDetail(nid);
    }
}
