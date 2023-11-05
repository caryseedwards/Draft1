package patterns;
import shapes.Circle;
import shapes.Hexagon;
import shapes.Square;
import shapes.Triangle;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class SierpinskiShape extends JFrame {
    public static int ITERATIONS = 2;

    public SierpinskiShape() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawSierpinskiTriangle(g2d, 400, 400, 200, ITERATIONS);
       // drawSierpinskiCarpet(g2d, 400, 100, 50, ITERATIONS);
       // drawSierpinskiHexagon(g2d, 100, 400, 50, ITERATIONS);
       // drawApollonianGasket(g2d, 100, 100, 50, ITERATIONS);
    }


        public void drawSierpinskiTriangle(Graphics2D g, int x, int y, int sideLength, int iterations) {
            if (iterations == 0) return;

            int height = (int) (Math.sqrt(3) * sideLength / 2);

            // Draw the current triangle
            int[] xPoints = {x, x - sideLength / 2, x + sideLength / 2};
            int[] yPoints = {y, y + height, y + height};
            g.setColor(Color.RED);
            g.fillPolygon(xPoints, yPoints, 3);

            // Calculate vertices of inner triangles
            int x1 = x;
            int y1 = y + height / 2;
            int x2 = x - sideLength / 4;
            int y2 = y + 3 * height / 4;
            int x3 = x + sideLength / 4;
            int y3 = y + 3 * height / 4;

            // Recursively draw three smaller triangles
            drawSierpinskiTriangle(g, x1, y1, sideLength / 2, iterations - 1);
            drawSierpinskiTriangle(g, x2, y2, sideLength / 2, iterations - 1);
            drawSierpinskiTriangle(g, x3, y3, sideLength / 2, iterations - 1);
        }









    private void drawSierpinskiCarpet(Graphics2D g, int x, int y, double radius, int iterations) {
        if (iterations == 0) return;
        Square square = new Square(x, y, radius);
        square.draw(g, Color.BLACK, 1.0f, Color.BLUE, "solid");
        double newRadius = radius / 3;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                drawSierpinskiCarpet(g, x + (int) (i * newRadius * 2), y + (int) (j * newRadius * 2), newRadius, iterations - 1);
            }
        }
    }

    private void drawSierpinskiHexagon(Graphics2D g, int x, int y, double radius, int iterations) {
        if (iterations == 0) return;
        Hexagon hexagon = new Hexagon(x, y, radius);
        hexagon.draw(g, Color.BLACK, 1.0f, Color.GREEN, "solid");
        double newRadius = radius / 2;
        drawSierpinskiHexagon(g, x, y, newRadius, iterations - 1);
        for (int i = 0; i < 6; i++) {
            int newX = (int) (x + newRadius * Math.cos(i * Math.PI / 3));
            int newY = (int) (y + newRadius * Math.sin(i * Math.PI / 3));
            drawSierpinskiHexagon(g, newX, newY, newRadius, iterations - 1);
        }
    }

    private void drawApollonianGasket(Graphics2D g, int x, int y, double radius, int iterations) {
        if (iterations == 0) return;
        Circle circle = new Circle(x, y, (int) radius);
        circle.draw(g, Color.BLACK, 1.0f, new Color(0, 0, 0, 0), "solid");
        double newRadius = radius / 2;
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                drawApollonianGasket(g, x + (int) (i * newRadius), y + (int) (j * newRadius), newRadius, iterations - 1);
            }
        }
    }

    public static void main(String[] args) {
        new SierpinskiShape();
    }
}
