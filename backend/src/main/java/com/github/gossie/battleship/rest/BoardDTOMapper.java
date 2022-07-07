package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Board;
import com.github.gossie.battleship.domain.Point;
import com.github.gossie.battleship.domain.Ship;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BoardDTOMapper {
    public BoardDTO map(Board board) {

        FieldDTO[][] fields = new FieldDTO[board.height()][board.width()];
        for (FieldDTO[] field : fields) {
            Arrays.fill(field, new FieldDTO(false));
        }

        for (Ship ship : board.ships()) {
            for (int i = 0; i < ship.length(); i++) {
                Point point = ship.direction().getCoordinate(ship.start(), i);
                fields[point.y()][point.x()] = new FieldDTO(true);
            }
        }


        return new BoardDTO(fields);
    }
}
