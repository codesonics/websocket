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
        message.setMessage("하하하하하" + user);
        //messageTemplate.convertAndSendToUser(message.getTargetUserName(), "/topic/data", new Greeting(HtmlUtils.htmlEscape(message.getMessage())));
        HelloMessage hmessage = new HelloMessage();
        hmessage.setName("hihhi");
        messageTemplate.convertAndSend("/topic/message", hmessage);
        return "aa";
    }
}
