package com.github.gossie.battleship.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
public record Game(@Id String id, Board board, List<Player> players) {
    public Game addShip(Ship ship) {
        board.addShip(ship);
        return this;
    }

    public Game addPlayer(Player player) {
        players.add(player);
        return this;
    }
}
