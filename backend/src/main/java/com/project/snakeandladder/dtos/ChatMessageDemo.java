package com.project.snakeandladder.dtos;

import com.project.snakeandladder.enums.MessageType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDemo {
    private String message;
    private String sender;
    private MessageType type;
}
