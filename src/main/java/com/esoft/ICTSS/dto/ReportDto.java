package com.esoft.ICTSS.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for transferring Report data between layers.
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto implements Serializable {
    private Long playerId;
    private String playerName;
    private int totalRuns;
    private int totalWickets;
    private double strikeRate;
    private double averageRuns;
}
