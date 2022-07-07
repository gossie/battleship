package com.github.gossie.battleship.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game createGame() {
        return gameRepository.save(new Game(null, new Board(10, 10)));
    }

    public Optional<Game> findGame(String id) {
        return gameRepository.findById(id);
    }
}
