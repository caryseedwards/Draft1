package version1.algorithms;

import version1.parameters.CanvasParameters;
import version1.parameters.Parameters;
import version1.parameters.RecursiveShapeAlgorithmParameters;
import version1.parameters.ShapeParameters;
import version1.shapes.Shape;
import version1.shapes.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * The implementation of the Recursive Shape algorithm
 * Will recursively draw two shapes in a Euclidean pattern
 * @author carysedwards
 */
public class RecursiveShapeAlgorithm extends Algorithm {
    private final ArrayList<Shape> shapesToDraw = new ArrayList<>();
    private RecursiveShapeAlgorithmParameters params;
    private ShapeParameters largeShapeParams;
    private ShapeParameters smallShapeParams;

    /**
     * Constructor to create the recursive shape algorithm
     * @param canvasParams - details of the canvas to draw upon
     * @param shapeParams - details of the shapes used within the algorithm
     * @param algorithmParams - details of the algorithm
     */
    public RecursiveShapeAlgorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
        super(canvasParams, shapeParams, algorithmParams);
        initialiseAlgorithm();
    }

    /**
     * Initializes the algorithm with default values
     */
    @Override
    protected void initialiseAlgorithm() {
        this.params = (RecursiveShapeAlgorithmParameters) getAlgorithmParams();
        this.largeShapeParams = getShapeParameters().get(0);
        this.smallShapeParams = getShapeParameters().get(1);
    }

    /**
     * Executes the algorithm based on the parameters already passed
     */
    @Override
    public void executeAlgorithm() {
        addPattern(params.getCenterX(), params.getCenterY(), params.getInitialSize(), params.getDepth());
    }

    /**
     * Creates a shape to draw as part of the algorithm
     * @param shapeType - Circle, Triangle, Square, Hexagon
     * @param x - the x co-ordinate
     * @param y - the y co-ordinate
     * @param size - the size of the shape
     * @return Shape - the new shape to draw
     */
    public Shape createShape(String shapeType, int x, int y, int size) {
        return switch (shapeType) {
            case "circle" -> new Circle(x, y, size);
            case "square" -> new Square(x, y, size);
            case "triangle" -> new Triangle(x, y, size);
            case "hexagon" -> new Hexagon(x, y, size);
            default -> throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        };
    }

    /**
     * The business logic for the recursive algorithm
     * @param x - the starting x co-ordinate for the shape
     * @param y - the starting y co-ordinate for the shape
     * @param size - the size of the shape to draw
     * @param depth - the recursive depth of how many shapes to draw
     */
    public void addPattern(int x, int y, int size, int depth) {
        if (depth == 0) return;

        Shape newLargeShape = createShape(largeShapeParams.getShapeType(), x, y, size);
        newLargeShape.setShapeParameters(largeShapeParams);
        shapesToDraw.add(newLargeShape);

        int numShapes = params.getNumShapes();
        double angleStep = Math.PI * 2 / numShapes;
        int smallerSize = (int) (size * Math.sin(angleStep / 2));

        for (int i = 0; i < numShapes; i++) {
            double angle = i * angleStep;
            int newX = (int) (x + size * Math.cos(angle));
            int newY = (int) (y + size * Math.sin(angle));

            Shape newSmallShape = createShape(smallShapeParams.getShapeType(), newX, newY, smallerSize);
            newSmallShape.setShapeParameters(smallShapeParams);
            shapesToDraw.add(newSmallShape);
            addPattern(newX, newY, smallerSize, depth - 1);
        }
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
        for (Shape shape : shapesToDraw) {
            shape.draw(g2d, shape.getShapeParameters().getLineColour(), shape.getShapeParameters().getLineWidth(),
                    shape.getShapeParameters().getFillColour(), "solid");
        }
    }

    /**
     * Gets the shapes already calculated to draw to the canvas
     * @return shapesToDraw
     */
    public ArrayList<Shape> getShapesToDraw() {
        return shapesToDraw;
    }

    /**
     * Gets the algorithm parameters
     * @return params
     */
    public RecursiveShapeAlgorithmParameters getParams() {
        return params;
    }

    /**
     * Gets the large shape parameters selected for this algorithm
     * @return largeShapeParameters
     */
    public ShapeParameters getLargeShapeParams() {
        return largeShapeParams;
    }

    /**
     * Gets the small shape parameters selected for this algorithm
     * @return smallShapeParameters
     */
    public ShapeParameters getSmallShapeParams() {
        return smallShapeParams;
    }
}
