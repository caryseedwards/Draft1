package withgof.shapes.factories_unused;

import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.RecursiveShapeAlgorithmParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Shape;
import withgof.shapes.Square;

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
