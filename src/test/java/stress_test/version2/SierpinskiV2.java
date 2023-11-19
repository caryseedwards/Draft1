package stress_test.version2;

import template.algorithms.SierpinskiShapeAlgorithm;
import template.parameters.CanvasParameters;
import template.parameters.ShapeParameters;
import template.parameters.SierpinskiShapeAlgorithmParameters;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SierpinskiV2 {
    public static void showSierpinski(CountDownLatch latch){
        JFrame frame = new JFrame("Version 2: Sierpinski");
        CanvasParameters canvasParameters = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapeParameters = new ArrayList<>();
        shapeParameters.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters ssParameters = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 13);
        SierpinskiShapeAlgorithm pattern = new SierpinskiShapeAlgorithm(canvasParameters, shapeParameters, ssParameters){
            @Override
            public void drawPattern(Graphics g) {
                super.drawPattern(g);
                latch.countDown();
            }
        };
        pattern.executeAlgorithm();
        frame.add(pattern);
        frame.setSize(canvasParameters.getWidth(), canvasParameters.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        long startTime = System.nanoTime();
        showSierpinski(latch);
        latch.await();
        long endTime = System.nanoTime();
        double timeDiffInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time Elapsed: " + String.format("%.5f seconds", timeDiffInSeconds));
    }
}
