package com.github.gossie.battleship.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public enum Direction {
    UP((p, i) -> new Position(p.x(), p.y() - i)),
    DOWN((p, i) -> new Position(p.x(), p.y() + i)),
    LEFT((p, i) -> new Position(p.x() - i, p.y())),
    RIGHT((p, i) -> new Position(p.x() + i, p.y()));

    private final BiFunction<Position, Integer, Position> f;

    Direction(BiFunction<Position, Integer, Position> f) {
        this.f = f;
    }

    public Position getCoordinate(Position position, int offset) {
        return f.apply(position, offset);
    }
    public List<Position> getAllCoordinates(Position start, int length) {
        List<Position> allCoordinates = new ArrayList<>();
        for (int i=0; i<length; i++) {
            allCoordinates.add(getCoordinate(start, i));
        }
        return allCoordinates;
    }

}
