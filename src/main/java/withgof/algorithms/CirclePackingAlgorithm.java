package withgof.algorithms;

import withgof.parameters.CanvasParameters;
import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.ShapeParameters;
import withgof.shapes.Circle;
import withgof.shapes.Shape;
import withgof.shapes.ShapeFactory;

import java.awt.*;
import java.util.ArrayList;

public class CirclePackingAlgorithm implements AlgorithmStrategy {
    private final ShapeFactory shapeFactory;
    private final CanvasParameters canvasParameters;
    private final ShapeParameters boundaryParameters;
    private final ShapeParameters circleParameters;
    private final CirclePackingAlgorithmParameters algorithmParameters;
    private final ArrayList<Circle> circles = new ArrayList<>();
    private Shape boundaryShape;

    public CirclePackingAlgorithm(CanvasParameters canvasParameters, ArrayList<ShapeParameters> shapeParameters, CirclePackingAlgorithmParameters algorithmParameters) {
        this.canvasParameters = canvasParameters;
        this.boundaryParameters = shapeParameters.get(0);
        this.circleParameters = shapeParameters.get(1);
        this.algorithmParameters = algorithmParameters;
        shapeFactory = new ShapeFactory();
        setBoundaryShape(boundaryParameters.getShapeType());
    }

    @Override
    public boolean validateParameters() {
        return canvasParameters.validateParameters() && boundaryParameters.validateParameters() && circleParameters.validateParameters() && algorithmParameters.validateParameters();
    }

    @Override
    public void executeAlgorithm() {
        if (validateParameters()) {
            addCircles();
        }
    }

    @Override
    public void drawPattern(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(canvasParameters.getBackgroundColour());
        g2d.fillRect(0, 0, canvasParameters.getWidth(), canvasParameters.getHeight());

        boundaryShape.draw(g2d, boundaryParameters.getLineColour(), boundaryParameters.getLineWidth(), boundaryParameters.getFillColour(), "solid");
        for (Circle circle : circles) {
            circle.draw(g2d, circleParameters.getLineColour(), circleParameters.getLineWidth(), circleParameters.getFillColour(), "solid");
        }
    }

    public void addCircles() {
        for (int i = 0; i < algorithmParameters.maxAttempts; i++) {
            Point randomPosition = boundaryShape.randomPositionInside();
            int randomRadius = algorithmParameters.minRadius + (int) (Math.random() * (algorithmParameters.maxRadius - algorithmParameters.minRadius));
            Circle newCircle = new Circle(randomPosition.x, randomPosition.y, randomRadius);

            boolean overlaps = circles.stream().anyMatch(newCircle::overlaps);
            if (!overlaps) {
                boolean isInside = boundaryShape.isInside(newCircle);
                if (isInside) {
                    circles.add(newCircle);
                }
            }
        }
    }

    public CirclePackingAlgorithmParameters getAlgorithmParameters() {
        return this.algorithmParameters;
    }

    public Shape getBoundaryShape() {
        return boundaryShape;
    }

    public void setBoundaryShape(String type) {
        boundaryParameters.setShapeType(type);
        boundaryShape = shapeFactory.createShape(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize(), boundaryParameters);
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }
}
