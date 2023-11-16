package unit_test.withoutgof.parameters;
import org.junit.Test;
import template.parameters.CanvasParameters;

import java.awt.*;

import static org.junit.Assert.*;

public class CanvasParametersTest {

    @Test
    public void testConstructorAndGetters() {
        Color testColor = new Color(255, 0, 0);
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
}