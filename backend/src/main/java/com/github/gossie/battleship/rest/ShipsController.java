package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games/{gameId}/board/ships")
@RequiredArgsConstructor
public class ShipsController {

    private final GameService gameService;
    private final GameDTOMapper gameMapper;
    private final ShipDTOMapper shipMapper;

    @PostMapping
    public ResponseEntity<GameDTO> createShip(@PathVariable String gameId, @RequestBody ShipDTO ship) {
        try {
            return gameService.createShip(gameId, shipMapper.map(ship))
                    .map(gameMapper::map)
                    .map(game -> ResponseEntity.status(HttpStatus.CREATED).body(game))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
