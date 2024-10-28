package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.PlayerPerformanceDto;

import java.util.List;

public interface PlayerPerformanceService {

    List<Boolean> predictPlayerPerformance(List<PlayerPerformanceDto> playerPerformanceDtos);

}
