package stress_test.version2;

import version2.algorithms.*;
import version2.parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CirclePackingV2 {

    static AlgorithmContext context = AlgorithmContext.getAlgorithmContext();

    public static AlgorithmStrategy circlePackingStrategy() {
        CanvasParameters canvas = new CanvasParameters(500, 500, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("circle", 1, Color.GREEN, Color.BLACK));
        shapes.add(new ShapeParameters("circle", 1, Color.PINK, Color.BLACK));
        CirclePackingAlgorithmParameters algorithm = new CirclePackingAlgorithmParameters(250, 250, 250, 1, 1, 10000, 1);
        return new CirclePackingAlgorithm(canvas, shapes, algorithm);
    }

    public static void showCirclePacking(){
        context.setStrategy(circlePackingStrategy());
        context.executeAlgorithm();

        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Version 2: Circle Packing");
        frame.setVisible(true);
        CirclePackingAlgorithm cp = (CirclePackingAlgorithm) context.getStrategy();
        Timer timer = new Timer(1, e -> {
            cp.addCircles();
            context.repaint();
        });
        timer.start();
    }

    public static void main(String[] args) throws InterruptedException {
        showCirclePacking();
    }
}
