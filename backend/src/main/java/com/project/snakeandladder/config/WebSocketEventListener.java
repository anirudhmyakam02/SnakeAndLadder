package com.project.snakeandladder.config;

import com.project.snakeandladder.dtos.ChatMessageDemo;
import com.project.snakeandladder.dtos.PersonalMessageDemo;
import com.project.snakeandladder.entities.Player;
import com.project.snakeandladder.enums.MessageType;
import com.project.snakeandladder.services.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messagingTemplate;
    private final PlayerService playerService;


    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {

        System.out.println("handleWebSocketConnectListener");
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Principal user = headerAccessor.getUser();
        String username = (String) user.getName();

    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Principal user = headerAccessor.getUser();

        if (user == null){
            return;
        }
        String username = (String) user.getName();

        playerService.updatePlayerLastSeen(username);

        if (username != null) {
            log.info("user disconnected: {}", username);

            var chatMessage = ChatMessageDemo.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

    public void sendMessageToUser(PersonalMessageDemo personalMessageDemo) {

        System.out.println("Sending personal message to user: " + personalMessageDemo.toString());

        messagingTemplate.convertAndSendToUser(
                personalMessageDemo.getRecipient(),
                "/queue/private",
                personalMessageDemo
        );
    }

}
