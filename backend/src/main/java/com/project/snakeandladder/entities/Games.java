package com.project.snakeandladder.entities;

import com.project.snakeandladder.enums.GameStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID game_id;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<User> gameRankings;

    private int no_of_players;
    private int no_of_turns;
    private UUID room_id;
    private GameStatus game_status;

    private LocalDateTime started_at;
    private LocalDateTime ended_at;

}
