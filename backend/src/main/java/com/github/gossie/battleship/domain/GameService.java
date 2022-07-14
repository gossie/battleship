package com.github.gossie.battleship.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game createGame(String playerName) {
        if (playerName != null && !playerName.isBlank()) {
            return gameRepository.save(new Game(null, new Board(10, 10, List.of()), List.of(new Player(playerName))));
        }
        throw new IllegalArgumentException();
    }

    public Optional<Game> findGame(String id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> createShip(String gameId, Ship ship) {
        return gameRepository.findById(gameId)
                .map(game -> game.addShip(ship))
                .map(gameRepository::save);
    }

    public Optional<Game> addPlayer(String gameId, String playerName) {
        if (playerName != null && !playerName.isBlank()) {
            return gameRepository.findById(gameId)
                    .map(game -> game.addPlayer(new Player(playerName)))
                    .map(gameRepository::save);
        }
        throw new IllegalArgumentException();
    }

}
