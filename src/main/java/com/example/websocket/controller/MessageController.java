package com.example.websocket.controller;

import com.example.websocket.response.Greeting;
import com.example.websocket.response.HelloMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessagingTemplate messageTemplate;
    @GetMapping("/send/{user}")
    private String sendMessage(@PathVariable String user){
        UserMessage message = new UserMessage();
        message.setTargetUserName(user);
        message.setMessage("푸시메시지 전달" + user);
        messageTemplate.convertAndSendToUser(message.getTargetUserName(), "/topic/data", new Greeting(HtmlUtils.htmlEscape(message.getMessage())));
        return "aa";
    }

    @GetMapping("/notice")
    private String sendNotice(){
        HelloMessage message = new HelloMessage();
        message.setName("전체 노티메시지 전달");
        messageTemplate.convertAndSend("/topic/message", new Greeting(HtmlUtils.htmlEscape(message.getName())));
        return "aa";
    }
}
