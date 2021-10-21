package com.example.websocket.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HelloMessage {

    private String name;

    @Builder
    public HelloMessage(String name) {
        this.name = name;
    }
}
