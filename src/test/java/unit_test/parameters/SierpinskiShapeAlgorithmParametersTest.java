package unit_test.parameters;

import org.junit.Test;
import parameters.SierpinskiShapeAlgorithmParameters;

import static org.junit.Assert.*;

public class SierpinskiShapeAlgorithmParametersTest {

    @Test
    public void testConstructorAndGetters() {
        SierpinskiShapeAlgorithmParameters params = new SierpinskiShapeAlgorithmParameters(100, 150, 200, 3);
        assertEquals(100, params.getCentreX());
        assertEquals(150, params.getCentreY());
        assertEquals(200, params.getPolygonSize());
        assertEquals(3, params.getDepth());
    }

    @Test
    public void testSetters() {
        SierpinskiShapeAlgorithmParameters params = new SierpinskiShapeAlgorithmParameters(100, 150, 200, 3);

        params.setCentreX(200);
        assertEquals(200, params.getCentreX());

        params.setCentreY(250);
        assertEquals(250, params.getCentreY());

        params.setPolygonSize(300);
        assertEquals(300, params.getPolygonSize());

        params.setDepth(4);
        assertEquals(4, params.getDepth());
    }

    @Test
    public void testValidateParametersValid() {
        SierpinskiShapeAlgorithmParameters params = new SierpinskiShapeAlgorithmParameters(100, 150, 200, 3);
        assertTrue(params.validateParameters());
    }

    @Test
    public void testValidateParametersInvalid() {
        SierpinskiShapeAlgorithmParameters params;

        params = new SierpinskiShapeAlgorithmParameters(-100, 150, 200, 3);
        assertFalse(params.validateParameters());

        params = new SierpinskiShapeAlgorithmParameters(100, -150, 200, 3);
        assertFalse(params.validateParameters());

        params = new SierpinskiShapeAlgorithmParameters(100, 150, -200, 3);
        assertFalse(params.validateParameters());

        params = new SierpinskiShapeAlgorithmParameters(100, 150, 200, -3);
        assertFalse(params.validateParameters());
    }

    @Test
    public void testCopy() {
        SierpinskiShapeAlgorithmParameters original = new SierpinskiShapeAlgorithmParameters(100, 150, 200, 3);
        SierpinskiShapeAlgorithmParameters copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original.getCentreX(), copy.getCentreX());
        assertEquals(original.getCentreY(), copy.getCentreY());
        assertEquals(original.getPolygonSize(), copy.getPolygonSize());
        assertEquals(original.getDepth(), copy.getDepth());
    }

    @Test
    public void testEquals() {
        SierpinskiShapeAlgorithmParameters params1 = new SierpinskiShapeAlgorithmParameters(100, 150, 200, 3);
        SierpinskiShapeAlgorithmParameters params2 = new SierpinskiShapeAlgorithmParameters(100, 150, 200, 3);
        SierpinskiShapeAlgorithmParameters params3 = new SierpinskiShapeAlgorithmParameters(200, 250, 300, 4);

        assertEquals(params1, params2);
        assertNotEquals(params1, params3);
    }

    // Additional edge cases and scenarios as needed...
}
