package patterns;

import javax.swing.*;
import java.awt.*;


public class SierpinskiShape extends JPanel {

    private String shapeType;  // "triangle" or "square"

    public SierpinskiShape(String shapeType) {
        this.shapeType = shapeType;
    }

    public void drawTriangle(Graphics2D g, int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
        if (depth == 0) {
            Polygon p = new Polygon();
            p.addPoint(x1, y1);
            p.addPoint(x2, y2);
            p.addPoint(x3, y3);
            g.fillPolygon(p);
            return;
        }

        int midX1 = (x1 + x2) / 2;
        int midY1 = (y1 + y2) / 2;
        int midX2 = (x2 + x3) / 2;
        int midY2 = (y2 + y3) / 2;
        int midX3 = (x1 + x3) / 2;
        int midY3 = (y1 + y3) / 2;

        drawTriangle(g, x1, y1, midX1, midY1, midX3, midY3, depth - 1);
        drawTriangle(g, midX1, midY1, x2, y2, midX2, midY2, depth - 1);
        drawTriangle(g, midX3, midY3, midX2, midY2, x3, y3, depth - 1);
    }

    public void drawSquare(Graphics2D g, int x, int y, int radius, int depth) {
        if (depth == 0) {
            g.fillRect(x - radius, y - radius, radius * 2, radius * 2);
            return;
        }

        int newSize = radius / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    drawSquare(g, x + newSize * (i - 1), y + newSize * (j - 1), newSize, depth - 1);
                }
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if ("triangle".equals(shapeType)) {
            drawTriangle(g2d, 400, 100, 100, 650, 700, 650, 6);
        } else if ("square".equals(shapeType)) {
            drawSquare(g2d, 400, 400, 300, 5);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Shape");
        SierpinskiShape shape = new SierpinskiShape("square");  // Change to "square" to test square
        frame.add(shape);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
