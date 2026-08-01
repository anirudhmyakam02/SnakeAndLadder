package com.project.snakeandladder.entities;

import com.project.snakeandladder.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID user_id;

    private String username;
    private String password;
    private String email;

    private UserStatus status;
    private LocalDateTime last_seen_at;

    @CreatedDate
    private LocalDate created_at;

    @LastModifiedDate
    private LocalDate updated_at;

}
