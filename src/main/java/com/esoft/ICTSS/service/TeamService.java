package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.TeamDto;

import java.util.List;

/**
 * Service interface for Team business logic.
 */
public interface TeamService {

    TeamDto addTeam(TeamDto teamDto);
    TeamDto updateTeam(Long id, TeamDto teamDto);
    void deleteTeam(Long id);
    TeamDto getTeamById(Long id);
    List<TeamDto> getAllTeams();
}
