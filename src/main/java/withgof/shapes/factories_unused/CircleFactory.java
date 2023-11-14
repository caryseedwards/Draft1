package withgof.shapes.factories_unused;

import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.RecursiveShapeAlgorithmParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Circle;
import withgof.shapes.Shape;

public class CircleFactory extends ShapeFactory {

    @Override
    public Shape createShape(RecursiveShapeAlgorithmParameters algoParams) {
        return new Circle(algoParams.getCenterX(), algoParams.getCenterY(), algoParams.getInitialSize());
    }

    @Override
    public Shape createShape(CirclePackingAlgorithmParameters algoParams) {
        return new Circle(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }

    @Override
    public Shape createShape(SierpinskiShapeAlgorithmParameters algoParams) {
        return new Circle(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }
}
