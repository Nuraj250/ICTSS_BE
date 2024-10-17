package com.esoft.ICTSS.mapper;

import com.esoft.ICTSS.dto.PlayerDto;
import com.esoft.ICTSS.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * PlayerMapper converts between Player entity and PlayerDto.
 * Ensures loose coupling between the layers.
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerMapper {

    /**
     * Converts PlayerDto to Player entity.
     */
    Player toEntity(PlayerDto dto);

    /**
     * Converts Player entity to PlayerDto.
     */
    PlayerDto toDto(Player player);
}
