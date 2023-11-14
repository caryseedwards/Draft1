package withgof.shapes.factories_unused;

import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.RecursiveShapeAlgorithmParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Shape;

public abstract class ShapeFactory {
    public abstract Shape createShape(RecursiveShapeAlgorithmParameters algoParams);
    public abstract Shape createShape(CirclePackingAlgorithmParameters algoParams);
    public abstract Shape createShape(SierpinskiShapeAlgorithmParameters algoParams);
}

