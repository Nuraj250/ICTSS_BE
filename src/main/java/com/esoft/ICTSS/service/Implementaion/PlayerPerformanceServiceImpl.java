package com.esoft.ICTSS.service.Implementaion;

import com.esoft.ICTSS.dto.PlayerPerformanceDto;
import com.esoft.ICTSS.repository.PlayerPerformanceRepository;
import com.esoft.ICTSS.service.PlayerPerformanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class PlayerPerformanceServiceImpl implements PlayerPerformanceService {

    private final PlayerPerformanceRepository repository;

    /**
     * Predicts if multiple players are good or bad for the team.
     */
    @Override
    public List<Boolean> predictPlayerPerformance(List<PlayerPerformanceDto> playerPerformanceDtos) {
        try (SavedModelBundle model = SavedModelBundle.load("src/main/resources/player_model.h5")) {
            return playerPerformanceDtos.stream()
                    .map(dto -> predictSinglePlayer(dto, model))
                    .collect(Collectors.toList());
        }
    }

    /**
     * Predicts the performance of a single player using the TensorFlow model.
     */
    private boolean predictSinglePlayer(PlayerPerformanceDto dto, SavedModelBundle model) {
        try (Tensor<?> inputTensor = createInputTensor(dto)) {
            Tensor<?> result = model.session().runner()
                    .feed("serving_default_dense_input", inputTensor)
                    .fetch("StatefulPartitionedCall")
                    .run().get(0);

            float[][] prediction = new float[1][1];
            result.copyTo(prediction);
            return prediction[0][0] >= 0.5;
        }
    }

    /**
     * Creates a TensorFlow input tensor from player data.
     */
    private Tensor<?> createInputTensor(PlayerPerformanceDto playerPerformanceDto) {
        float[][] data = new float[1][5];
        data[0][0] = (float) playerPerformanceDto.getAverage();
        data[0][1] = (float) playerPerformanceDto.getStrikeRate();
        data[0][2] = (float) playerPerformanceDto.getBowlingAverage();
        data[0][3] = (float) playerPerformanceDto.getEconomyRate();
        data[0][4] = playerPerformanceDto.getFieldingStats();
        return Tensor.create(data);

    }
}
