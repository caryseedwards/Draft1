package stress_test.version3;

import version3.algorithms.CirclePacking;
import version3.parameters.CirclePackingParameters;

import javax.swing.*;
import java.awt.*;

public class CirclePackingV3 {
    public static void showCirclePacking(){
        JFrame frame = new JFrame("Version 3: Circle Packing");
        CirclePackingParameters cpParameters = new CirclePackingParameters();
        cpParameters = new CirclePackingParameters();
        cpParameters.canvasWidth = 500;
        cpParameters.canvasHeight = 500;
        cpParameters.setCentreX(250);
        cpParameters.setCentreY(250);
        cpParameters.setBoundaryType("circle");
        cpParameters.setBoundaryFillColour(Color.GREEN);
        cpParameters.setBoundaryLineColour(Color.BLACK);
        cpParameters.setCircleFillColour(Color.PINK);
        cpParameters.setCircleLineColour(Color.BLACK);
        cpParameters.setMaxRadius(1);
        cpParameters.setMinRadius(1);
        cpParameters.setMaxAttempts(10000);
        cpParameters.setPolygonSize(250);
        CirclePacking pattern = new CirclePacking(cpParameters);
        frame.add(pattern);
        frame.setSize(cpParameters.canvasWidth, cpParameters.canvasHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Timer timer = new Timer(1, e -> {
            pattern.addCircle();
            pattern.repaint();
        });
        timer.start();
    }

    public static void main(String[] args) {
        showCirclePacking();
    }
}
