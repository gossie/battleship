package com.github.gossie.battleship.domain;

import java.util.List;

public record Board(int width, int height, List<Ship> ships) {
}
