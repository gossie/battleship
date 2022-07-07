package com.github.gossie.battleship.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDocumentRepository extends MongoRepository<GameDocument, String> {
}
