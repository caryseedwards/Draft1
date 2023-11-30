package version1.algorithms;

import version1.parameters.CanvasParameters;
import version1.parameters.CirclePackingAlgorithmParameters;
import version1.parameters.Parameters;
import version1.parameters.ShapeParameters;
import version1.shapes.Shape;
import version1.shapes.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * The implementation of the Circle Packing algorithm
 * Will fill a specified shapes with circles as an animation
 * @author carysedwards
 */
public class CirclePackingAlgorithm extends Algorithm {
    private CirclePackingAlgorithmParameters params;
    private ShapeParameters boundaryParameters;
    private ShapeParameters circleParameters;
    private Shape boundaryShape;
    private ArrayList<Circle> circles;

    /**
     * Constructor to create the circle packing algorithm
     * @param canvasParams - details of the canvas to draw upon
     * @param shapeParams - details of the shapes used within the algorithm
     * @param algorithmParams - details of the algorithm
     */
    public CirclePackingAlgorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
        super(canvasParams, shapeParams, algorithmParams);
        initialiseAlgorithm();
    }

    /**
     * Sets up the algorithm with default values
     */
    @Override
    protected void initialiseAlgorithm() {
        this.params = (CirclePackingAlgorithmParameters) getAlgorithmParams();
        this.boundaryParameters = getShapeParameters().get(0);
        this.circleParameters = getShapeParameters().get(1);
        setBoundaryShape(getShapeParameters().get(0).getShapeType());
        this.circles = new ArrayList<>();
    }

    /**
     * Gets the boundary shape for the algorithm to fill with circles
     * @return boundaryShape
     */
    public Shape getBoundaryShape() {
        return boundaryShape;
    }

    /**
     * Sets the boundary shape to fill with circles
     * @param type The type of shape, Circle, Square, Hexagon, Triangle
     */
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

    /**
     * The implementation of the logic of the algorithm
     * Will fill a bounded shapes with circles
     */
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

    /**
     * Gets the circles creates to be drawn onto the canvas for the algorithm
     * @return circles
     */
    public ArrayList<Circle> getCircles() {
        return circles;
    }

    /**
     * Executes the algorithm based on the parameters already passed
     */
    @Override
    public void executeAlgorithm() {
        addCircles();
    }

    /**
     * Draws the algorithm to the graphics object based on the parameters already passed
     * @param g - The graphics object to draw to
     */
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

    /**
     * Gets the algorithm parameters specified for the algorithm
     * @return algorithmParameters
     */
    public CirclePackingAlgorithmParameters getAlgorithmParameters() {
        return params;
    }
}
