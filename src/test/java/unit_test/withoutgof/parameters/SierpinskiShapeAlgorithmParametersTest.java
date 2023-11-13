package unit_test.withoutgof.parameters;

import org.junit.Test;
import withoutgof.parameters.SierpinskiShapeAlgorithmParameters;

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
}
