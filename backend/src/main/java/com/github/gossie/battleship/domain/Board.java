package com.github.gossie.battleship.domain;

import java.util.List;

public record Board(int width, int height, List<Ship> ships) {
    public void addShip(Ship ship) {
        checkBoardBorder(ship);
        checkCollision(ship);

        ships.add(ship);
    }

    private void checkBoardBorder(Ship ship) {
        if (ship.passesBorder(width, height)) {
            throw new IllegalStateException();
        }
    }

    private void checkCollision(Ship ship) {
        ships.stream()
                .filter(s -> s.collidesWith(ship))
                .findFirst()
                .ifPresent(s -> {
                    throw new IllegalStateException();
                });
    }
}
