package com.esoft.ICTSS.model;

import com.esoft.ICTSS.enums.TeamType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Team entity that maps to the 'teams' table in the database.
 * Stores team details like name, type, and associated players.
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
public class Team{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private TeamType type;

    @ManyToMany
    @JoinTable(
            name = "team_players",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;

}
