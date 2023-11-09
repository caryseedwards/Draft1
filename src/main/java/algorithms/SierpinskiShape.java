package algorithms;

import parameters.SierpinskiShapeParameters;
import shapes.*;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SierpinskiShape extends JPanel {
    private final SierpinskiShapeParameters params;
    private final ArrayList<Shape> shapesToDraw = new ArrayList<>();

    public SierpinskiShape(SierpinskiShapeParameters params) {
        this.params = params;
    }

    public void initializeShapes() {
        switch (params.shapeType) {
            case "triangle":
                addSierpinski(new Triangle(params.centreX, params.centreY, params.polygonSize), params.depth);
                break;
            case "circle":
                addGasket(new Circle(params.centreX, params.centreY, params.polygonSize), params.depth);
                break;
            case "square":
                addCarpet(new Square(params.centreX, params.centreY, params.polygonSize), params.depth);
                break;
            case "hexagon":
                addHexagon(new Hexagon(params.centreX, params.centreY, params.polygonSize), params.depth);
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for (Shape shape : shapesToDraw) {
            shape.draw(g2d, params.shapeLineColour, params.shapeLineWidth, params.shapeFillColour, null);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Shape");
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setCentreX(400);
        params.setCentreY(400);
        params.setPolygonSize(300);
        params.setDepth(6);
        params.setShapeType("hexagon");
        params.setShapeLineColour(Color.BLACK);
        params.setShapeFillColour(Color.WHITE);
        params.setShapeLineWidth(1);

        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);
        sierpinskiShape.initializeShapes();
        frame.add(sierpinskiShape);
        frame.setSize(params.centreX*2, params.centreY*2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
