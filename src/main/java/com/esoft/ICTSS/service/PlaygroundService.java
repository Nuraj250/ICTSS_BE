package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.PlaygroundDto;

import java.util.List;

/**
 * Service interface for Playground business logic.
 */
public interface PlaygroundService {

    PlaygroundDto addPlayground(PlaygroundDto playgroundDto);

    PlaygroundDto updatePlayground(Long id, PlaygroundDto playgroundDto);

    void deletePlayground(Long id);

    PlaygroundDto getPlaygroundById(Long id);

    List<PlaygroundDto> getAllPlaygrounds();

}
