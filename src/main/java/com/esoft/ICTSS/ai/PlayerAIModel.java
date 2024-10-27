package com.esoft.ICTSS.ai;


import com.esoft.ICTSS.dto.PlayerInput;
import org.springframework.stereotype.Component;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to load and use the TensorFlow model for predictions.
 */
@Component
public class PlayerAIModel {

    private final SavedModelBundle model;

    public PlayerAIModel() {
        // Load the saved TensorFlow model
        this.model = SavedModelBundle.load("src/main/resources/player_model");
    }

    /**
     * Predicts whether a player is good or bad for the team.
     */
    public List<Boolean> predictPlayers(List<PlayerInput> players) {
        return players.stream().map(this::predictPlayer).collect(Collectors.toList());
    }

    /**
     * Predicts if a single player is good or bad.
     */
    private boolean predictPlayer(PlayerInput player) {
        try (Tensor<?> inputTensor = createInputTensor(player)) {
            Tensor<?> result = model.session().runner().feed("serving_default_dense_input", inputTensor)
                    .fetch("StatefulPartitionedCall").run().get(0);

            float[][] prediction = new float[1][1];
            result.copyTo(prediction);
            return prediction[0][0] >= 0.5;
        }
    }

    /**
     * Creates a TensorFlow tensor from player input data.
     */
    private Tensor<?> createInputTensor(PlayerInput player) {
        float[][] data = new float[1][5];
        data[0][0] = (float) player.getAverage();
        data[0][1] = (float) player.getStrikeRate();
        data[0][2] = (float) player.getBowlingAverage();
        data[0][3] = (float) player.getEconomyRate();
        data[0][4] = player.getFieldingStats();
        return Tensor.create(data);
    }
}
