package com.example.SnakeAndLadder.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID player_id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private int position;
    private int turn_no;
    private UUID session_id;
    private UUID game_id;

    private List<Integer> player_turn;

    private LocalDateTime joined_at;
    private LocalDateTime left_at;
    private int turns_skipped;
}
