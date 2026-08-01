package com.project.snakeandladder.repositories;

import com.project.snakeandladder.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {

    Optional<Room> findByRoomCode(String roomCode);
    Optional<Room> findByHost_Username(String hostUsername);
}
