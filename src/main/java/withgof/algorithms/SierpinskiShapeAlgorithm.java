package withgof.algorithms;

import withgof.shapes.*;
import withgof.parameters.CanvasParameters;
import withgof.parameters.ShapeParameters;
import withgof.parameters.SierpinskiShapeAlgorithmParameters;
import withgof.shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class SierpinskiShapeAlgorithm implements AlgorithmStrategy {
    private final CanvasParameters canvasParameters;
    private final ShapeParameters shapeParameters;
    private final SierpinskiShapeAlgorithmParameters algorithmParameters;
    private final ArrayList<Shape> shapesToDraw;

    public SierpinskiShapeAlgorithm(CanvasParameters canvasParameters, ArrayList<ShapeParameters> shapeParameters, SierpinskiShapeAlgorithmParameters algorithmParameters) {
        this.canvasParameters = canvasParameters;
        this.shapeParameters = shapeParameters.get(0);
        this.algorithmParameters = algorithmParameters;
        this.shapesToDraw = new ArrayList<>();
    }

    public boolean validateParameters() {
        return canvasParameters.validateParameters() && shapeParameters.validateParameters() && algorithmParameters.validateParameters();
    }

    @Override
    public void executeAlgorithm() {
        if (validateParameters()) {
            switch (shapeParameters.getShapeType()) {
                case "triangle":
                    addSierpinski(new Triangle(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize()), algorithmParameters.getDepth());
                    break;
                case "circle":
                    addGasket(new Circle(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize()), algorithmParameters.getDepth());
                    break;
                case "square":
                    addCarpet(new Square(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize()), algorithmParameters.getDepth());
                    break;
                case "hexagon":
                    addHexagon(new Hexagon(algorithmParameters.getCentreX(), algorithmParameters.getCentreY(), algorithmParameters.getPolygonSize()), algorithmParameters.getDepth());
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

        double newRadius = triangle.radius / 2;

        int midX1 = (triangle.x1 + triangle.x2) / 2;
        int midY1 = (triangle.y1 + triangle.y2) / 2;
        int midX3 = (triangle.x1 + triangle.x3) / 2;
        int midY3 = (triangle.y1 + triangle.y3) / 2;

        addSierpinski(new Triangle(triangle.x1, triangle.y1 - (int) newRadius, newRadius), depth - 1);
        addSierpinski(new Triangle(midX1, midY1 - (int) newRadius, newRadius), depth - 1);
        addSierpinski(new Triangle(midX3, midY3 - (int) newRadius, newRadius), depth - 1);
    }

    private void addGasket(Circle circle, int depth) {
        if (depth <= 0) return;

        shapesToDraw.add(circle);

        int newRadius = (int) circle.radius / 2;
        int dx = (int) (newRadius * Math.cos(Math.PI / 6));
        int dy = (int) (newRadius * Math.sin(Math.PI / 6));

        addGasket(new Circle(circle.centerX, circle.centerY - newRadius, newRadius), depth - 1);
        addGasket(new Circle(circle.centerX - dx, circle.centerY + dy, newRadius), depth - 1);
        addGasket(new Circle(circle.centerX + dx, circle.centerY + dy, newRadius), depth - 1);
    }

    public void addHexagon(Hexagon hexagon, int depth) {
        if (depth == 0) {
            shapesToDraw.add(hexagon);
            return;
        }

        double newRadius = hexagon.radius / 3;

        for (int i = 0; i < 6; i++) {
            int newX = hexagon.centerX + (int) (newRadius * 2 * Math.cos(i * Math.PI / 3));
            int newY = hexagon.centerY + (int) (newRadius * 2 * Math.sin(i * Math.PI / 3));
            addHexagon(new Hexagon(newX, newY, newRadius), depth - 1);
        }

        addHexagon(new Hexagon(hexagon.centerX, hexagon.centerY, newRadius), depth - 1);
    }

    private void addCarpet(Square square, int depth) {
        if (depth == 0) {
            shapesToDraw.add(square);
            return;
        }

        double newRadius = square.radius / 3;
        double offsetX = newRadius * 2;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 && col == 1) continue;

                int newX = (int) (square.centerX + (col - 1) * offsetX);
                int newY = (int) (square.centerY + (row - 1) * offsetX);

                Square newSquare = new Square(newX, newY, newRadius);
                addCarpet(newSquare, depth - 1);
            }
        }
    }
}
