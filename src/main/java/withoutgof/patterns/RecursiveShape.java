package withoutgof.patterns;

import withoutgof.parameters.RecursiveShapeParameters;
import withoutgof.shapes.*;

import javax.swing.*;
import java.awt.*;

public class RecursiveShape extends JPanel {
    public RecursiveShapeParameters params;
    public PatternShape largeShape;
    public PatternShape smallShape;

    public RecursiveShape(RecursiveShapeParameters params) {
        this.params = params;
        initialiseShapes();
    }

    private void drawPattern(Graphics2D g2d, int x, int y, int size, int depth) {
        if (depth == 0) return;

        largeShape.setPosition(x, y);
        largeShape.setScale(size);
        largeShape.draw(g2d, params.largeShapeLineColor, params.largeShapeLineWidth,
                params.largeShapeFillColor, params.largeShapeLineType);

        int numShapes = params.numShapes;
        double angleStep = Math.PI * 2 / numShapes;
        int smallerSize = (int) (size * Math.sin(angleStep / 2));

        for (int i = 0; i < numShapes; i++) {
            double angle = i * angleStep;
            int newX = (int) (x + size * Math.cos(angle));
            int newY = (int) (y + size * Math.sin(angle));

            smallShape.setPosition(newX, newY);
            smallShape.setScale(smallerSize);
            smallShape.draw(g2d, params.smallShapeLineColor, params.smallShapeLineWidth,
                    params.smallShapeFillColor, params.smallShapeLineType);

            drawPattern(g2d, newX, newY, smallerSize, depth - 1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(params.backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        drawPattern(g2d, params.centerX, params.centerY, params.initialSize, params.depth);
    }

    private void initialiseShapes(){
        switch (params.largeShapeType) {
            case "circle" -> largeShape = new Circle(params.centerX, params.centerY, params.initialSize);
            case "square" -> largeShape = new Square(params.centerX, params.centerY, params.initialSize);
            case "triangle" -> largeShape = new Triangle(params.centerX, params.centerY, params.initialSize);
            case "hexagon" -> largeShape = new Hexagon(params.centerX, params.centerY, params.initialSize);
        }

        switch (params.smallShapeType) {
            case "circle" -> smallShape = new Circle(params.centerX, params.centerY, params.initialSize);
            case "square" -> smallShape = new Square(params.centerX, params.centerY, params.initialSize);
            case "triangle" -> smallShape = new Triangle(params.centerX, params.centerY, params.initialSize);
            case "hexagon" -> smallShape = new Hexagon(params.centerX, params.centerY, params.initialSize);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Pattern");

        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape pattern = new RecursiveShape(params);
        frame.add(pattern);
        frame.setSize(params.canvasSizeX, params.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

