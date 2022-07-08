package com.github.gossie.battleship;

import org.springframework.hateoas.Link;

import java.util.List;

public record TestGameDTO(String id, List<Link> links) {
}
