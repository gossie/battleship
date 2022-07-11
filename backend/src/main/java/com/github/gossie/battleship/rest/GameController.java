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
    public ResponseEntity<GameDTO> createGame(@RequestBody String playerName) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(gameMapper.map(gameService.createGame(playerName)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GameDTO> loadGame(@PathVariable String id, @RequestBody String playerName) {
        return ResponseEntity.of(gameService.addPlayer(id, playerName).map(gameMapper::map));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getGame(@PathVariable String id) {
        return ResponseEntity.of(gameService.findGame(id).map(gameMapper::map));
    }

}
