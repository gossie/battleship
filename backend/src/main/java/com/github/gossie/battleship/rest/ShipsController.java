package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.GameService;
import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.of(gameService.createShip(gameId, shipMapper.map(ship)).map(gameMapper::map));
    }

}
