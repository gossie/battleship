package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Board;
import com.github.gossie.battleship.domain.Position;
import com.github.gossie.battleship.domain.Ship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
class BoardDTOMapper {

    private final PositionDTOMapper positionMapper;
    private final ShipDTOMapper shipMapper;

    BoardDTO map(Board board, String gameId) {

        FieldDTO[][] fields = new FieldDTO[board.height()][board.width()];
        for (int y = 0; y < fields.length; y++) {
            for (int x=0; x < fields[y].length; x++) {
                fields[y][x] = new FieldDTO(false, new PositionDTO(x, y));
            }
        }

        for (Ship ship : board.ships()) {
            for (int i = 0; i < ship.length(); i++) {
                Position position = ship.direction().getCoordinate(ship.start(), i);
                fields[position.y()][position.x()] = new FieldDTO(true, positionMapper.map(position));
            }
        }

        return new BoardDTO(gameId, fields, board.ships().stream().map(shipMapper::map).toList());
    }
}
