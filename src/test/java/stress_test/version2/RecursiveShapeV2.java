package stress_test.version2;

import template.algorithms.RecursiveShapeAlgorithm;
import template.parameters.*;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class RecursiveShapeV2 {
    public static CanvasParameters canvasParameters;
    public static ArrayList<ShapeParameters> shapeParameters = new ArrayList<>();
    public static RecursiveShapeAlgorithmParameters rsParameters;

    public static void showRecursiveShape(CountDownLatch latch) {
        JFrame frame = new JFrame("Version 2: Recursive Shape");
        canvasParameters = new CanvasParameters(500, 500, Color.WHITE);
        shapeParameters.add(new ShapeParameters("square", 1, Color.GRAY, Color.BLACK));
        shapeParameters.add(new ShapeParameters("hexagon", 1, Color.BLUE, Color.BLACK));
        rsParameters = new RecursiveShapeAlgorithmParameters(250, 250, 65, 9, 4);

        RecursiveShapeAlgorithm pattern = new RecursiveShapeAlgorithm(canvasParameters, shapeParameters, rsParameters) {
            @Override
            public void drawPattern(Graphics g) {
                super.drawPattern(g);
                latch.countDown();
            }
        };
        pattern.executeAlgorithm();
        frame.add(pattern);
        frame.setSize(canvasParameters.getHeight(), canvasParameters.getWidth());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
