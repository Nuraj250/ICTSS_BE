package com.esoft.ICTSS.model;

import com.esoft.ICTSS.enums.GroundType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Playground entity that maps to the 'playgrounds' table in the database.
 * Stores details about each playground.
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "playgrounds")
public class Playground{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String location;
    private GroundType groundType;

    private double latitude;
    private double longitude;
    private double temperature;
    private double humidity;
}
