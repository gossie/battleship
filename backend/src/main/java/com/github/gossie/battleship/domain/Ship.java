package com.github.gossie.battleship.domain;

import java.util.Collections;

public record Ship(Position start, int length, Direction direction) {
    public boolean collidesWith(Ship ship) {
        var myCoordinates = direction.getAllCoordinates(start, length);
        var othersCoordinates = ship.direction().getAllCoordinates(ship.start(), ship.length());
        return !Collections.disjoint(myCoordinates, othersCoordinates);
    }
}
