package com.project.snakeandladder.dtos;

import com.project.snakeandladder.enums.MessageType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PersonalMessageDemo {
    private String message;
    private String sender;
    private MessageType type;
    private String recipient;
}