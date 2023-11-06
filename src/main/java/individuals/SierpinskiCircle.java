package individuals;

import java.awt.*;
import javax.swing.*;

public class SierpinskiCircle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGasket(g, 300, 300, 300, 10);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Apollonian Gasket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new SierpinskiCircle());
        frame.setVisible(true);
    }
}

