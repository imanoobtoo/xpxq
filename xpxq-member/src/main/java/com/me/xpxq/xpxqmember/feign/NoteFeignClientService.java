package com.me.xpxq.xpxqmember.feign;

import com.me.xpxq.xpxqcommon.util.Res;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
//@Component
@FeignClient(name = "xpxq-note-dev")
public interface NoteFeignClientService {

    @GetMapping("/getMemberHistoryShipList")
    public Res getMemberHistoryShipList(@RequestParam("nids") List<Integer> nids);
    @GetMapping("/getMemberFavoriteShipList")
    public Res getMemberFavoriteShipList(@RequestParam("nids") List<Integer> nids);
}
