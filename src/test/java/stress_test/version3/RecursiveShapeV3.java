package stress_test.version3;

import version3.algorithms.RecursiveShape;
import version3.parameters.RecursiveShapeParameters;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class RecursiveShapeV3 {
    private static CountDownLatch latch;

    public static void showRecursiveShape(){
        JFrame frame = new JFrame("Version 3: Recursive Shape");
        RecursiveShapeParameters rsParameters = new RecursiveShapeParameters();
        rsParameters = new RecursiveShapeParameters();
        rsParameters.canvasSizeX = 500;
        rsParameters.canvasSizeY = 500;
        rsParameters.setDepth(10);
        rsParameters.setInitialRadius(65);
        rsParameters.setNumShapes(4);
        rsParameters.setLargeShapeType("square");
        rsParameters.setLargeShapeFillColor(Color.GRAY);
        rsParameters.setLargeShapeLineColor(Color.BLACK);
        rsParameters.setLargeShapeLineWidth(1);
        rsParameters.setSmallShapeType("hexagon");
        rsParameters.setSmallShapeFillColor(Color.BLUE);
        rsParameters.setSmallShapeLineColor(Color.BLACK);
        rsParameters.setSmallShapeLineWidth(1);
        rsParameters.backgroundColor = Color.WHITE;
        rsParameters.setCenterX(250);
        rsParameters.setCenterY(250);
        RecursiveShape pattern = new RecursiveShape(rsParameters) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                latch.countDown();
            }
        };
        frame.add(pattern);
        frame.setSize(rsParameters.canvasSizeX, rsParameters.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(1);
        long startTime = System.nanoTime();
        showRecursiveShape();
        latch.await();
        long endTime = System.nanoTime();
        double timeDiffInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time Elapsed: " + String.format("%.5f seconds", timeDiffInSeconds));
    }
}
