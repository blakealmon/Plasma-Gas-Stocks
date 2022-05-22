package com.tailworks.ml.neuralnet.optimizer;

import com.tailworks.ml.neuralnet.math.Matrix;
import com.tailworks.ml.neuralnet.math.Vec;

public interface Optimizer {

    void updateWeights(Matrix weights, Matrix dCdW);

    Vec updateBias(Vec bias, Vec dCdB);

    Optimizer copy();

}
