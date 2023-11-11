package unit_test.parameters;

import org.junit.Test;
import parameters.ShapeParameters;
import static org.junit.Assert.*;
import java.awt.*;

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

    @Test
    public void testCopy() {
        Color lineColor = new Color(0, 0, 255);
        Color fillColor = new Color(0, 255, 0);
        ShapeParameters original = new ShapeParameters("circle", 1.0f, lineColor, fillColor);
        ShapeParameters copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original.getShapeType(), copy.getShapeType());
        assertEquals(original.getLineWidth(), copy.getLineWidth(), 0.0f);
        assertEquals(original.getLineColour(), copy.getLineColour());
        assertEquals(original.getFillColour(), copy.getFillColour());
    }

    @Test
    public void testEquals() {
        Color lineColor1 = new Color(0, 0, 255);
        Color fillColor1 = new Color(0, 255, 0);
        Color lineColor2 = new Color(255, 0, 0);
        Color fillColor2 = new Color(0, 255, 255);

        ShapeParameters params1 = new ShapeParameters("circle", 1.0f, lineColor1, fillColor1);
        ShapeParameters params2 = new ShapeParameters("circle", 1.0f, lineColor1, fillColor1);
        ShapeParameters params3 = new ShapeParameters("square", 1.0f, lineColor2, fillColor2);
        ShapeParameters params4 = new ShapeParameters("circle", 2.0f, lineColor1, fillColor1);

        assertEquals(params1, params2);
        assertNotEquals(params1, params3);
        assertNotEquals(params1, params4);
    }
}