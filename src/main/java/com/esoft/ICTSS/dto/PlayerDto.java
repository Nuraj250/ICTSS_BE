package com.esoft.ICTSS.dto;

import com.esoft.ICTSS.enums.PlayerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Data Transfer Object for Player.
 * Used to send/receive Player data in API calls.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class PlayerDto implements Serializable {
    private Long id;
    private String name;
    private PlayerType type;
    private int runs;
    private int wickets;
}
