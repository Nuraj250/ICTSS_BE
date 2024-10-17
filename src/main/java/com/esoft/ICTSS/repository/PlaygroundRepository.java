package com.esoft.ICTSS.repository;

import com.esoft.ICTSS.model.Playground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Playground entity.
 * Provides CRUD operations via JpaRepository.
 */
@Repository
public interface PlaygroundRepository extends JpaRepository<Playground, Long> {
}
