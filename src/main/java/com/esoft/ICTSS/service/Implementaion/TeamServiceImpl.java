package com.esoft.ICTSS.service.Implementaion;

import com.esoft.ICTSS.dto.TeamDto;
import com.esoft.ICTSS.mapper.TeamMapper;
import com.esoft.ICTSS.model.Player;
import com.esoft.ICTSS.model.Team;
import com.esoft.ICTSS.repository.PlayerRepository;
import com.esoft.ICTSS.repository.TeamRepository;
import com.esoft.ICTSS.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of TeamService interface.
 */
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final TeamMapper teamMapper;

    /**
     * Adds a new team.
     *
     * @param teamDto
     * @return
     */
    @Override
    public TeamDto addTeam(TeamDto teamDto) {
        List<Player> players = playerRepository.findAllById(teamDto.getPlayerIds());
        Team team = teamMapper.toEntity(teamDto, players);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDto(savedTeam);
    }

    /**
     * Updates an existing team.
     *
     * @param id
     * @param teamDto
     * @return
     */
    @Override
    public TeamDto updateTeam(Long id, TeamDto teamDto) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            List<Player> players = playerRepository.findAllById(teamDto.getPlayerIds());
            Team team = teamMapper.toEntity(teamDto, players);
            team.setId(id);
            Team updatedTeam = teamRepository.save(team);
            return teamMapper.toDto(updatedTeam);
        } else {
            throw new RuntimeException("Team not found with id: " + id);
        }
    }

    /**
     * Deletes a team by ID.
     *
     * @param id
     */
    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    /**
     * Retrieves a team by ID.
     *
     * @param id
     * @return
     */
    @Override
    public TeamDto getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));
        return teamMapper.toDto(team);
    }

    /**
     * Retrieves all teams.
     * @return
     */
    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(teamMapper::toDto).collect(Collectors.toList());
    }
}
