package draft1;
import javax.swing.*;
import java.awt.*;

public class GenerateEuclideanPattern extends JPanel {
    private EuclideanParameters params;

    public GenerateEuclideanPattern(EuclideanParameters params) {
        this.params = params;
    }

    public void drawPattern(Graphics2D g2d, int x, int y, double radius, int depth) {
        if (depth == 0) return;

        // Set line color and width
        g2d.setColor(params.lineColor);
        g2d.setStroke(new BasicStroke(params.lineWidth));

        // Draw larger shape
        if ("circle".equals(params.shapeType)) {
            g2d.drawOval(x - (int) radius, y - (int) radius, (int) (2 * radius), (int) (2 * radius));
        } else if ("square".equals(params.shapeType)) {
            g2d.drawRect(x - (int) radius, y - (int) radius, (int) (2 * radius), (int) (2 * radius));
        }
        // Number of smaller shapes
        int numShapes = params.numShapes;
        double angleStep = Math.PI * 2 / numShapes;
        double smallRadius = radius * Math.sin(angleStep / 2);

        for (int i = 0; i < numShapes; i++) {
            double angle = i * angleStep;
            int newX = (int) (x + radius * Math.cos(angle));
            int newY = (int) (y + radius * Math.sin(angle));

            // Draw smaller shape
            if ("circle".equals(params.smallShapeType)) {
                g2d.drawOval(newX - (int) smallRadius, newY - (int) smallRadius, (int) (2 * smallRadius), (int) (2 * smallRadius));
            } else if ("square".equals(params.smallShapeType)) {
                g2d.drawRect(newX - (int) smallRadius, newY - (int) smallRadius, (int) (2 * smallRadius), (int) (2 * smallRadius));
            }
            // Recursive call
            drawPattern(g2d, newX, newY, smallRadius, depth - 1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        g2d.setColor(params.backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the pattern repeatedly
        for (int i = 0; i < params.numPatternsX; i++) {
            for (int j = 0; j < params.numPatternsY; j++) {
                double newCenterX = params.centerX + i * params.patternSpacingX;
                double newCenterY = params.centerY + j * params.patternSpacingY;
                drawPattern(g2d, (int)newCenterX, (int)newCenterY, params.initialRadius, params.depth);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Generate Euclidean Pattern");

        EuclideanParameters params = new EuclideanParameters();
        params.initialiseParameters();
        GenerateEuclideanPattern pattern = new GenerateEuclideanPattern(params);
        frame.add(pattern);
        frame.setSize(params.canvasSizeX, params.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


