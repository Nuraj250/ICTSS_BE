package com.esoft.ICTSS.repository;

import com.esoft.ICTSS.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Team entity.
 * Extends JpaRepository for CRUD operations.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
