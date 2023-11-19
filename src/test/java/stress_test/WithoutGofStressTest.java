package stress_test;

import org.junit.Test;
import withoutgof.algorithms.CirclePacking;
import withoutgof.algorithms.RecursiveShape;
import withoutgof.algorithms.SierpinskiShape;
import withoutgof.parameters.*;

import javax.swing.*;
import java.awt.*;

public class WithoutGofStressTest {
    JFrame frame;
    RecursiveShapeParameters rsParameters;
    CirclePackingParameters cpParameters;
    SierpinskiShapeParameters ssParameters;

    public void setupRecursiveShape(){
        frame = new JFrame("Version 1: Recursive Shape");
        rsParameters = new RecursiveShapeParameters();
        rsParameters.canvasSizeX = 1000;
        rsParameters.canvasSizeY = 1000;
        rsParameters.setDepth(10);
        rsParameters.setInitialRadius(100);
        rsParameters.setNumShapes(5);
        rsParameters.setLargeShapeType("square");
        rsParameters.setLargeShapeFillColor(Color.GRAY);
        rsParameters.setLargeShapeLineColor(Color.BLACK);
        rsParameters.setLargeShapeLineWidth(1);
        rsParameters.setSmallShapeType("hexagon");
        rsParameters.setSmallShapeFillColor(Color.BLUE);
        rsParameters.setSmallShapeLineColor(Color.BLACK);
        rsParameters.setSmallShapeLineWidth(1);
        rsParameters.backgroundColor = Color.WHITE;
        rsParameters.setCenterX(500);
        rsParameters.setCenterY(500);
    }

    @Test
    public void stressRecursiveShapeDepth(){
        setupRecursiveShape();
        rsParameters.setDepth(10);
        RecursiveShape pattern = new RecursiveShape(rsParameters);
        frame.add(pattern);
        frame.setSize(rsParameters.canvasSizeX, rsParameters.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Test
    public void stressRecursiveShapeNumShapes(){
        setupRecursiveShape();
        rsParameters.setNumShapes(10);
        RecursiveShape pattern = new RecursiveShape(rsParameters);
        frame.add(pattern);
        frame.setSize(rsParameters.canvasSizeX, rsParameters.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Test
    public void stressRecursiveShapeInitialSize(){
        setupRecursiveShape();
        rsParameters.setInitialRadius(100);
        RecursiveShape pattern = new RecursiveShape(rsParameters);
        frame.add(pattern);
        frame.setSize(rsParameters.canvasSizeX, rsParameters.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setupCirclePacking(){
        frame = new JFrame("Version 1: Circle Packing");
        cpParameters = new CirclePackingParameters();
        cpParameters = new CirclePackingParameters();
        cpParameters.canvasWidth = 1000;
        cpParameters.canvasHeight = 1000;
        cpParameters.setCentreX(500);
        cpParameters.setCentreY(500);
        cpParameters.setBoundaryType("circle");
        cpParameters.setBoundaryFillColour(Color.GREEN);
        cpParameters.setBoundaryLineColour(Color.BLACK);
        cpParameters.setCircleFillColour(Color.PINK);
        cpParameters.setCircleLineColour(Color.BLACK);
        cpParameters.setMaxRadius(2);
        cpParameters.setMinRadius(1);
        cpParameters.setMaxAttempts(1000000);
        cpParameters.setPolygonSize(500);
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
    @Test
    public void stressTestCirclePackingMaxAttempts(){
        setupCirclePacking();
        cpParameters.setMaxAttempts(1000);
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

    @Test
    public void stressTestCirclePackingCanvasSize(){
        setupCirclePacking();
        cpParameters.canvasWidth = 1000;
        cpParameters.canvasHeight = 1000;
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
    @Test
    public void stressTestCirclePackingMinRadius(){
        setupCirclePacking();
        cpParameters.setMinRadius(5);
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

    @Test
    public void stressTestCirclePackingMaxRadius(){
        setupCirclePacking();
        cpParameters.setMaxRadius(50);
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

    public void setupSierpinskiShape(){
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
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

