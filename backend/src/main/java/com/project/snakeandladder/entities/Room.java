package com.project.snakeandladder.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.snakeandladder.enums.RoomStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID room_id;

    private String roomCode;
    private int roomLimit;
    private int gamesPlayed;

    @OneToMany( mappedBy = "room")
    @JsonIgnoreProperties({"room", "game"})
    private List<Player> playerJoined;

    @OneToOne
    private LiveGame currentGame;

    private LocalDateTime last_active;

    @OneToOne
    @JsonIgnoreProperties({"password", "created_at", "updated_at"})
    private User host;
    private RoomStatus roomStatus;

    @CreationTimestamp
    private LocalDateTime created_at;
}
