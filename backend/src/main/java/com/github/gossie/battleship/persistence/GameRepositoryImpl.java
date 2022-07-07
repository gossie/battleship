package com.github.gossie.battleship.persistence;

import com.github.gossie.battleship.domain.Game;
import com.github.gossie.battleship.domain.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class GameRepositoryImpl implements GameRepository {

    private final GameDocumentRepository gameDocumentRepository;
    private final GamePersistenceMapper gameMapper;

    @Override
    public Game save(Game game) {
        return gameMapper.map(gameDocumentRepository.save(gameMapper.map(game)));
    }

    @Override
    public Optional<Game> findById(String id) {
        return gameDocumentRepository.findById(id)
                .map(gameMapper::map);
    }
}
