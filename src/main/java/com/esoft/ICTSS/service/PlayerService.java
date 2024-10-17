package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.PlayerDto;

import java.util.List;

/**
 * Service interface for Player business logic.
 * Defines methods to be implemented in PlayerServiceImpl.
 */
public interface PlayerService {

    PlayerDto addPlayer(PlayerDto playerDto);
    PlayerDto updatePlayer(Long id, PlayerDto playerDto);
    void deletePlayer(Long id);
    PlayerDto getPlayerById(Long id);
    List<PlayerDto> getAllPlayers();
}
