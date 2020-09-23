package com.me.xpxq.xpxqnote.controller;

import com.me.xpxq.xpxqcommon.util.Res;
import com.me.xpxq.xpxqnote.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页请求
 */
@RestController
@RequestMapping("/note")
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/getIndex")
    public Res getIndexList(String type){
        return indexService.getIndexList(type);
    }
}
