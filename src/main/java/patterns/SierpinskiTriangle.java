package patterns;

import shapes.Triangle;

import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JPanel {

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Triangle triangle = new Triangle(400, 1100, 350); // Adjusted the y-coordinate
        drawSierpinski(g2d, triangle, 6);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        SierpinskiTriangle sierpinskiTriangle = new SierpinskiTriangle();
        frame.add(sierpinskiTriangle);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
