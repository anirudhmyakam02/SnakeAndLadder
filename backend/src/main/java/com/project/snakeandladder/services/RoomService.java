package com.project.snakeandladder.services;

import com.project.snakeandladder.dtos.RoomCreationDto;
import com.project.snakeandladder.entities.Player;
import com.project.snakeandladder.entities.Room;
import com.project.snakeandladder.entities.User;
import com.project.snakeandladder.enums.RoomStatus;
import com.project.snakeandladder.repositories.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final UserService userService;
    public RoomService(RoomRepository roomRepository,  UserService userService) {
        this.roomRepository = roomRepository;
        this.userService = userService;
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private String generateRoomCode(){
        StringBuffer roomCode = new StringBuffer();
        roomCode.append((char)getRandomNumber(65,90));
        roomCode.append((char)getRandomNumber(97,122));
        roomCode.append((char)getRandomNumber(97,122));
        roomCode.append((char)getRandomNumber(48,57));
        roomCode.append((char)getRandomNumber(48,57));
        roomCode.append((char)getRandomNumber(65,90));

        return  roomCode.toString();
    }


    public Room createNewRoom(RoomCreationDto roomCreationDto, String hostUsername) {

        User user = userService.getUserByUsername(hostUsername);

        Room room = roomRepository.findByHost_Username(hostUsername).orElse(null);
        if (room !=null){
            return room;
        }


        room = Room.builder()
                .roomLimit(roomCreationDto.getRoomLimit())
                .host(user)
                .roomCode(generateRoomCode())
                .roomStatus(RoomStatus.WAITING)
                .build();

        roomRepository.save(room);
        return room;
    }

    public Room getRoomByRoomCode(String roomCode) {
        return roomRepository.findByRoomCode(roomCode).orElse(null);
    }

    public Room updateRoomPlayersJoined(Room room, Player player) {

        List<Player> players = room.getPlayerJoined();
        if(players==null){
            System.out.println("players are null ");
            if(room.getHost().equals(player.getUser())){
            System.out.println("\n\n in the host user updation \n\n");
                players = new ArrayList<>();
            }
        }

        players.add(player);
        room.setPlayerJoined(players);
        return roomRepository.save(room);
    }
}
