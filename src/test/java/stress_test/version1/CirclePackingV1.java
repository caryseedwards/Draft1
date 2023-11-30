package stress_test.version1;

import version1.algorithms.CirclePackingAlgorithm;
import version1.parameters.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CirclePackingV1 {
    public static CanvasParameters canvasParameters;
    public static ArrayList<ShapeParameters> shapeParameters = new ArrayList<>();
    public static CirclePackingAlgorithmParameters cpParameters;

    public static void showCirclePacking(){
        JFrame frame = new JFrame("Version 1: Circle Packing");
        canvasParameters = new CanvasParameters(500,500,Color.WHITE);
        shapeParameters = new ArrayList<ShapeParameters>();
        shapeParameters.add(new ShapeParameters("circle", 1, Color.GREEN, Color.BLACK));
        shapeParameters.add(new ShapeParameters("circle", 1, Color.PINK, Color.BLACK));
        cpParameters = new CirclePackingAlgorithmParameters(250, 250, 250, 1, 1, 10000, 1);
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

    public static void main(String[] args) throws InterruptedException {
        showCirclePacking();
    }
}
