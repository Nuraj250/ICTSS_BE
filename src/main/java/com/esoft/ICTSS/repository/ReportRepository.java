package com.esoft.ICTSS.repository;

import com.esoft.ICTSS.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Report entity.
 * Provides default CRUD operations via JpaRepository.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
