package unit_test.version3.parameters;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import version3.parameters.CirclePackingParameters;

import java.awt.Color;

public class CirclePackingParametersTest {
    private CirclePackingParameters params;

    @Before
    public void setUp() {
        params = new CirclePackingParameters();
    }

    @Test
    public void testDefaultValues() {
        assertEquals(500, params.canvasWidth);
        assertEquals(500, params.canvasHeight);
        assertEquals(Color.WHITE, params.backgroundColor);
        assertEquals(1, params.animationSpeed);
    }

    @Test
    public void testSetBoundaryType() {
        params.setBoundaryType("square");
        assertEquals("square", params.boundaryType);
    }

    @Test
    public void testSetCentreX() {
        params.setCentreX(300);
        assertEquals(300, params.centreX);
    }

    @Test
    public void testSetCentreY() {
        params.setCentreY(300);
        assertEquals(300, params.centreY);
    }

    @Test
    public void testSetPolygonSize() {
        params.setPolygonSize(150);
        assertEquals(150, params.polygonSize);
    }

    @Test
    public void testSetMinAndMaxRadius() {
        params.setMinRadius(10);
        params.setMaxRadius(30);
        assertEquals(10, params.minRadius);
        assertEquals(30, params.maxRadius);
    }

    @Test
    public void testSetBoundaryFillColour() {
        Color testColor = new Color(255, 0, 0);
        params.setBoundaryFillColour(testColor);
        assertEquals(testColor, params.boundaryFillColour);
    }

    @Test
    public void testSetBoundaryLineColour() {
        Color testColor = new Color(0, 255, 0);
        params.setBoundaryLineColour(testColor);
        assertEquals(testColor, params.boundaryLineColour);
    }

    @Test
    public void testSetBoundaryLineWidth() {
        int lineWidth = 3;
        params.setBoundaryLineWidth(lineWidth);
        assertEquals(lineWidth, params.boundaryLineWidth);
    }

    @Test
    public void testSetCircleFillColour() {
        Color testColor = new Color(0, 0, 255);
        params.setCircleFillColour(testColor);
        assertEquals(testColor, params.circleFillColour);
    }

    @Test
    public void testSetCircleLineColour() {
        Color testColor = new Color(255, 255, 0);
        params.setCircleLineColour(testColor);
        assertEquals(testColor, params.circleLineColour);
    }

    @Test
    public void testSetCircleLineWidth() {
        int lineWidth = 2;
        params.setCircleLineWidth(lineWidth);
        assertEquals(lineWidth, params.circleLineWidth);
    }

    @Test
    public void testSetMaxAttempts() {
        int maxAttempts = 150;
        params.setMaxAttempts(maxAttempts);
        assertEquals(maxAttempts, params.maxAttempts);
    }
}
