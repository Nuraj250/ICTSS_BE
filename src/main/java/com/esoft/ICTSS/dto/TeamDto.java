package com.esoft.ICTSS.dto;

import com.esoft.ICTSS.enums.TeamType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for transferring Team data.
 * Includes ID, name, type, and a list of player IDs.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class TeamDto implements Serializable {
    private Long id;
    private String name;
    private TeamType type;
    private List<Long> playerIds;
}
