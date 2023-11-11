package unit_test.parameters;
import org.junit.Test;
import parameters.CanvasParameters;

import java.awt.*;

import static org.junit.Assert.*;

public class CanvasParametersTest {

    @Test
    public void testConstructorAndGetters() {
        Color testColor = new Color(255, 0, 0); // Example color
        CanvasParameters params = new CanvasParameters(100, 200, testColor);
        assertEquals(100, params.getHeight());
        assertEquals(200, params.getWidth());
        assertEquals(testColor, params.getBackgroundColour());
    }

    @Test
    public void testSetters() {
        Color testColor = new Color(255, 0, 0);
        CanvasParameters params = new CanvasParameters(100, 200, testColor);

        params.setHeight(300);
        params.setWidth(400);
        Color newColor = new Color(0, 255, 0);
        params.setBackgroundColour(newColor);

        assertEquals(300, params.getHeight());
        assertEquals(400, params.getWidth());
        assertEquals(newColor, params.getBackgroundColour());
    }

    @Test
    public void testValidateParametersValid() {
        CanvasParameters params = new CanvasParameters(100, 200, Color.WHITE);
        assertTrue(params.validateParameters());
    }

    @Test
    public void testValidateParametersInvalid() {
        CanvasParameters params = new CanvasParameters(-100, 200, Color.WHITE);
        assertFalse(params.validateParameters());

        params = new CanvasParameters(100, -200, Color.WHITE);
        assertFalse(params.validateParameters());

        params = new CanvasParameters(100, 200, null);
        assertFalse(params.validateParameters());
    }

    @Test
    public void testCopy() {
        Color testColor = new Color(255, 0, 0);
        CanvasParameters original = new CanvasParameters(100, 200, testColor);
        CanvasParameters copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original.getHeight(), copy.getHeight());
        assertEquals(original.getWidth(), copy.getWidth());
        assertEquals(original.getBackgroundColour(), copy.getBackgroundColour());
    }

    @Test
    public void testEquals() {
        Color color1 = new Color(255, 0, 0);
        Color color2 = new Color(0, 255, 0);

        CanvasParameters params1 = new CanvasParameters(100, 200, color1);
        CanvasParameters params2 = new CanvasParameters(100, 200, color1);
        CanvasParameters params3 = new CanvasParameters(100, 200, color2);
        CanvasParameters params4 = new CanvasParameters(300, 400, color1);

        assertEquals(params1, params2);
        assertNotEquals(params1, params3);
        assertNotEquals(params1, params4);
    }
}