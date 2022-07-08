package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final GameDTOMapper gameMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameDTO createGame() {
        return gameMapper.map(gameService.createGame());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getGame(@PathVariable String id) {
        return ResponseEntity.of(gameService.findGame(id).map(gameMapper::map));
    }

}
