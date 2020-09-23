package com.me.xpxq.xpxqnote.controller;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member")
public class FeignServiceController {
    @Autowired
    ShipService shipService;

    @GetMapping("/getMemberHistoryShipList")
    public Res getMemberHistoryShipList(@RequestParam("nids") List<Integer> nids){
        return shipService.getMemberHistoryShipList(nids);
    }

    @GetMapping("/getMemberFavoriteShipList")
    public Res getMemberFavoriteShipList(@RequestParam("nids") List<Integer> nids){
        return shipService.getMemberFavoriteShipList(nids);
    }
}
