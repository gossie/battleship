package com.github.gossie.battleship.domain;

import java.util.function.BiFunction;

public enum Direction {
    UP((p, i) -> new Point(p.x(), p.y() - i)),
    DOWN((p, i) -> new Point(p.x(), p.y() + i)),
    LEFT((p, i) -> new Point(p.x() - i, p.y())),
    RIGHT((p, i) -> new Point(p.x() + i, p.y()));

    private final BiFunction<Point, Integer, Point> f;

    Direction(BiFunction<Point, Integer, Point> f) {
        this.f = f;
    }

    public Point getCoordinate(Point point, int offset) {
        return f.apply(point, offset);
    }
}
