package com.github.gossie.battleship.rest;

import com.github.gossie.battleship.domain.Player;
import org.springframework.stereotype.Component;

@Component
class PlayerDTOMapper {
    
    PlayerDTO map(Player player) {
        return new PlayerDTO(player.name());
    }
    
}
