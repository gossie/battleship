package com.github.gossie.battleship.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceTest {

    @Test
    void shouldCreateGame() {
        var gameToBeSaved = new Game(null, new Board(10, 10, List.of()));
        var expectedGame = new Game("4711", new Board(10, 10, List.of()));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.save(gameToBeSaved)).thenReturn(expectedGame);
        var gameService = new GameService(gameRepository);

        var actual = gameService.createGame();

        assertThat(actual).isEqualTo(expectedGame);
    }

    @Test
    void shouldFindGame() {
        var expectedGame = new Game("4711", new Board(10, 10, List.of()));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(expectedGame));
        var gameService = new GameService(gameRepository);

        var actual = gameService.findGame("4711");

        assertThat(actual).contains(expectedGame);
    }

    @Test
    void shouldCreateShip() {
        var savedGame = new Game("4711", new Board(10, 10, new ArrayList<>()));
        var gameToBeSaved = new Game("4711", new Board(10, 10, List.of(new Ship(new Position(2, 3), 4, Direction.DOWN))));
        var expectedGame = new Game("4711", new Board(10, 10, List.of(new Ship(new Position(2, 3), 4, Direction.DOWN))));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(savedGame));
        when(gameRepository.save(gameToBeSaved)).thenReturn(expectedGame);
        var gameService = new GameService(gameRepository);

        var actual = gameService.createShip("4711", new Ship(new Position(2, 3), 4, Direction.DOWN));

        assertThat(actual).contains(expectedGame);
    }

    @Test
    void shouldNotCreateShipDueToCollision() {
        var savedGame = new Game("4711", new Board(10, 10, List.of(new Ship(new Position(2, 3), 4, Direction.DOWN))));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(savedGame));
        var gameService = new GameService(gameRepository);

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> gameService.createShip("4711", new Ship(new Position(2, 3), 4, Direction.DOWN)));
    }

    @Test
    void shouldNotCreateShipDueEndOfBoard_left() {
        var savedGame = new Game("4711", new Board(10, 10, List.of()));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(savedGame));
        var gameService = new GameService(gameRepository);

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> gameService.createShip("4711", new Ship(new Position(0, 2), 4, Direction.LEFT)));
    }

    @Test
    void shouldNotCreateShipDueEndOfBoard_right() {
        var savedGame = new Game("4711", new Board(10, 10, List.of()));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(savedGame));
        var gameService = new GameService(gameRepository);

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> gameService.createShip("4711", new Ship(new Position(7, 5), 4, Direction.RIGHT)));
    }

    @Test
    void shouldNotCreateShipDueEndOfBoard_up() {
        var savedGame = new Game("4711", new Board(10, 10, List.of()));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(savedGame));
        var gameService = new GameService(gameRepository);

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> gameService.createShip("4711", new Ship(new Position(5, 2), 4, Direction.UP)));
    }

    @Test
    void shouldNotCreateShipDueEndOfBoard_down() {
        var savedGame = new Game("4711", new Board(10, 10, List.of()));

        var gameRepository = mock(GameRepository.class);
        when(gameRepository.findById("4711")).thenReturn(Optional.of(savedGame));
        var gameService = new GameService(gameRepository);

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> gameService.createShip("4711", new Ship(new Position(5, 7), 4, Direction.DOWN)));
    }

}