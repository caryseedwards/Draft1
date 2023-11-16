package strategyandfactory.shapes.factories_unused;

import strategyandfactory.parameters.CirclePackingAlgorithmParameters;
import strategyandfactory.parameters.RecursiveShapeAlgorithmParameters;
import strategyandfactory.parameters.SierpinskiShapeAlgorithmParameters;
import strategyandfactory.shapes.Shape;

public abstract class ShapeFactory {
    public abstract Shape createShape(RecursiveShapeAlgorithmParameters algoParams);

    public abstract Shape createShape(CirclePackingAlgorithmParameters algoParams);

    public abstract Shape createShape(SierpinskiShapeAlgorithmParameters algoParams);
}

