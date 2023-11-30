package stress_test.version3;

import version3.algorithms.SierpinskiShape;
import version3.parameters.SierpinskiShapeParameters;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class SierpinskiV3 {
    private static CountDownLatch latch;

    public static void showSierpinskiShape(){
        JFrame frame = new JFrame("Version 3: Sierpinski");
        SierpinskiShapeParameters ssParameters = new SierpinskiShapeParameters();
        ssParameters.setCentreX(400);
        ssParameters.setCentreY(1200);
        ssParameters.setPolygonSize(400);
        ssParameters.setDepth(13);
        ssParameters.setShapeType("triangle");
        ssParameters.setShapeFillColour(Color.WHITE);
        ssParameters.setShapeLineColour(Color.BLACK);
        ssParameters.setShapeLineWidth(2);
        SierpinskiShape pattern = new SierpinskiShape(ssParameters){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                latch.countDown();
            }
        };

        frame.add(pattern);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(1);
        long startTime = System.nanoTime();
        showSierpinskiShape();
        latch.await();
        long endTime = System.nanoTime();
        double timeDiffInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time Elapsed: " + String.format("%.5f seconds", timeDiffInSeconds));
    }
}
