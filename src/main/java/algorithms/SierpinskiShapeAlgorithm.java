package algorithms;

import parameters.*;
import shapes.Circle;
import shapes.Hexagon;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SierpinskiShapeAlgorithm extends Algorithm {
    private SierpinskiShapeAlgorithmParameters params;
    private ShapeParameters sierpinskiShape;
    private ArrayList<Shape> shapesToDraw = new ArrayList<>();

    public SierpinskiShapeAlgorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
        super(canvasParams, shapeParams, algorithmParams);
        initialiseAlgorithm();
        executeAlgorithm();
    }

    @Override
    protected void initialiseAlgorithm() {
        this.params = (SierpinskiShapeAlgorithmParameters) getAlgorithmParams();
        this.sierpinskiShape = getShapeParameters().get(0);
        this.shapesToDraw = new ArrayList<>();
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

    @Override
    public void executeAlgorithm() {
        switch (getShapeParameters().get(0).getShapeType()) {
            case "triangle":
                addSierpinski(new Triangle(params.getCentreX(), params.getCentreY(), params.getPolygonSize()), params.getDepth());
                break;
            case "circle":
                addGasket(new Circle(params.getCentreX(), params.getCentreY(), params.getPolygonSize()), params.getDepth());
                break;
            case "square":
                addCarpet(new Square(params.getCentreX(), params.getCentreY(), params.getPolygonSize()), params.getDepth());
                break;
            case "hexagon":
                addHexagon(new Hexagon(params.getCentreX(), params.getCentreY(), params.getPolygonSize()), params.getDepth());
                break;
            default:
                throw new IllegalArgumentException("Invalid shape type: " + getShapeParameters().get(0).getShapeType());
        }
    }

    @Override
    public void drawPattern(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getCanvasParameters().getBackgroundColour());
        g2d.fillRect(0, 0, getCanvasParameters().getWidth(), getCanvasParameters().getHeight());

        for (Shape shape : shapesToDraw) {
            shape.draw(g2d, sierpinskiShape.getLineColour(), sierpinskiShape.getLineWidth(), sierpinskiShape.getFillColour(), null);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Shape");
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);
        SierpinskiShapeAlgorithm sierpinskiShape = new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
        frame.add(sierpinskiShape);
        frame.setSize(canvas.getWidth(), canvas.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
