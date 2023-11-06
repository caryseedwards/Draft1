package individuals;

import shapes.Hexagon;

import javax.swing.*;
import java.awt.*;

public class SierpinskiHexagon extends JPanel {

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawHexagon(g2d, getWidth() / 2, getHeight() / 2, 300, 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Hexagon");
        SierpinskiHexagon hexagon = new SierpinskiHexagon();
        frame.add(hexagon);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
