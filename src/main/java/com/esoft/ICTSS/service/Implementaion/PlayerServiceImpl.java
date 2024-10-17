package com.esoft.ICTSS.service.Implementaion;

import com.esoft.ICTSS.dto.PlayerDto;
import com.esoft.ICTSS.exceptions.EntityNotFoundException;
import com.esoft.ICTSS.mapper.PlayerMapper;
import com.esoft.ICTSS.model.Player;
import com.esoft.ICTSS.repository.PlayerRepository;
import com.esoft.ICTSS.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the PlayerService interface.
 * Handles business logic and interacts with the PlayerRepository.
 */
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    /**
     * Creates a new player and saves it in the database.
     *
     * @param playerDto Data transfer object containing player details.
     * @return PlayerDto of the saved player.
     */
    @Override
    public PlayerDto addPlayer(PlayerDto playerDto) {
        Player player = playerMapper.toEntity(playerDto);
        Player savedPlayer = playerRepository.save(player);
        return playerMapper.toDto(savedPlayer);
    }

    /**
     * Updates an existing player's details.
     *
     * @param id        ID of the player to update.
     * @param playerDto New player data.
     * @return Updated PlayerDto.
     * @throws EntityNotFoundException if the player is not found.
     */
    @Override
    public PlayerDto updatePlayer(Long id, PlayerDto playerDto) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with ID: " + id));
        existingPlayer.setName(playerDto.getName());
        existingPlayer.setType(playerDto.getType());
        existingPlayer.setRuns(playerDto.getRuns());
        existingPlayer.setWickets(playerDto.getWickets());
        Player updatedPlayer = playerRepository.save(existingPlayer);
        return playerMapper.toDto(updatedPlayer);
    }

    /**
     * Deletes a player by ID.
     *
     * @param id ID of the player to delete.
     * @throws EntityNotFoundException if the player is not found.
     */
    @Override
    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with ID: " + id));
        playerRepository.delete(player);
    }

    /**
     * Retrieves a player by ID.
     *
     * @param id ID of the player to retrieve.
     * @return PlayerDto of the retrieved player.
     * @throws EntityNotFoundException if the player is not found.
     */
    @Override
    public PlayerDto getPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with ID: " + id));
        return playerMapper.toDto(player);
    }

    /**
     * Retrieves all players.
     * @return List of PlayerDto for all players.
     */
    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(playerMapper::toDto).collect(Collectors.toList());
    }
}
