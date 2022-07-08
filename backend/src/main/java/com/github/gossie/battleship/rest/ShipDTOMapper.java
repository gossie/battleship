package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Ship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ShipDTOMapper {

    private final PositionDTOMapper positionMapper;

    Ship map(ShipDTO ship) {
        return new Ship(positionMapper.map(ship.start()), ship.length(), ship.direction());
    }
}
