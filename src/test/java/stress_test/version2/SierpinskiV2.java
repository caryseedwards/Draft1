package stress_test.version2;


import version2.algorithms.AlgorithmContext;
import version2.algorithms.AlgorithmStrategy;
import version2.parameters.CanvasParameters;
import version2.parameters.ShapeParameters;
import version2.parameters.SierpinskiShapeAlgorithmParameters;
import version2.algorithms.SierpinskiShapeAlgorithm;
import java.util.concurrent.CountDownLatch;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class SierpinskiV2 {
    static AlgorithmContext context = AlgorithmContext.getAlgorithmContext();
    public static ArrayList<ShapeParameters> shapeParameters = new ArrayList<ShapeParameters>();
    public static CanvasParameters canvas;

    public static AlgorithmStrategy sierpinskiShapeStrategy(CountDownLatch latch) {
        canvas = new CanvasParameters(800, 800, Color.WHITE);
        shapeParameters.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 13);
        return new SierpinskiShapeAlgorithm(canvas, shapeParameters, algorithm){
            @Override
            public void drawPattern(Graphics g) {
                super.drawPattern(g);
                latch.countDown();
            }
        };

    }
    public static void showSierpinski(CountDownLatch latch){
        context.setStrategy(sierpinskiShapeStrategy(latch));
        context.executeAlgorithm();
        JFrame frame = new JFrame();
        frame.add(context);
        frame.setSize(canvas.getWidth(), canvas.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Version 2: Sierpinski");
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