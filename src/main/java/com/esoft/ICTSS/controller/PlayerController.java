package com.esoft.ICTSS.controller;

import com.esoft.ICTSS.dto.PlayerDto;
import com.esoft.ICTSS.dto.PlayerInput;
import com.esoft.ICTSS.dto.ReportDto;
import com.esoft.ICTSS.service.PlayerPerformanceService;
import com.esoft.ICTSS.service.PlayerService;
import com.esoft.ICTSS.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Player-related operations.
 * Handles HTTP requests and maps them to PlayerService methods.
 */
@RestController
@RequestMapping("/api/players")
@Slf4j
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerPerformanceService playerPerformanceService;



    /**
     * Adds a new player.
     */
    @PostMapping
    public ResponseEntity<?> addPlayer(@RequestBody PlayerDto playerDto) {
        PlayerDto addedPlayer = playerService.addPlayer(playerDto);
        if (addedPlayer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(201, "Player added successfully.", addedPlayer));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(400, "Failed to add player.", null));
    }

    /**
     * Updates an existing player.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        try {
            PlayerDto updatedPlayer = playerService.updatePlayer(id, playerDto);
            return ResponseEntity.ok(new ResponseMessage(200, "Player updated successfully.", updatedPlayer));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404, e.getMessage(), null));
        }
    }

    /**
     * Deletes a player by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.ok(new ResponseMessage(200, "Player deleted successfully.", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(400, e.getMessage(), null));
        }
    }

    /**
     * Retrieves a player by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long id) {
        try {
            PlayerDto playerDto = playerService.getPlayerById(id);
            return ResponseEntity.ok(playerDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(400, e.getMessage(), null));
        }
    }

    /**
     * Retrieves all players.
     */
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);    }

    /**
     * Endpoint to generate and return player performance report.
     */
    @GetMapping("/report")
    public ResponseEntity<List<ReportDto>> generatePlayerPerformanceReport() {
        List<ReportDto> report = playerService.generatePlayerPerformanceReport();
        return ResponseEntity.ok(report);
    }

    /**
     * Predicts performance for multiple players in a single request.
     */
    @PostMapping("/predict")
    public List<Boolean> predictPerformance(@RequestBody List<PlayerInput> playerInputs) {
        return playerPerformanceService.predictPlayerPerformance(playerInputs);
    }
}
