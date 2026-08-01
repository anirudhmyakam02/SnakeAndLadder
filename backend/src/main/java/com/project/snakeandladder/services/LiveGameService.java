package com.project.snakeandladder.services;

import com.project.snakeandladder.entities.LiveGame;
import com.project.snakeandladder.repositories.LiveGameRepository;
import org.springframework.stereotype.Service;

@Service
public class LiveGameService {

    private final LiveGameRepository liveGameRepository;

    public LiveGameService (LiveGameRepository liveGameRepository) {
        this.liveGameRepository = liveGameRepository;
    }

    public LiveGame createNewGame(){

        LiveGame liveGame = new LiveGame();
        liveGameRepository.save(liveGame);
        return liveGame;
    }
}
