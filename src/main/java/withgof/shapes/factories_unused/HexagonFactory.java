package withgof.shapes.factories_unused;

import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.RecursiveShapeAlgorithmParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Hexagon;
import withgof.shapes.Shape;

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
