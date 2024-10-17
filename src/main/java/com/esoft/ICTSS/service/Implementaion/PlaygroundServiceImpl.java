package com.esoft.ICTSS.service.Implementaion;

import com.esoft.ICTSS.dto.PlaygroundDto;
import com.esoft.ICTSS.mapper.PlaygroundMapper;
import com.esoft.ICTSS.model.Playground;
import com.esoft.ICTSS.repository.PlaygroundRepository;
import com.esoft.ICTSS.service.PlaygroundService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of PlaygroundService interface.
 * Handles business logic for Playgrounds.
 */
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class PlaygroundServiceImpl implements PlaygroundService {

    private final PlaygroundRepository playgroundRepository;
    private final PlaygroundMapper playgroundMapper;

    /**
     * Adds a new playground.
     * @param playgroundDto
     * @return
     */
    @Override
    public PlaygroundDto addPlayground(PlaygroundDto playgroundDto) {
        Playground playground = playgroundMapper.toEntity(playgroundDto);
        Playground savedPlayground = playgroundRepository.save(playground);
        return playgroundMapper.toDto(savedPlayground);
    }

    /**
     * Updates an existing playground.
     * @param id
     * @param playgroundDto
     * @return
     */
    @Override
    public PlaygroundDto updatePlayground(Long id, PlaygroundDto playgroundDto) {
        Optional<Playground> existingPlayground = playgroundRepository.findById(id);
        if (existingPlayground.isPresent()) {
            Playground playground = playgroundMapper.toEntity(playgroundDto);
            playground.setId(id);
            Playground updatedPlayground = playgroundRepository.save(playground);
            return playgroundMapper.toDto(updatedPlayground);
        } else {
            throw new RuntimeException("Playground not found with id: " + id);
        }
    }

    /**
     * Deletes a playground by ID.
     * @param id
     */
    @Override
    public void deletePlayground(Long id) {
        playgroundRepository.deleteById(id);
    }

    /**
     * Retrieves a playground by ID.
     * @param id
     * @return
     */
    @Override
    public PlaygroundDto getPlaygroundById(Long id) {
        Playground playground = playgroundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playground not found with id: " + id));
        return playgroundMapper.toDto(playground);
    }

    /**
     * Retrieves all playgrounds.
     * @return
     */
    @Override
    public List<PlaygroundDto> getAllPlaygrounds() {
        List<Playground> playgrounds = playgroundRepository.findAll();
        return playgrounds.stream()
                .map(playgroundMapper::toDto)
                .collect(Collectors.toList());
    }
}
