package com.project.snakeandladder.controllers.restcontrollers;

import com.project.snakeandladder.dtos.RoomCreationDto;
import com.project.snakeandladder.entities.Room;
import com.project.snakeandladder.services.RoomService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomRestController {

    private RoomService roomService;
    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public Room createRoom(@RequestBody RoomCreationDto room, Authentication authentication) {
        String username = authentication.getName();
        return roomService.createNewRoom(room, username);
    }
}
