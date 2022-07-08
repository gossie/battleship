package com.github.gossie.battleship.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game createGame() {
        return gameRepository.save(new Game(null, new Board(10, 10, new ArrayList<>())));
    }

    public Optional<Game> findGame(String id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> createShip(String gameId, Ship ship) {
        return gameRepository.findById(gameId)
                .map(game -> game.addShip(ship))
                .map(gameRepository::save);
    }
}
