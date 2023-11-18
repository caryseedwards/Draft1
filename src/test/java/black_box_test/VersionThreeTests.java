package black_box_test;

import org.junit.Test;
import strategyandfactory.algorithms.*;
import strategyandfactory.parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VersionThreeTests {

    AlgorithmContext context = AlgorithmContext.getAlgorithmContext();

    public static AlgorithmStrategy recursiveShapeStrategy() {
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.BLACK));
        shapes.add(new ShapeParameters("square", 1, Color.BLACK, Color.YELLOW));
        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);
        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }

    public static AlgorithmStrategy circlePackingStrategy() {
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        CirclePackingAlgorithmParameters algorithm = new CirclePackingAlgorithmParameters(250, 250, 200, 5, 50, 100, 1);
        return new CirclePackingAlgorithm(canvas, shapes, algorithm);
    }

    public static AlgorithmStrategy sierpinskiShapeStrategy() {
        CanvasParameters canvas = new CanvasParameters(1200, 1200, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 400, 100, 4);
        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }
    @Test
    public void recursiveShapeTest(){
        context.setStrategy(recursiveShapeStrategy());
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Test
    public void circlePackingTest(){
        context.setStrategy(circlePackingStrategy());
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Test
    public void sierpinskiShapeTest(){
        context.setStrategy(sierpinskiShapeStrategy());
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}

