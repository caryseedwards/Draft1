package unit_test.strategyandfactory.parameters;

import org.junit.Test;
import strategyandfactory.parameters.ShapeParameters;

import java.awt.*;

import static org.junit.Assert.*;

public class ShapeParametersTest {

    @Test
    public void testConstructorAndGetters() {
        Color lineColor = new Color(0, 0, 255);
        Color fillColor = new Color(0, 255, 0);
        ShapeParameters params = new ShapeParameters("circle", 1.0f, lineColor, fillColor);

        assertEquals("circle", params.getShapeType());
        assertEquals(1.0f, params.getLineWidth(), 0.0f);
        assertEquals(lineColor, params.getLineColour());
        assertEquals(fillColor, params.getFillColour());
    }

    @Test
    public void testSetters() {
        Color lineColor = new Color(0, 0, 255);
        Color fillColor = new Color(0, 255, 0);
        ShapeParameters params = new ShapeParameters("circle", 1.0f, lineColor, fillColor);

        params.setShapeType("square");
        params.setLineWidth(2.0f);
        Color newLineColor = new Color(255, 0, 0);
        Color newFillColor = new Color(0, 255, 255);
        params.setLineColour(newLineColor);
        params.setFillColour(newFillColor);

        assertEquals("square", params.getShapeType());
        assertEquals(2.0f, params.getLineWidth(), 0.0f);
        assertEquals(newLineColor, params.getLineColour());
        assertEquals(newFillColor, params.getFillColour());
    }

    @Test
    public void testValidateParametersValid() {
        ShapeParameters params = new ShapeParameters("rectangle", 1.0f, Color.BLACK, Color.WHITE);
        assertTrue(params.validateParameters());
    }

    @Test
    public void testValidateParametersInvalid() {
        ShapeParameters params = new ShapeParameters(null, 1.0f, Color.BLACK, Color.WHITE);
        assertFalse(params.validateParameters());

        params = new ShapeParameters("circle", -1.0f, Color.BLACK, Color.WHITE);
        assertFalse(params.validateParameters());

        params = new ShapeParameters("circle", 1.0f, null, Color.WHITE);
        assertFalse(params.validateParameters());
    }
}