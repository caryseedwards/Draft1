package withoutgof.algorithms;

import withoutgof.parameters.CirclePackingParameters;
import withoutgof.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The implementation of the Circle Packing algorithm
 * Will fill a specified shapes with circles as an animation
 * @author carysedwards
 */
public class CirclePacking extends JPanel {
    private PatternShape boundaryShape;
    private final ArrayList<Circle> circles;
    private final CirclePackingParameters params;
    private int attempts = 0;


    /**
     * Constructor to create the circle packing algorithm
     * @param params - details of the circle packing algorithm to draw upon
     */
    public CirclePacking(CirclePackingParameters params) {
        this.params = params;
        setBoundary(this.params.boundaryType);
        this.circles = new ArrayList<>();
        addCircle();
    }

    /**
     * Sets the boundary type
     * @param type - shape type Circle, Square, Hexagon, Triangle
     */
    public void setBoundary(String type) {
        switch (type) {
            case "circle" -> this.boundaryShape = new Circle(params.centreX, params.centreY, params.polygonSize);
            case "square" -> this.boundaryShape = new Square(params.centreX, params.centreY, params.polygonSize);
            case "triangle" -> this.boundaryShape = new Triangle(params.centreX, params.centreY, params.polygonSize);
            case "hexagon" -> this.boundaryShape = new Hexagon(params.centreX, params.centreY, params.polygonSize);
        }
    }

    /**
     * The implementation of the logic of the algorithm
     * Will fill a bounded shapes with circles
     */
    public void addCircle() {
        for (int i = 0; i < params.maxAttempts; i++) {
            attempts++;
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
     * Draws the algorithm to the graphics object based on the parameters already passed
     * @param g - The graphics object to draw to
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(params.backgroundColor);
        g2d.fillRect(0, 0, params.canvasWidth, params.canvasHeight);

        boundaryShape.draw(g2d, params.boundaryLineColour, params.boundaryLineWidth, params.boundaryFillColour, "solid");
        for (Circle circle : circles) {
            circle.draw(g2d, params.circleLineColour, params.circleLineWidth, params.circleFillColour, "solid");
        }
    }

    /**
     * Gets the boundary shape
     * @return boundaryShape
     */
    public PatternShape getBoundaryShape() {
        return boundaryShape;
    }

    /**
     * Gets the circles to draw
     * @return circles
     */
    public ArrayList<Circle> getCircles() {
        return circles;
    }

    /**
     * Gets the algorithm parameters
     * @return params
     */
    public CirclePackingParameters getParams() {
        return params;
    }

}