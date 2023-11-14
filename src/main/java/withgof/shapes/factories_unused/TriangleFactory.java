package withgof.shapes.factories_unused;

import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.RecursiveShapeAlgorithmParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Shape;
import withgof.shapes.Triangle;

public class TriangleFactory extends ShapeFactory {

    @Override
    public Shape createShape(RecursiveShapeAlgorithmParameters algoParams) {
        return new Triangle(algoParams.getCenterX(), algoParams.getCenterY(), algoParams.getInitialSize());
    }

    @Override
    public Shape createShape(CirclePackingAlgorithmParameters algoParams) {
        return new Triangle(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }

    @Override
    public Shape createShape(SierpinskiShapeAlgorithmParameters algoParams) {
        return new Triangle(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }
}
