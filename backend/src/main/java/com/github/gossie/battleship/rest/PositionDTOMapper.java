package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Position;
import org.springframework.stereotype.Component;

@Component
class PositionDTOMapper {
    Position map(PositionDTO position) {
        return new Position(position.x(), position.y());
    }

    PositionDTO map(Position position) {
        return new PositionDTO(position.x(), position.y());
    }
}
