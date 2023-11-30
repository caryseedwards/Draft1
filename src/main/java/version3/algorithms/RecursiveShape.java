package version3.algorithms;

import version3.parameters.RecursiveShapeParameters;
import version3.shapes.*;

import javax.swing.*;
import java.awt.*;

/**
 * The implementation of the Recursive Shape algorithm
 * Will recursively draw two shapes in a Euclidean pattern
 * @author carysedwards
 */
public class RecursiveShape extends JPanel {
    private final RecursiveShapeParameters params;
    private PatternShape largeShape;
    private PatternShape smallShape;

    /**
     * Constructor for the recursive shape algorithm
     * @param params - the parameters
     */
    public RecursiveShape(RecursiveShapeParameters params) {
        this.params = params;
        initialiseShapes();
    }

    /**
     * Creates a shape to draw as part of the algorithm
     * @param g2d - The graphics object to draw
     * @param x - the start x co-ordinate
     * @param y - the start y co-ordinate
     * @param size - the size of the shape
     */
    private void drawPattern(Graphics2D g2d, int x, int y, int size, int depth) {
        if (depth == 0) return;

        largeShape.setPosition(x, y);
        largeShape.setScale(size);
        largeShape.draw(g2d, params.largeShapeLineColor, params.largeShapeLineWidth,
                params.largeShapeFillColor, params.largeShapeLineType);

        int numShapes = params.numShapes;
        double angleStep = Math.PI * 2 / numShapes;
        int smallerSize = (int) (size * Math.sin(angleStep / 2));

        for (int i = 0; i < numShapes; i++) {
            double angle = i * angleStep;
            int newX = (int) (x + size * Math.cos(angle));
            int newY = (int) (y + size * Math.sin(angle));

            smallShape.setPosition(newX, newY);
            smallShape.setScale(smallerSize);
            smallShape.draw(g2d, params.smallShapeLineColor, params.smallShapeLineWidth,
                    params.smallShapeFillColor, params.smallShapeLineType);

            drawPattern(g2d, newX, newY, smallerSize, depth - 1);
        }
    }

    /**
     * Draws the algorithm to the graphics object based on the parameters already passed
     * @param g - The graphics object to draw to
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(params.backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        drawPattern(g2d, params.centerX, params.centerY, params.initialSize, params.depth);
    }

    /**
     * Creates and initialises new shapes based on the large/small shape selected
     */
    private void initialiseShapes() {
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

    /**
     * Gets the algorithm parameters
     * @return params
     */
    public RecursiveShapeParameters getParams() {
        return params;
    }

    /**
     * Gets the large shape
     * @return largeShape
     */
    public PatternShape getLargeShape() {
        return largeShape;
    }

    /**
     * Gets the small shape
     * @return smallShape
     */
    public PatternShape getSmallShape() {
        return smallShape;
    }
}

