package com.esoft.ICTSS.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PlayerInput implements Serializable {
    private double average;
    private double strikeRate;
    private double bowlingAverage;
    private double economyRate;
    private int fieldingStats;
}
