package com.example.SnakeAndLadder.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID game_id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> gameRankings;

    private int no_of_players;
    private int no_of_turns;

    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    private UUID room_id;
    private GameStatus game_status;



//    game meta data
}
