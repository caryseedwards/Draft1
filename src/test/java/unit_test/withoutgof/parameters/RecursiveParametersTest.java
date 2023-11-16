package unit_test.withoutgof.parameters;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import withoutgof.parameters.RecursiveShapeParameters;

import java.awt.Color;

public class RecursiveParametersTest {
    private RecursiveShapeParameters params;

    @Before
    public void setUp() {
        params = new RecursiveShapeParameters();
    }

    @Test
    public void testInitialiseUserParameters() {
        params.initialiseUserParameters();
        assertEquals(800, params.canvasSizeX);
        assertEquals(800, params.canvasSizeY);
        assertEquals(Color.WHITE, params.backgroundColor);
        assertEquals("triangle", params.largeShapeType);
        assertEquals(Color.BLACK, params.largeShapeLineColor);
        assertEquals(1, params.largeShapeLineWidth);
        assertEquals(new Color(0, 0, 0, 0), params.largeShapeFillColor);
        assertEquals("solid", params.largeShapeLineType);
        assertEquals("triangle", params.smallShapeType);
        assertEquals(Color.BLACK, params.smallShapeLineColor);
        assertEquals(1, params.smallShapeLineWidth);
        assertEquals(new Color(0, 0, 0, 0), params.smallShapeFillColor);
        assertEquals("solid", params.smallShapeLineType);
        assertEquals(400, params.centerX);
        assertEquals(400, params.centerY);
        assertEquals(150, params.initialSize);
        assertEquals(4, params.depth);
        assertEquals(6, params.numShapes);
    }

    @Test
    public void testSetCenterX() {
        params.setCenterX(250);
        assertEquals(250, params.centerX);
    }

    @Test
    public void testSetCenterY() {
        params.setCenterY(250);
        assertEquals(250, params.centerY);
    }

    @Test
    public void testSetInitialSize() {
        params.setInitialRadius(100);
        assertEquals(100, params.initialSize);
    }

    @Test
    public void testSetDepth() {
        params.setDepth(5);
        assertEquals(5, params.depth);
    }

    @Test
    public void testSetNumShapes() {
        params.setNumShapes(3);
        assertEquals(3, params.numShapes);
    }

    @Test
    public void testSetLargeShapeType() {
        params.setLargeShapeType("square");
        assertEquals("square", params.largeShapeType);
    }

    @Test
    public void testSetLargeShapeLineColor() {
        Color color = Color.BLUE;
        params.setLargeShapeLineColor(color);
        assertEquals(color, params.largeShapeLineColor);
    }

    @Test
    public void testSetLargeShapeLineWidth() {
        params.setLargeShapeLineWidth(2);
        assertEquals(2, params.largeShapeLineWidth);
    }

    @Test
    public void testSetLargeShapeFillColor() {
        Color color = Color.GREEN;
        params.setLargeShapeFillColor(color);
        assertEquals(color, params.largeShapeFillColor);
    }

    @Test
    public void testSetSmallShapeType() {
        params.setSmallShapeType("hexagon");
        assertEquals("hexagon", params.smallShapeType);
    }

    @Test
    public void testSetSmallShapeLineColor() {
        Color color = Color.MAGENTA;
        params.setSmallShapeLineColor(color);
        assertEquals(color, params.smallShapeLineColor);
    }

    @Test
    public void testSetSmallShapeLineWidth() {
        params.setSmallShapeLineWidth(3);
        assertEquals(3, params.smallShapeLineWidth);
    }

    @Test
    public void testSetSmallShapeFillColor() {
        Color color = Color.ORANGE;
        params.setSmallShapeFillColor(color);
        assertEquals(color, params.smallShapeFillColor);
    }
}
