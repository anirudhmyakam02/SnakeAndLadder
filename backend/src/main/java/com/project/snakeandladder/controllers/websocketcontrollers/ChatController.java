package com.project.snakeandladder.controllers.websocketcontrollers;

import com.project.snakeandladder.config.WebSocketEventListener;
import com.project.snakeandladder.dtos.ChatMessageDemo;
import com.project.snakeandladder.dtos.PersonalMessageDemo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    private WebSocketEventListener  webSocketEventListener;
    public ChatController(WebSocketEventListener webSocketEventListener) {
        this.webSocketEventListener = webSocketEventListener;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDemo sendMessage(@Payload ChatMessageDemo chatMessage) {

        return chatMessage;

    }

    @MessageMapping("/addUser")
    @SendTo("/topic/public")
    public ChatMessageDemo addUser(@Payload ChatMessageDemo chatMessage, SimpMessageHeaderAccessor headerAccessor) {

        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;

    }


    @MessageMapping("/sendPrivateMessage")
    public void sendPrivateMessage(@Payload PersonalMessageDemo personalMessageDemo){
        webSocketEventListener.sendMessageToUser(personalMessageDemo);
    }

}
