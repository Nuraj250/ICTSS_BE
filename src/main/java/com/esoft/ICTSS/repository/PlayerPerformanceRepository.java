package com.esoft.ICTSS.repository;

import com.esoft.ICTSS.dto.PlayerInput;
import com.esoft.ICTSS.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerPerformanceRepository extends JpaRepository<PlayerInput, Long> {
}
