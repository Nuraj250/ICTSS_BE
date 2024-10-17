package com.esoft.ICTSS.mapper;

import com.esoft.ICTSS.dto.TeamDto;
import com.esoft.ICTSS.model.Player;
import com.esoft.ICTSS.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Mapper class to convert between Team entity and TeamDto.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    /**
     * Converts TeamDto to Team entity.
     */
    Team toEntity(TeamDto dto, List<Player> players);

    /**
     * Converts Team entity to TeamDto.
     */
    TeamDto toDto(Team team);
}
