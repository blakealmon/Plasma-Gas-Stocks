package com.tailworks.ml.neuralnet.optimizer;

import com.tailworks.ml.neuralnet.math.Matrix;
import com.tailworks.ml.neuralnet.math.Vec;

/**
 * Updates Weights and biases based on a constant learning rate - i.e. W -= η * dC/dW
 */
public record GradientDescent(double learningRate) implements Optimizer {

    @Override
    public void updateWeights(Matrix weights, Matrix dCdW) {
        weights.sub(dCdW.mul(learningRate));
    }

    @Override
    public Vec updateBias(Vec bias, Vec dCdB) {
        return bias.sub(dCdB.mul(learningRate));
    }

    @Override
    public Optimizer copy() {
        // no need to make copies since this optimizer has
        // no state. Same instance can serve all layers.
        return this;
    }
}
