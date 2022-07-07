package com.github.gossie.battleship.rest;

import org.springframework.hateoas.Link;

import java.util.List;

public record GameDTO(String id, BoardDTO board) {

    public List<Link> getLinks() {
        return List.of(
                Link.of("/api/games/" + id, "self")
        );
    }
}
