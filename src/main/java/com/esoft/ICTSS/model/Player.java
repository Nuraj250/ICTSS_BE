package com.esoft.ICTSS.model;

import com.esoft.ICTSS.enums.PlayerType;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class for Player.
 * Represents the structure of the Player table in the database.
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlayerType type;

    @Column
    private int runs;

    @Column
    private int wickets;
}
