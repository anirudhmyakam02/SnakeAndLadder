package com.project.snakeandladder.controllers.restcontrollers;

import com.project.snakeandladder.dtos.RoomCreationDto;
import com.project.snakeandladder.entities.Player;
import com.project.snakeandladder.entities.Room;
import com.project.snakeandladder.services.PlayerService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerRestController {

    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/me")
    public Player getPlayer(Authentication authentication) {
        System.out.println(authentication.getName());
        return playerService.getPlayerWithSessionName(authentication.getName());
    }

    @PostMapping("/createRoom")
    public Room createNewRoom(@RequestBody RoomCreationDto roomCreationDto,  Authentication authentication) {
        return playerService.createNewRoom(roomCreationDto, authentication.getName());
    }

    @GetMapping("/joinRoom/{roomCode}")
    public Room joinRoomWithRoomCode(@PathVariable("roomCode") String roomCode, Authentication authentication) {
        return playerService.joinRoomWithRoomCode(roomCode, authentication.getName());
    }
}
