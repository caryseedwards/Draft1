package strategyandfactory.shapes.factories_unused;

import strategyandfactory.parameters.CirclePackingAlgorithmParameters;
import strategyandfactory.parameters.RecursiveShapeAlgorithmParameters;
import strategyandfactory.parameters.SierpinskiShapeAlgorithmParameters;
import strategyandfactory.shapes.Shape;
import strategyandfactory.shapes.Square;

public class SquareFactory extends ShapeFactory {

    @Override
    public Shape createShape(RecursiveShapeAlgorithmParameters algoParams) {
        return new Square(algoParams.getCenterX(), algoParams.getCenterY(), algoParams.getInitialSize());
    }

    @Override
    public Shape createShape(CirclePackingAlgorithmParameters algoParams) {
        return new Square(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }

    @Override
    public Shape createShape(SierpinskiShapeAlgorithmParameters algoParams) {
        return new Square(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }
}
