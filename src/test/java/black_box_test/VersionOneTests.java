package black_box_test;

import org.junit.Test;
import withoutgof.algorithms.CirclePacking;
import withoutgof.algorithms.RecursiveShape;
import withoutgof.algorithms.SierpinskiShape;
import withoutgof.parameters.*;

import javax.swing.*;
import java.awt.*;

public class VersionOneTests {
    JFrame frame;
    RecursiveShapeParameters rsParameters;
    CirclePackingParameters cpParameters;
    SierpinskiShapeParameters ssParameters;
@Test
    public void testRecursiveShape(){
        frame = new JFrame("Recursive Shape Test");
        rsParameters = new RecursiveShapeParameters();
        rsParameters.canvasSizeX = 600;
        rsParameters.canvasSizeY = 600;
        rsParameters.backgroundColor = Color.WHITE;
        rsParameters.setCenterX(50);
        rsParameters.setCenterY(50);
        rsParameters.setDepth(6);
        rsParameters.setInitialRadius(100);
        rsParameters.setNumShapes(4);
        rsParameters.setLargeShapeType("squares");
        rsParameters.setLargeShapeFillColor(Color.GRAY);
        rsParameters.setLargeShapeLineColor(Color.BLACK);
        rsParameters.setSmallShapeType("hexagons");
        rsParameters.setSmallShapeFillColor(Color.BLUE);
        rsParameters.setLargeShapeLineColor(Color.BLACK);
        RecursiveShape pattern = new RecursiveShape(rsParameters);
        frame.add(pattern);
        frame.setSize(rsParameters.canvasSizeX, rsParameters.canvasSizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Test
    public void testCirclePacking(){
        frame = new JFrame("Circle Packing Test");
        cpParameters = new CirclePackingParameters();
        cpParameters.canvasWidth = 500;
        cpParameters.canvasHeight = 500;
        cpParameters.setCentreX(200);
        cpParameters.setCentreY(200);
        cpParameters.setBoundaryType("circle");
        cpParameters.setBoundaryFillColour(Color.DARK_GRAY);
        cpParameters.setBoundaryLineColour(Color.GREEN);
        cpParameters.setCircleFillColour(Color.PINK);
        cpParameters.setCircleLineColour(Color.MAGENTA);
        cpParameters.setMaxRadius(30);
        cpParameters.setMinRadius(5);
        cpParameters.setMaxAttempts(10000);
        cpParameters.setPolygonSize(600);
        CirclePacking pattern = new CirclePacking(cpParameters);
        frame.add(pattern);
        frame.setSize(cpParameters.canvasWidth, cpParameters.canvasHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Test
    public void testSierpinskiShape(){
        frame = new JFrame("Sierpinski Test");
        ssParameters = new SierpinskiShapeParameters();
        ssParameters.setCentreX(500);
        ssParameters.setCentreY(500);
        ssParameters.setPolygonSize(500);
        ssParameters.setDepth(5);
        ssParameters.setShapeType("triangle");
        ssParameters.setShapeFillColour(Color.WHITE);
        ssParameters.setShapeLineColour(Color.BLACK);
        ssParameters.setShapeLineWidth(2);
        SierpinskiShape pattern = new SierpinskiShape(ssParameters);
        frame.add(pattern);
        frame.setSize((ssParameters.centreX*2), (ssParameters.centreY*2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
