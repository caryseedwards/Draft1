package withgof.algorithms;

import withgof.parameters.CanvasParameters;
import withgof.parameters.ShapeParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Shape;
import withgof.shapes.*;

import java.awt.*;
import java.util.ArrayList;

public class SierpinskiShapeAlgorithm implements AlgorithmStrategy {
    private final CanvasParameters canvasParameters;
    private final ShapeParameters shapeParameters;
    private final SierpinskiShapeAlgorithmParameters algorithmParameters;
    private final ArrayList<Shape> shapesToDraw;
    private final ShapeFactory shapeFactory;

    public SierpinskiShapeAlgorithm(CanvasParameters canvasParameters, ArrayList<ShapeParameters> shapeParameters, SierpinskiShapeAlgorithmParameters algorithmParameters) {
        this.canvasParameters = canvasParameters;
        this.shapeParameters = shapeParameters.get(0);
        this.algorithmParameters = algorithmParameters;
        this.shapesToDraw = new ArrayList<>();
        this.shapeFactory = new ShapeFactory();
    }

    public boolean validateParameters() {
        return canvasParameters.validateParameters() && shapeParameters.validateParameters() && algorithmParameters.validateParameters();
    }

    @Override
    public void executeAlgorithm() {
        if (validateParameters()) {
            switch (shapeParameters.getShapeType()) {
                case "triangle":
                    addSierpinski((Triangle) shapeFactory.createShape(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize(), shapeParameters), algorithmParameters.getDepth());
                    break;
                case "circle":
                    addGasket((Circle) shapeFactory.createShape(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize(), shapeParameters), algorithmParameters.getDepth());
                    break;
                case "square":
                    addCarpet((Square) shapeFactory.createShape(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize(), shapeParameters), algorithmParameters.getDepth());
                    break;
                case "hexagon":
                    addHexagon((Hexagon) shapeFactory.createShape(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize(), shapeParameters), algorithmParameters.getDepth());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape type: " + shapeParameters.getShapeType());
            }
        }
    }

    @Override
    public void drawPattern(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(canvasParameters.getBackgroundColour());
        g2d.fillRect(0, 0, canvasParameters.getWidth(), canvasParameters.getHeight());

        for (Shape shape : shapesToDraw) {
            shape.draw(g2d, shapeParameters.getLineColour(), shapeParameters.getLineWidth(), shapeParameters.getFillColour(), null);
        }
    }

    private void addSierpinski(Triangle triangle, int depth) {
        if (depth == 0) {
            shapesToDraw.add(triangle);
            return;
        }
        double newRadius = triangle.getRadius() / 2;

        int midX1 = (triangle.getX1() + triangle.getX2()) / 2;
        int midY1 = (triangle.getY1() + triangle.getY2()) / 2;
        int midX3 = (triangle.getX1() + triangle.getX3()) / 2;
        int midY3 = (triangle.getY1() + triangle.getY3()) / 2;

        addSierpinski((Triangle) shapeFactory.createShape(triangle.getX1(), triangle.getY1() - (int) newRadius, newRadius, shapeParameters), depth - 1);
        addSierpinski((Triangle) shapeFactory.createShape(midX1, midY1 - (int) newRadius, newRadius, shapeParameters), depth - 1);
        addSierpinski((Triangle) shapeFactory.createShape(midX3, midY3 - (int) newRadius, newRadius, shapeParameters), depth - 1);
    }

    private void addGasket(Circle circle, int depth) {
        if (depth <= 0) return;

        shapesToDraw.add(circle);

        int newRadius = (int) circle.getRadius() / 2;
        int dx = (int) (newRadius * Math.cos(Math.PI / 6));
        int dy = (int) (newRadius * Math.sin(Math.PI / 6));

        addGasket((Circle) shapeFactory.createShape(circle.getCenterX(), circle.getCenterY() - newRadius, newRadius, shapeParameters), depth - 1);
        addGasket((Circle) shapeFactory.createShape(circle.getCenterX() - dx, circle.getCenterY() + dy, newRadius, shapeParameters), depth - 1);
        addGasket((Circle) shapeFactory.createShape(circle.getCenterX() + dx, circle.getCenterY() + dy, newRadius, shapeParameters), depth - 1);
    }

    public void addHexagon(Hexagon hexagon, int depth) {
        if (depth == 0) {
            shapesToDraw.add(hexagon);
            return;
        }

        double newRadius = hexagon.radius / 3;

        for (int i = 0; i < 6; i++) {
            int newX = hexagon.getCenterX() + (int) (newRadius * 2 * Math.cos(i * Math.PI / 3));
            int newY = hexagon.getCenterY() + (int) (newRadius * 2 * Math.sin(i * Math.PI / 3));
            addHexagon((Hexagon) shapeFactory.createShape(newX, newY, newRadius, shapeParameters), depth - 1);
        }
        addHexagon((Hexagon) shapeFactory.createShape(hexagon.getCenterX(), hexagon.getCenterY(), newRadius, shapeParameters), depth - 1);
    }

    private void addCarpet(Square square, int depth) {
        if (depth == 0) {
            shapesToDraw.add(square);
            return;
        }
        double newRadius = square.getRadius() / 3;
        double offsetX = newRadius * 2;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 && col == 1) continue;

                int newX = (int) (square.getCenterX() + (col - 1) * offsetX);
                int newY = (int) (square.getCenterY() + (row - 1) * offsetX);

                Square newSquare = (Square) shapeFactory.createShape(newX, newY, newRadius, shapeParameters);
                addCarpet(newSquare, depth - 1);
            }
        }
    }
}
