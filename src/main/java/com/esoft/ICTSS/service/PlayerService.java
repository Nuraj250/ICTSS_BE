package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.PlayerDto;
import com.esoft.ICTSS.dto.PlayerInput;
import com.esoft.ICTSS.dto.ReportDto;

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

    // New method to generate player performance report
    List<ReportDto> generatePlayerPerformanceReport();
}
