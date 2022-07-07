package com.github.gossie.battleship.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
record GameDocument(@Id String id, BoardDocument board) {
}
