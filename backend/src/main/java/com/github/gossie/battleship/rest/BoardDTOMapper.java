package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Board;
import com.mongodb.client.model.Field;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BoardDTOMapper {
    public BoardDTO map(Board board) {

        FieldDTO[][] fields = new FieldDTO[board.height()][board.width()];
        for (FieldDTO[] field : fields) {
            Arrays.fill(field, new FieldDTO());
        }


        return new BoardDTO(fields);
    }
}
