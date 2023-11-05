package patterns;

import shapes.Square;

import javax.swing.*;
import java.awt.*;

public class SierpinskiCarpet extends JPanel {

    public void drawCarpet(Graphics2D g, Square square, int depth) {
        if (depth == 0) {
            square.draw(g, Color.BLACK, 1.0f, Color.BLACK, null);
            return;
        }

        double newRadius = square.radius / 3;
        double offsetX = newRadius * 2;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                // Skip the middle square
                if (row == 1 && col == 1) continue;

                int newX = (int) (square.centerX + (col - 1) * offsetX);
                int newY = (int) (square.centerY + (row - 1) * offsetX);

                Square newSquare = new Square(newX, newY, newRadius);
                drawCarpet(g, newSquare, depth - 1);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Square square = new Square(400, 400, 300);
        drawCarpet(g2d, square, 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Carpet");
        SierpinskiCarpet carpet = new SierpinskiCarpet();
        frame.add(carpet);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
