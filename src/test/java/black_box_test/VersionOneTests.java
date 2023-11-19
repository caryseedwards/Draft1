package black_box_test;

import withoutgof.algorithms.CirclePacking;
import withoutgof.algorithms.RecursiveShape;
import withoutgof.algorithms.SierpinskiShape;
import withoutgof.parameters.*;

import javax.swing.*;
import java.awt.*;

public class VersionOneTests {
    public static void showRecursiveShape(){
        JFrame frame = new JFrame("Version 1: Recursive Shape");
        RecursiveShapeParameters rsParameters = new RecursiveShapeParameters();
        rsParameters = new RecursiveShapeParameters();
        rsParameters.canvasSizeX = 500;
        rsParameters.canvasSizeY = 500;
        rsParameters.setDepth(6);
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
        RecursiveShape pattern = new RecursiveShape(rsParameters);
        frame.add(pattern);
        frame.setSize(rsParameters.canvasSizeX, rsParameters.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void showCirclePacking(){
        JFrame frame = new JFrame("Version 1: Circle Packing");
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
        cpParameters.setMaxRadius(50);
        cpParameters.setMinRadius(5);
        cpParameters.setMaxAttempts(100);
        cpParameters.setPolygonSize(100);
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

    public static void showSierpinskiShape(){
        JFrame frame = new JFrame("Version 1: Sierpinski");
        SierpinskiShapeParameters ssParameters = new SierpinskiShapeParameters();
        ssParameters.setCentreX(400);
        ssParameters.setCentreY(1200);
        ssParameters.setPolygonSize(400);
        ssParameters.setDepth(5);
        ssParameters.setShapeType("triangle");
        ssParameters.setShapeFillColour(Color.WHITE);
        ssParameters.setShapeLineColour(Color.BLACK);
        ssParameters.setShapeLineWidth(2);
        SierpinskiShape pattern = new SierpinskiShape(ssParameters);
        frame.add(pattern);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        showRecursiveShape();
        Thread.sleep(1000);
        showCirclePacking();
        Thread.sleep(1000);
        showSierpinskiShape();
    }
}
