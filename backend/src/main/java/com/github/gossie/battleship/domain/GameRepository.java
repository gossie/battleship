package com.github.gossie.battleship.domain;

import java.util.Optional;

public interface GameRepository {
    Game save(Game game);

    Optional<Game> findById(String id);
}
