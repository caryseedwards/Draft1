package patterns;
import parameters.CirclePackingParameters;
import shapes.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CirclePacking extends JPanel {
    PatternShape boundaryShape;
    ArrayList<Circle> circles;
    CirclePackingParameters params;

    public CirclePacking(){
        this.circles = new ArrayList<>();
        this.params = new CirclePackingParameters();
        setBoundary(this.params.boundaryType);
    }

    public void setBoundary(String type) {
        switch (type) {
            case "circle" -> this.boundaryShape = new Circle(params.centreX, params.centreY, params.polygonSize);
            case "square" -> this.boundaryShape = new Square(params.centreX, params.centreY, params.polygonSize);
            case "triangle" -> this.boundaryShape = new Triangle(params.centreX, params.centreY, params.polygonSize);
            case "hexagon" -> this.boundaryShape = new Hexagon(params.centreX, params.centreY, params.polygonSize);
        }
    }

    public void addCircle() {
        for (int i = 0; i < params.maxAttempts; i++) {
            Point randomPosition = boundaryShape.randomPositionInside();
            int randomRadius = params.minRadius + (int) (Math.random() * (params.maxRadius - params.minRadius));
            Circle newCircle = new Circle(randomPosition.x, randomPosition.y, randomRadius);

            boolean overlaps = circles.stream().anyMatch(newCircle::overlaps);
            if (!overlaps) {
                boolean isInside = boundaryShape.isInside(newCircle);
                if (isInside) {
                    circles.add(newCircle);
                    return;
                }
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        g2d.setColor(params.backgroundColor);
        g2d.fillRect(0, 0, params.canvasWidth, params.canvasHeight);

        boundaryShape.draw(g2d, params.boundaryLineColour, params.boundaryLineWidth, params.boundaryFillColour, "solid");

        for (Circle circle : circles) {
            circle.draw(g2d, params.circleLineColour, params.circleLineWidth, params.circleFillColour, "solid");
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Packing in Shapes");

        CirclePacking packing = new CirclePacking();

        frame.add(packing);
        frame.setSize(packing.params.canvasWidth, packing.params.canvasHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Timer timer = new Timer(packing.params.animationSpeed, e -> {
            packing.addCircle();
            packing.repaint();
        });
        timer.start();
    }
}