package algorithms;

import parameters.RecursiveShapeParameters;
import shapes.*;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecursiveShape extends JPanel {
    private RecursiveShapeParameters params;
    private Shape largeShape;
    private Shape smallShape;
    private final ArrayList<Shape> shapesToDraw = new ArrayList<>();

    public RecursiveShape(RecursiveShapeParameters params) {
        this.params = params;
        initialiseShapes();
        addPattern(params.centerX, params.centerY, params.initialSize, params.depth);
    }

    public void addPattern(int x, int y, int size, int depth) {
        if (depth == 0) return;

        Shape newLargeShape = createShape(params.largeShapeType, x, y, size);
        shapesToDraw.add(newLargeShape);

        int numShapes = params.numShapes;
        double angleStep = Math.PI * 2 / numShapes;
        int smallerSize = (int) (size * Math.sin(angleStep / 2));

        for (int i = 0; i < numShapes; i++) {
            double angle = i * angleStep;
            int newX = (int) (x + size * Math.cos(angle));
            int newY = (int) (y + size * Math.sin(angle));

            Shape newSmallShape = createShape(params.smallShapeType, newX, newY, smallerSize);
            shapesToDraw.add(newSmallShape);

            addPattern(newX, newY, smallerSize, depth - 1);
        }
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(params.backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for (Shape shape : shapesToDraw) {
            shape.draw(g2d, params.largeShapeLineColor, params.largeShapeLineWidth,
                    params.largeShapeFillColor, params.largeShapeLineType);
        }
    }

    private void initialiseShapes(){
        switch (params.largeShapeType) {
            case "circle" -> largeShape = new Circle(params.centerX, params.centerY, params.initialSize);
            case "square" -> largeShape = new Square(params.centerX, params.centerY, params.initialSize);
            case "triangle" -> largeShape = new Triangle(params.centerX, params.centerY, params.initialSize);
            case "hexagon" -> largeShape = new Hexagon(params.centerX, params.centerY, params.initialSize);
        }

        switch (params.smallShapeType) {
            case "circle" -> smallShape = new Circle(params.centerX, params.centerY, params.initialSize);
            case "square" -> smallShape = new Square(params.centerX, params.centerY, params.initialSize);
            case "triangle" -> smallShape = new Triangle(params.centerX, params.centerY, params.initialSize);
            case "hexagon" -> smallShape = new Hexagon(params.centerX, params.centerY, params.initialSize);
        }
    }

    public RecursiveShapeParameters getParams() {
        return params;
    }

    public Shape getLargeShape() {
        return largeShape;
    }

    public Shape getSmallShape() {
        return smallShape;
    }

    public ArrayList<Shape> getShapesToDraw() {
        return shapesToDraw;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Pattern");

        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape pattern = new RecursiveShape(params);
        frame.add(pattern);
        frame.setSize(params.canvasSizeX, params.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

