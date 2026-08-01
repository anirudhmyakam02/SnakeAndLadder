package com.project.snakeandladder.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID player_id;

    @OneToOne
    @JsonIgnoreProperties({"password", "created_at", "updated_at"})
    private User user;

    private int position;
    private int turn_no;
    private String sessionName;

    @ManyToOne
    private LiveGame game;

    @ManyToOne
    private Room room;

    private boolean readyToPlay;

    private int playerTurn;
    private int turns_skipped;

    private LocalDateTime connected_at;
    private LocalDateTime last_seen;
}
