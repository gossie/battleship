package com.github.gossie.battleship.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public record Game(@Id String id, Board board) {
    public Game addShip(Ship ship) {
        board.addShip(ship);
        return this;
    }

}
