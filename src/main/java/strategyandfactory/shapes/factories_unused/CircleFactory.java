package strategyandfactory.shapes.factories_unused;

import strategyandfactory.parameters.CirclePackingAlgorithmParameters;
import strategyandfactory.parameters.RecursiveShapeAlgorithmParameters;
import strategyandfactory.parameters.SierpinskiShapeAlgorithmParameters;
import strategyandfactory.shapes.Circle;
import strategyandfactory.shapes.Shape;

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
