package com.github.gossie.battleship.persistence;

import com.github.gossie.battleship.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class GamePersistenceMapper {

    private final BoardPersistenceMapper boardPersistenceMapper;

    Game map(GameDocument game) {
        return new Game(game.id(), boardPersistenceMapper.map(game.board()));
    }

    GameDocument map(Game game) {
        return new GameDocument(game.id(), boardPersistenceMapper.map(game.board()));
    }

}
