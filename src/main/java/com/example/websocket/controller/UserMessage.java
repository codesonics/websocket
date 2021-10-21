package com.example.websocket.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserMessage {

    private String targetUserName;
    private String message;

    @Builder
    public UserMessage(String targetUserName, String message) {
        this.targetUserName = targetUserName;
        this.message = message;
    }
}
