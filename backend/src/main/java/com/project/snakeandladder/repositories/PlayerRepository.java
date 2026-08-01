package com.project.snakeandladder.repositories;

import com.project.snakeandladder.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findBySessionName(String session_name);
    Optional<Player> findByUser_Username(String user_name);
}
