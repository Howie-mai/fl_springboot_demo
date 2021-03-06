package com.zhku.mh.controller;

import com.zhku.mh.common.result.ChatResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

@Controller
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleChat(Principal principal,ChatResp chatResp) {
        System.out.println(chatResp);
//        String destUser = msg.substring(msg.lastIndexOf(";") + 1, msg.length());
//        String message = msg.substring(0, msg.lastIndexOf(";"));
        chatResp.setFrom(principal.getName());
        chatResp.setTime(new Date());
        System.out.println(chatResp);
        messagingTemplate.convertAndSendToUser(chatResp.getTo(), "/queue/chat", chatResp);
    }

    @MessageMapping("/ws/nf")
    @SendTo("/topic/nf")
    public String handleNF() {
        return "系统消息";
    }
}
