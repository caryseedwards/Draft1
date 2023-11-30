package black_box_test;

import version2.algorithms.*;
import version2.parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VersionThreeTests {

    static AlgorithmContext context = AlgorithmContext.getAlgorithmContext();

    public static AlgorithmStrategy recursiveShapeStrategy() {
        CanvasParameters canvas = new CanvasParameters(1200, 1200, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.BLACK));
        shapes.add(new ShapeParameters("square", 1, Color.BLACK, Color.YELLOW));
        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(200, 200, 100, 4, 6);
        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }

    public static AlgorithmStrategy circlePackingStrategy() {
        CanvasParameters canvas = new CanvasParameters(1200, 1200, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        CirclePackingAlgorithmParameters algorithm = new CirclePackingAlgorithmParameters(200, 200, 100, 5, 50, 100, 1);
        return new CirclePackingAlgorithm(canvas, shapes, algorithm);
    }

    public static AlgorithmStrategy sierpinskiShapeStrategy() {
        CanvasParameters canvas = new CanvasParameters(1200, 1200, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(200, 400, 100, 4);
        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }

    public static void showRecursiveShape(){
        context.setStrategy(recursiveShapeStrategy());
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Version 3: Recursive Shape");
        frame.setVisible(true);
    }

    public static void showCirclePacking(){
        context.setStrategy(circlePackingStrategy());
        context.executeAlgorithm();

        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Version 3: Circle Packing");
        frame.setVisible(true);
        CirclePackingAlgorithm cp = (CirclePackingAlgorithm) context.getStrategy();
        Timer timer = new Timer(1, e -> {
            cp.addCircles();
            context.repaint();
        });
        timer.start();
    }

    public static void showSierpinski(){
        context.setStrategy(sierpinskiShapeStrategy());
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Version 3: Sierpinski");
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        showRecursiveShape();
        Thread.sleep(1000);
        showCirclePacking();
        Thread.sleep(1000);
        showSierpinski();
    }
}

