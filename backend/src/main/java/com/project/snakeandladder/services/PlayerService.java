package com.project.snakeandladder.services;

import com.project.snakeandladder.dtos.RoomCreationDto;
import com.project.snakeandladder.entities.Player;
import com.project.snakeandladder.entities.Room;
import com.project.snakeandladder.entities.User;
import com.project.snakeandladder.repositories.PlayerRepository;
import jakarta.persistence.FetchType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final UserService userService;
    private final RoomService roomService;
    public PlayerService(PlayerRepository playerRepository, UserService userService, RoomService roomService) {
        this.playerRepository = playerRepository;
        this.userService = userService;
        this.roomService = roomService;
    }

    public Player createNewPlayer(String username) {
        System.out.println("createNewPlayer : "+username);
        User user = userService.getUserByUsername(username);

        Player player = Player.builder()
                .connected_at(LocalDateTime.now(ZoneId.of("Asia/Kolkata")))
                .sessionName(username)
                .user(user)
                .build();

        playerRepository.save(player);
        return player;
    }

    public Player getPlayerWithSessionName(String sessionName) {

        System.out.println(sessionName);
        Player player = playerRepository.findBySessionName(sessionName)
                .orElseGet( () ->  createNewPlayer(sessionName));

        return player;
    }

    public void updatePlayerLastSeen(String sessionName) {
        Player player = playerRepository.findBySessionName(sessionName)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Session not detected with username " + sessionName)
                );

        player.setLast_seen(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
    }

    public Room createNewRoom(RoomCreationDto roomCreationDto, String hostUsername) {

        Room room = roomService.createNewRoom(roomCreationDto, hostUsername);
        Player player = playerRepository.findBySessionName(hostUsername).orElseThrow(
                () -> new UsernameNotFoundException("Session not detected with username " + hostUsername)
        );

        player.setRoom(room);

        return roomService.updateRoomPlayersJoined(room, player);
    }

    public Room joinRoomWithRoomCode(String roomCode, String username) {

        Room room = roomService.getRoomByRoomCode(roomCode);

        if(room == null){
            return null;
        }

        if(room.getPlayerJoined().size() == room.getRoomLimit()){
//            we should throw here the room is full
            return null;
        }

        Player player = playerRepository.findByUser_Username(username).orElseThrow(
                () -> new UsernameNotFoundException("Player not found with username " + username)
        );


        player.setRoom(room);
        playerRepository.save(player);

        return roomService.updateRoomPlayersJoined(room, player);
    }
}
