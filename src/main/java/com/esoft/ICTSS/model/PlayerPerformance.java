package com.esoft.ICTSS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "playerPerformance")
public class PlayerPerformance {

    @Id
    private Long id;

    private double average;
    private double strikeRate;
    private double bowlingAverage;
    private double economyRate;
    private int fieldingStats;
    private int label;  // 1 for good, 0 for bad
}
