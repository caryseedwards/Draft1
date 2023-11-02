package patterns;
import parameters.RecursiveShapeParameters;
import shapes.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecursiveShape extends JPanel {
    public RecursiveShapeParameters params;
    public PatternShape largeShape;
    public PatternShape smallShape;
    private ArrayList<PatternShape> shapes = new ArrayList<>();


    public RecursiveShape(RecursiveShapeParameters params) {
        this.params = params;
      initialiseShapes(params.largeShapeType, params.smallShapeType);
    }
    private void drawPattern(Graphics2D g2d, int x, int y, double radius, int depth) {
        if (depth == 0) return;
        // Draw larger shape   Color lineColor, float lineWidth, Color fillColor, String lineType


        // Placement of smaller shapes
        double angleStep = Math.PI * 2 / params.numShapes;
        double smallRadius = radius * Math.sin(angleStep / 2);

        // Draw selected number of smaller shapes
        for (int i = 0; i < params.numShapes; i++) {
            double angle = i * angleStep;
            int newX = (int) (x + radius * Math.cos(angle));
            int newY = (int) (y + radius * Math.sin(angle));
            smallShape.draw(g2d, params.smallShapeLineColor, params.smallShapeLineWidth, params.smallShapeFillColor, params.smallShapeLineType);

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

        // Set line color and width
        g2d.setColor(params.lineColor);
        g2d.setStroke(new BasicStroke(params.lineWidth));

        drawPattern(g2d, params.centerX, params.centerY, params., params.depth);

        // Draw the pattern repeatedly
       /* for (int i = 0; i < params.numPatternsX; i++) {
            for (int j = 0; j < params.numPatternsY; j++) {
                double newCenterX = params.centerX + i * params.patternSpacingX;
                double newCenterY = params.centerY + j * params.patternSpacingY;
                drawPattern(g2d, (int)newCenterX, (int)newCenterY, params.initialRadius, params.depth);
            }
        }*/

    }
    private void initialiseShapes(String largeShape, String smallShape){
        if ("circle".equals(largeShape)) {
            this.largeShape = new Circle();
        } else if ("square".equals(largeShape)) {
            this.largeShape = new Square();
        } else if ("triangle".equals(largeShape)) {
            this.largeShape = new Triangle();
        } else if ("hexagon".equals(largeShape)) {
            this.largeShape = new Hexagon();
        }
        if ("circle".equals(smallShape)) {
            this.smallShape = new Circle();
        } else if ("square".equals(smallShape)) {
            this.smallShape = new Square();
        } else if ("triangle".equals(smallShape)) {
            this.smallShape = new Triangle();
        } else if ("hexagon".equals(smallShape)) {
            this.smallShape = new Hexagon();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Euclidean Pattern");

        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape pattern = new RecursiveShape(params);
        frame.add(pattern);
        frame.setSize(params.canvasSizeX, params.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


