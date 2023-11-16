package strategyandfactory.shapes.factories_unused;

import strategyandfactory.parameters.CirclePackingAlgorithmParameters;
import strategyandfactory.parameters.RecursiveShapeAlgorithmParameters;
import strategyandfactory.parameters.SierpinskiShapeAlgorithmParameters;
import strategyandfactory.shapes.Hexagon;
import strategyandfactory.shapes.Shape;

public class HexagonFactory extends ShapeFactory {

    @Override
    public Shape createShape(RecursiveShapeAlgorithmParameters algoParams) {
        return new Hexagon(algoParams.getCenterX(), algoParams.getCenterY(), algoParams.getInitialSize());
    }

    @Override
    public Shape createShape(CirclePackingAlgorithmParameters algoParams) {
        return new Hexagon(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }

    @Override
    public Shape createShape(SierpinskiShapeAlgorithmParameters algoParams) {
        return new Hexagon(algoParams.getCentreX(), algoParams.getCentreY(), algoParams.getPolygonSize());
    }
}
