package com.project.snakeandladder.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LiveGame {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID game_id;
    private int turn_no;
    @OneToOne(cascade = CascadeType.ALL)
    private User current_player;
    private int last_dice_value;

    @LastModifiedDate
    private LocalDateTime last_update_time;

    @CreatedDate
    private LocalDateTime start_time;
}
