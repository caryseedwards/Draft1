package unit_test.withoutgof.parameters;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import withoutgof.parameters.SierpinskiShapeParameters;

import java.awt.Color;

public class SierpinskiParametersTest {
    private SierpinskiShapeParameters params;

    @Before
    public void setUp() {
        params = new SierpinskiShapeParameters();
    }

    @Test
    public void testSetCentreX() {
        params.setCentreX(150);
        assertEquals(150, params.centreX);
    }

    @Test
    public void testSetCentreY() {
        params.setCentreY(150);
        assertEquals(150, params.centreY);
    }

    @Test
    public void testSetPolygonSize() {
        params.setPolygonSize(200);
        assertEquals(200, params.polygonSize);
    }

    @Test
    public void testSetDepth() {
        params.setDepth(3);
        assertEquals(3, params.depth);
    }

    @Test
    public void testSetShapeType() {
        params.setShapeType("circle");
        assertEquals("circle", params.shapeType);
    }

    @Test
    public void testSetShapeFillColour() {
        Color fillColour = Color.BLUE;
        params.setShapeFillColour(fillColour);
        assertEquals(fillColour, params.shapeFillColour);
    }

    @Test
    public void testSetShapeLineColour() {
        Color lineColour = Color.RED;
        params.setShapeLineColour(lineColour);
        assertEquals(lineColour, params.shapeLineColour);
    }

    @Test
    public void testSetShapeLineWidth() {
        params.setShapeLineWidth(2);
        assertEquals(2, params.shapeLineWidth);
    }

    @Test
    public void testDefaultValues() {
        assertEquals(0, params.centreX);
        assertEquals(0, params.centreY);
        assertEquals(0, params.polygonSize);
        assertEquals(0, params.depth);
        assertNull(params.shapeType);
        assertNull(params.shapeFillColour);
        assertNull(params.shapeLineColour);
        assertEquals(0, params.shapeLineWidth);
    }

    @Test
    public void testSetNegativePolygonSize() {
        params.setPolygonSize(-100);
        assertEquals(-100, params.polygonSize);
    }

    @Test
    public void testSetInvalidShapeType() {
        params.setShapeType("nonExistingShapeType");
        assertEquals("nonExistingShapeType", params.shapeType);
    }

    @Test
    public void testSetZeroLineWidth() {
        params.setShapeLineWidth(0);
        assertEquals(0, params.shapeLineWidth);
    }
}
