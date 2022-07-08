package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Direction;

public record ShipDTO(PositionDTO start, int length, Direction direction) {
}
