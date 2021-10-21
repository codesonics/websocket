package com.example.websocket.controller;

import com.example.websocket.response.Greeting;
import com.example.websocket.response.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message){
        System.out.println(message.toString());
        return new Greeting("반가워요" + HtmlUtils.htmlEscape(message.getName()));
    }
}
