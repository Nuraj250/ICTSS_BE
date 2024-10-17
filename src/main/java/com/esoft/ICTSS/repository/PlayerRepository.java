package com.esoft.ICTSS.repository;

import com.esoft.ICTSS.enums.PlayerType;
import com.esoft.ICTSS.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Player entity to handle database operations.
 * Extends JpaRepository to provide default CRUD operations.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    /**
     * Find players by type.
     * @param type - the type of player (BATTER, BOWLER, etc.)
     * @return List of players matching the type.
     */
    List<Player> findByType(PlayerType type);
}
