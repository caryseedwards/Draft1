package patterns;
import shapes.Circle;
import shapes.Hexagon;
import shapes.Square;
import shapes.Triangle;

import javax.swing.*;
import java.awt.*;

public class SierpinskiShape extends JPanel {
    enum Shape { TRIANGLE, CIRCLE, SQUARE, HEXAGON }
    private Shape shapeToDraw = Shape.TRIANGLE;
    private int depth = 5;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        switch (shapeToDraw) {
            case TRIANGLE:
                drawSierpinski(g2d, new Triangle(400, 1100, 350), depth);
                break;
            case CIRCLE:
                drawGasket(g2d, 300, 300, 300, depth);
                break;
            case SQUARE:
                drawCarpet(g2d, new Square(400, 400, 300), depth);
                break;
            case HEXAGON:
                drawHexagon(g2d, getWidth() / 2, getHeight() / 2, 300, depth);
                break;
        }
    }
    public void drawSierpinski(Graphics2D g, Triangle triangle, int depth) {
        if (depth == 0) {
            triangle.draw(g, Color.BLACK, 1.0f, Color.BLACK, null);
            return;
        }

        double newRadius = triangle.radius / 2;

        int midX1 = (triangle.x1 + triangle.x2) / 2;
        int midY1 = (triangle.y1 + triangle.y2) / 2;
        int midX3 = (triangle.x1 + triangle.x3) / 2;
        int midY3 = (triangle.y1 + triangle.y3) / 2;

        drawSierpinski(g, new Triangle(triangle.x1, triangle.y1 - (int) newRadius, newRadius), depth - 1);
        drawSierpinski(g, new Triangle(midX1, midY1 - (int) newRadius, newRadius), depth - 1);
        drawSierpinski(g, new Triangle(midX3, midY3 - (int) newRadius, newRadius), depth - 1);
    }
    private void drawGasket(Graphics g, int x, int y, int radius, int depth) {
        if (depth <= 0) return;

        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        int newRadius = radius / 2;
        int dx = (int) (newRadius * Math.cos(Math.PI / 6));
        int dy = (int) (newRadius * Math.sin(Math.PI / 6));

        drawGasket(g, x, y - newRadius, newRadius, depth - 1);
        drawGasket(g, x - dx, y + dy, newRadius, depth - 1);
        drawGasket(g, x + dx, y + dy, newRadius, depth - 1);
    }
    public void drawHexagon(Graphics2D g, int x, int y, double radius, int depth) {
        if (depth == 0) {
            Hexagon hexagon = new Hexagon(x, y, radius);
            hexagon.draw(g, Color.BLACK, 1.0f, Color.BLACK, "");
            return;
        }

        double newRadius = radius / 3;

        // Draw 6 smaller hexagons around the central point
        for (int i = 0; i < 6; i++) {
            int newX = x + (int) (newRadius * 2 * Math.cos(i * Math.PI / 3));
            int newY = y + (int) (newRadius * 2 * Math.sin(i * Math.PI / 3));
            drawHexagon(g, newX, newY, newRadius, depth - 1);
        }

        // Draw a smaller hexagon in the center
        drawHexagon(g, x, y, newRadius, depth - 1);
    }
    public void drawCarpet(Graphics2D g, Square square, int depth) {
        if (depth == 0) {
            square.draw(g, Color.BLACK, 1.0f, Color.BLACK, null);
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
                drawCarpet(g, newSquare, depth - 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Shape");
        SierpinskiShape sierpinskiShape = new SierpinskiShape();
        frame.add(sierpinskiShape);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
