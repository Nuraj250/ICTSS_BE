package com.esoft.ICTSS.controller;

import com.esoft.ICTSS.dto.TeamDto;
import com.esoft.ICTSS.service.TeamService;
import com.esoft.ICTSS.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Team-related operations.
 */
@RestController
@RequestMapping("/api/teams")
@Slf4j
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    /**
     * Adds a new team.
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addTeam(@RequestBody TeamDto teamDto) {
        TeamDto addedTeam = teamService.addTeam(teamDto);
        if (addedTeam != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(201, "Team added successfully.", addedTeam));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(400, "Failed to add team.", null));
    }

    /**
     * Updates an existing team.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> updateTeam(
            @PathVariable Long id, @RequestBody TeamDto teamDto) {
        try {
            teamService.updateTeam(id, teamDto);
            return ResponseEntity.ok(new ResponseMessage(200,"Team updated successfully.", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404,e.getMessage(), null));
        }
    }

    /**
     * Deletes a team.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteTeam(@PathVariable Long id) {
        try {
            teamService.deleteTeam(id);
            return ResponseEntity.ok(new ResponseMessage(200,"Team deleted successfully.", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404,e.getMessage(), null));
        }
    }

    /**
     * Retrieves a team by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getTeamById(@PathVariable Long id) {
        try {
            TeamDto teamDto = teamService.getTeamById(id);
            return ResponseEntity.ok(teamDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404,e.getMessage(), null));
        }
    }

    /**
     * Retrieves all teams.
     */
    @GetMapping("/all")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        List<TeamDto> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }
}
