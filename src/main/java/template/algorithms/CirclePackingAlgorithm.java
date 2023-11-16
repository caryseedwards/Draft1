package template.algorithms;

import template.parameters.CanvasParameters;
import template.parameters.CirclePackingAlgorithmParameters;
import template.parameters.Parameters;
import template.parameters.ShapeParameters;
import template.shapes.Shape;
import template.shapes.*;

import java.awt.*;
import java.util.ArrayList;

public class CirclePackingAlgorithm extends Algorithm {
    private CirclePackingAlgorithmParameters params;
    private ShapeParameters boundaryParameters;
    private ShapeParameters circleParameters;
    private Shape boundaryShape;
    private ArrayList<Circle> circles;

    public CirclePackingAlgorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
        super(canvasParams, shapeParams, algorithmParams);
        initialiseAlgorithm();
    }



    @Override
    protected void initialiseAlgorithm() {
        this.params = (CirclePackingAlgorithmParameters) getAlgorithmParams();
        this.boundaryParameters = getShapeParameters().get(0);
        this.circleParameters = getShapeParameters().get(1);
        setBoundaryShape(getShapeParameters().get(0).getShapeType());
        this.circles = new ArrayList<>();
    }

    public Shape getBoundaryShape() {
        return boundaryShape;
    }

    public void setBoundaryShape(String type) {
        switch (type) {
            case "circle" ->
                    boundaryShape = new Circle(params.getCentreX(), params.getCentreY(), params.getPolygonSize());
            case "square" -> boundaryShape = new Square(params.centreX, params.centreY, params.polygonSize);
            case "triangle" -> boundaryShape = new Triangle(params.centreX, params.centreY, params.polygonSize);
            case "hexagon" -> boundaryShape = new Hexagon(params.centreX, params.centreY, params.polygonSize);
            default -> throw new IllegalArgumentException("Invalid boundary type: " + type);
        }
        boundaryParameters.setShapeType(type);
    }

    public void addCircles() {
        for (int i = 0; i < params.maxAttempts; i++) {
            Point randomPosition = boundaryShape.randomPositionInside();
            int randomRadius = params.minRadius + (int) (Math.random() * (params.maxRadius - params.minRadius));
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

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    @Override
    public void executeAlgorithm() {
        addCircles();
    }

    @Override
    public void drawPattern(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getCanvasParameters().getBackgroundColour());
        g2d.fillRect(0, 0, getCanvasParameters().getWidth(), getCanvasParameters().getHeight());

        boundaryShape.draw(g2d, boundaryParameters.getLineColour(), boundaryParameters.getLineWidth(), boundaryParameters.getFillColour(), "solid");
        for (Circle circle : circles) {
            circle.draw(g2d, circleParameters.getLineColour(), circleParameters.getLineWidth(), circleParameters.getFillColour(), "solid");
        }
        this.pattern = g2d;
    }

    public CirclePackingAlgorithmParameters getAlgorithmParameters() {
        return params;
    }
}
