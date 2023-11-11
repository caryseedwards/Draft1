package algorithms;

import parameters.*;
import shapes.*;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CirclePackingAlgorithm extends Algorithm {
    public CirclePackingAlgorithmParameters params;
    ShapeParameters boundaryParameters;
    ShapeParameters circleParameters;
    Shape boundaryShape;
    private ArrayList<Circle> circles;

    public CirclePackingAlgorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, AlgorithmParameters algorithmParams) {
        super(canvasParams, shapeParams, algorithmParams);
        try {
            validateParameters();
            initialiseAlgorithm(); // Initialize only if parameters are valid
        } catch (IllegalArgumentException e) {
            // Handle the exception, could be logging or throwing it further
            System.err.println("Parameter validation failed: " + e.getMessage());
            throw e; // Rethrowing the exception to indicate constructor failure
        }
    }

    @Override
    protected void initialiseAlgorithm() {
        this.params = (CirclePackingAlgorithmParameters) getAlgorithmParams();
        this.boundaryParameters = getShapeParameters().get(0);
        this.circleParameters = getShapeParameters().get(1);
        setBoundaryShape(getShapeParameters().get(0).getShapeType());
        this.circles = new ArrayList<>();
    }

    public void setBoundaryShape(String type) {
        switch (type) {
            case "circle" -> boundaryShape = new Circle(params.getCentreX(), params.getCentreY(), params.getPolygonSize());
            case "square" -> boundaryShape = new Square(params.centreX, params.centreY, params.polygonSize);
            case "triangle" -> boundaryShape = new Triangle(params.centreX, params.centreY, params.polygonSize);
            case "hexagon" -> boundaryShape = new Hexagon(params.centreX, params.centreY, params.polygonSize);
            default -> throw new IllegalArgumentException("Invalid boundary type: " + type);
        }
        boundaryParameters.setShapeType(type);
    }

    public Shape getBoundaryShape() {
        return boundaryShape;
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
                }
            }
        }
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    @Override
    public void executeAlgorithm() {
        addCircle();
    }

    @Override
    public void drawPattern(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getCanvasParameters().getBackgroundColour());
        g2d.fillRect(0, 0, getCanvasParameters().getWidth(), getCanvasParameters().getHeight());

        boundaryShape.draw(g2d, boundaryParameters.getLineColour(), boundaryParameters.getLineWidth(), boundaryParameters.getFillColour(), "solid");
        for (Circle circle : circles) {
            circle.draw(g2d, circleParameters.getLineColour(), circleParameters.getLineWidth(), circleParameters.getFillColour(), "solid");
        }
        this.pattern = g2d;
    }
    public CirclePackingAlgorithmParameters getAlgorithmParameters(){
        return params;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Packing in Shapes");
        CanvasParameters canvas = new CanvasParameters(500,500,Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<ShapeParameters>();
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        CirclePackingAlgorithmParameters algorithm = new CirclePackingAlgorithmParameters(250, 250, 200, 5, 50, 100, 1);
        CirclePackingAlgorithm packing = new CirclePackingAlgorithm(canvas, shapes,algorithm);
        packing.executeAlgorithm();
        frame.add(packing);
        frame.setSize(canvas.getWidth(), canvas.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Timer timer = new Timer(packing.params.animationSpeed, e -> {
            packing.addCircle();
            packing.repaint();
        });
        timer.start();
    }
}
