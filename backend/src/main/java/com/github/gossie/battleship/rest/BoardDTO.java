package com.github.gossie.battleship.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.Link;

import java.util.List;

record BoardDTO(@JsonIgnore String gameId, FieldDTO[][] fields, List<ShipDTO> ships) {

    public List<Link> getLinks() {
        return List.of(
                Link.of("/api/games/" + gameId + "/board/ships", "addShip")
        );
    }

}
