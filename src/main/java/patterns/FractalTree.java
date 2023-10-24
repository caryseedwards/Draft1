package patterns;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    public void drawTree(Graphics2D g, int x1, int y1, double angle, double length, int depth, float thickness) {
        if (depth == 0) return;

        int x2 = x1 + (int) (Math.cos(angle) * length);
        int y2 = y1 + (int) (Math.sin(angle) * length);

        // Vary the thickness of each branch depending on its depth
        g.setStroke(new BasicStroke(thickness));

        // Draw a line for the branch
        g.drawLine(x1, y1, x2, y2);

        // Branch splitting
        int numBranches = 2 + (int) (Math.random() * 2); // 2 to 3 branches
        double angleStep = Math.PI / 6; // 30-degree step

        // Draw branches
        for (int i = 0; i < numBranches; i++) {
            double newAngle = angle - angleStep + (i * angleStep / (numBranches - 1));
            drawTree(g, x2, y2, newAngle, length * 0.7, depth - 1, thickness * 0.7f);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        // Initialize the tree from the bottom of the frame
        drawTree(g2d, getWidth() / 2, getHeight() - 50, -Math.PI / 2, getHeight() / 4, 10, 10.0f);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Tree");
        FractalTree tree = new FractalTree();
        frame.add(tree);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
