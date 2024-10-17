package com.esoft.ICTSS.dto;

import com.esoft.ICTSS.enums.GroundType;
import lombok.*;

import java.io.Serializable;

/**
 * Data Transfer Object for PlayGround.
 * Used to send/receive Player data in API calls.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class PlaygroundDto implements Serializable {

    private Long id;
    private String name;
    private String location;
    private GroundType groundType;
    private double latitude;
    private double longitude;
    private double temperature;
    private double humidity;
}
