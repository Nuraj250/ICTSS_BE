package com.esoft.ICTSS.mapper;

import com.esoft.ICTSS.dto.PlaygroundDto;
import com.esoft.ICTSS.model.Playground;
import org.mapstruct.*;

/**
 * Mapper class to convert between Team entity and TeamDto.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaygroundMapper {

    /**
     * Converts PlaygroundDto to Playground entity.
     */
    Playground toEntity(PlaygroundDto dto);

    /**
     * Converts Playground entity to PlaygroundDto.
     */
    PlaygroundDto toDto(Playground entity);
}
