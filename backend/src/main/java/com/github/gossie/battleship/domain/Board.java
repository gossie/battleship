package com.github.gossie.battleship.domain;

import java.util.List;

public record Board(int width, int height, List<Ship> ships) {
    public void addShip(Ship ship) {
        ships.stream()
                .filter(s -> s.collidesWith(ship))
                .findFirst()
                .ifPresent(s -> {
                    throw new IllegalStateException();
                });

        ships.add(ship);
    }
}
