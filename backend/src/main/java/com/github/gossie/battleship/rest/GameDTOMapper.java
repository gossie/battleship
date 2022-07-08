package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class GameDTOMapper {

    private final BoardDTOMapper boardMapper;

    GameDTO map(Game game) {
        return new GameDTO(game.id(), boardMapper.map(game.board(), game.id()));
    }

}
