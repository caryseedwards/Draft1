package stress_test.version3;

import strategyandfactory.algorithms.*;
import strategyandfactory.parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class RecursiveShapeV3 {

    static AlgorithmContext context = AlgorithmContext.getAlgorithmContext();
    public static ArrayList<ShapeParameters> shapeParameters = new ArrayList<ShapeParameters>();

    public static AlgorithmStrategy recursiveShapeStrategy(CountDownLatch latch) {
        CanvasParameters canvasParameters = new CanvasParameters(500, 500, Color.WHITE);
        shapeParameters.add(new ShapeParameters("square", 1, Color.GRAY, Color.BLACK));
        shapeParameters.add(new ShapeParameters("hexagon", 1, Color.BLUE, Color.BLACK));
        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 65, 9, 4);

        return new RecursiveShapeAlgorithm(canvasParameters, shapeParameters, algorithm) {
            @Override
            public void drawPattern(Graphics g) {
                super.drawPattern(g);
                latch.countDown();
            }
        };
    }

    public static void showRecursiveShape(CountDownLatch latch){
        context.setStrategy(recursiveShapeStrategy(latch));
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Version 3: Recursive Shape");
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        long startTime = System.nanoTime();
        showRecursiveShape(latch);
        latch.await();
        long endTime = System.nanoTime();
        double timeDiffInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time Elapsed: " + String.format("%.5f seconds", timeDiffInSeconds));
    }
}
