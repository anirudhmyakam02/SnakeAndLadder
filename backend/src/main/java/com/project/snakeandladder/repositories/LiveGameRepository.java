package com.project.snakeandladder.repositories;

import com.project.snakeandladder.entities.LiveGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LiveGameRepository extends JpaRepository<LiveGame, UUID> {


}
