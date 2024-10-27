package com.esoft.ICTSS.service;

import com.esoft.ICTSS.dto.PlayerInput;

import java.util.List;

public interface PlayerPerformanceService {

    List<Boolean> predictPlayerPerformance(List<PlayerInput> playerInputs);

}
