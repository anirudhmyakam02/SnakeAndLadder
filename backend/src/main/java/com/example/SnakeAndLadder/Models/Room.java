package com.example.SnakeAndLadder.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID room_id;

    String room_code;
    int room_limit;
    int games_played;

    UUID current_game_id;

    LocalDateTime last_active;
    UUID host_id;
    RoomStatus room_status;

    LocalDateTime created_at;
}
