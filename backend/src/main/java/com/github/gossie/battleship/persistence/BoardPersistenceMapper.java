package com.github.gossie.battleship.persistence;

import com.github.gossie.battleship.domain.Board;
import org.springframework.stereotype.Component;

@Component
class BoardPersistenceMapper {
    public Board map(BoardDocument board) {
        return new Board(board.width(), board.height());
    }

    public BoardDocument map(Board board) {
        return new BoardDocument(board.width(), board.height());
    }
}
