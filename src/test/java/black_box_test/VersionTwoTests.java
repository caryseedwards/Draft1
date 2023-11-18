package black_box_test;

import template.algorithms.CirclePackingAlgorithm;
import template.algorithms.RecursiveShapeAlgorithm;
import template.algorithms.SierpinskiShapeAlgorithm;
import template.parameters.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import org.junit.Test;

public class VersionTwoTests {
    CanvasParameters canvasParameters;
    ArrayList<ShapeParameters> shapeParameters;
    RecursiveShapeAlgorithmParameters rsParameters;
    CirclePackingAlgorithmParameters cpParameters;
    SierpinskiShapeAlgorithmParameters ssParameters;

    @Test
    public void recursiveShapeTest(){
        JFrame frame = new JFrame("Recursive Pattern");
        canvasParameters = new CanvasParameters(500, 500, Color.WHITE);
        shapeParameters.add(new ShapeParameters("square", 1, Color.BLACK, Color.BLACK));
        shapeParameters.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.YELLOW));
        rsParameters = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);
        RecursiveShapeAlgorithm pattern = new RecursiveShapeAlgorithm(canvasParameters, shapeParameters, rsParameters);
        pattern.executeAlgorithm();
        frame.add(pattern);
        frame.setSize(canvasParameters.getHeight(), canvasParameters.getWidth());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Test
    public void circlePackingTest(){
        JFrame frame = new JFrame("Circle Packing Pattern");
        canvasParameters = new CanvasParameters(500,500,Color.WHITE);
        shapeParameters = new ArrayList<ShapeParameters>();
        shapeParameters.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapeParameters.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        cpParameters = new CirclePackingAlgorithmParameters(250, 250, 200, 5, 50, 100, 1);
        CirclePackingAlgorithm packing = new CirclePackingAlgorithm(canvasParameters, shapeParameters, cpParameters);
        packing.executeAlgorithm();
        frame.add(packing);
        frame.setSize(canvasParameters.getWidth(), canvasParameters.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Timer timer = new Timer(cpParameters.getAnimationSpeed(), e -> {
            packing.addCircles();
            packing.repaint();
        });
        timer.start();
    }

    @Test
    public void sierpinskiShapeTest(){
        JFrame frame = new JFrame("Sierpinski Pattern");
        canvasParameters = new CanvasParameters(800, 800, Color.WHITE);
        shapeParameters = new ArrayList<ShapeParameters>();
        shapeParameters.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        ssParameters = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);
        SierpinskiShapeAlgorithm sierpinskiShape = new SierpinskiShapeAlgorithm(canvasParameters, shapeParameters, ssParameters);
        sierpinskiShape.executeAlgorithm();
        frame.add(sierpinskiShape);
        frame.setSize(canvasParameters.getWidth(), canvasParameters.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
