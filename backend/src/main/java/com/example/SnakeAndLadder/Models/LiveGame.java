package com.example.SnakeAndLadder.Models;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class LiveGame {

    private UUID game_id;
    private int turn_no;
    private UUID current_player_id;
    private int last_dice_value;
    private LocalDateTime last_update_time;
    private LocalDateTime start_time;
}
