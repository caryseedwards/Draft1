package template.algorithms;

import template.parameters.CanvasParameters;
import template.parameters.Parameters;
import template.parameters.RecursiveShapeAlgorithmParameters;
import template.parameters.ShapeParameters;
import template.shapes.Shape;
import template.shapes.*;

import java.awt.*;
import java.util.ArrayList;

public class RecursiveShapeAlgorithm extends Algorithm {
    private final ArrayList<Shape> shapesToDraw = new ArrayList<>();
    private RecursiveShapeAlgorithmParameters params;
    private ShapeParameters largeShapeParams;
    private ShapeParameters smallShapeParams;

    public RecursiveShapeAlgorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
        super(canvasParams, shapeParams, algorithmParams);
        initialiseAlgorithm();
    }

    @Override
    protected void initialiseAlgorithm() {
        this.params = (RecursiveShapeAlgorithmParameters) getAlgorithmParams();
        this.largeShapeParams = getShapeParameters().get(0);
        this.smallShapeParams = getShapeParameters().get(1);
    }

    @Override
    public void executeAlgorithm() {
        addPattern(params.getCenterX(), params.getCenterY(), params.getInitialSize(), params.getDepth());
    }

    public Shape createShape(String shapeType, int x, int y, int size) {
        return switch (shapeType) {
            case "circle" -> new Circle(x, y, size);
            case "square" -> new Square(x, y, size);
            case "triangle" -> new Triangle(x, y, size);
            case "hexagon" -> new Hexagon(x, y, size);
            default -> throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        };
    }

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

    public ArrayList<Shape> getShapesToDraw() {
        return shapesToDraw;
    }

    public RecursiveShapeAlgorithmParameters getParams() {
        return params;
    }

    public ShapeParameters getLargeShapeParams() {
        return largeShapeParams;
    }

    public ShapeParameters getSmallShapeParams() {
        return smallShapeParams;
    }
}
