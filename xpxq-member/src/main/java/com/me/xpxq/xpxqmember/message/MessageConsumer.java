//package com.me.xpxq.xpxqmember.message;
//
//import com.me.xpxq.xpxqcommon.util.Res;
//import com.me.xpxq.xpxqmember.pojo.UHistory;
//import com.me.xpxq.xpxqmember.service.MemberService;
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.rabbit.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//public class MessageConsumer {
//    @Autowired
//    MemberService memberService;
//
//    @RabbitListener(
//            bindings = {
//                    @QueueBinding(value = @Queue(value = "queue"),
//                    exchange = @Exchange(name = "xpxq",type = ExchangeTypes.DIRECT),
//                    key = "member:info:history")
//            }
//    )
//    @RabbitHandler
//    public void handleHistory(Map map){
//        Integer uid = (Integer) map.get("uid");
//        Integer nid = (Integer) map.get("nid");
//        UHistory uHistory = new UHistory();
//        uHistory.setNid(nid);
//        uHistory.setUid(uid);
//        memberService.addMemberHistory(uHistory);
//
//    }
//}
