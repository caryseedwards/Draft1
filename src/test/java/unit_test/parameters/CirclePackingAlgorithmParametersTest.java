package unit_test.parameters;

import org.junit.Test;
import static org.junit.Assert.*;
import parameters.CirclePackingAlgorithmParameters;

public class CirclePackingAlgorithmParametersTest {

    @Test
    public void testConstructorAndGetters() {
        CirclePackingAlgorithmParameters params = new CirclePackingAlgorithmParameters(100, 150, 200, 5, 10, 50, 2);
        assertEquals(100, params.getCentreX());
        assertEquals(150, params.getCentreY());
        assertEquals(200, params.getPolygonSize());
        assertEquals(5, params.getMinRadius());
        assertEquals(10, params.getMaxRadius());
        assertEquals(50, params.getMaxAttempts());
        assertEquals(2, params.getAnimationSpeed());
    }

    @Test
    public void testSetters() {
        CirclePackingAlgorithmParameters params = new CirclePackingAlgorithmParameters(100, 150, 200, 5, 10, 50, 2);

        params.setCentreX(200);
        assertEquals(200, params.getCentreX());

        params.setCentreY(250);
        assertEquals(250, params.getCentreY());

        params.setPolygonSize(300);
        assertEquals(300, params.getPolygonSize());

        params.setMinRadius(6);
        assertEquals(6, params.getMinRadius());

        params.setMaxRadius(12);
        assertEquals(12, params.getMaxRadius());

        params.setMaxAttempts(60);
        assertEquals(60, params.getMaxAttempts());

        params.setAnimationSpeed(3);
        assertEquals(3, params.getAnimationSpeed());
    }

    @Test
    public void testValidateParametersValid() {
        CirclePackingAlgorithmParameters params = new CirclePackingAlgorithmParameters(100, 150, 200, 5, 10, 50, 2);
        assertTrue(params.validateParameters());
    }

    @Test
    public void testValidateParametersInvalid() {
        CirclePackingAlgorithmParameters params;

        params = new CirclePackingAlgorithmParameters(100, 150, 200, -5, 10, 50, 2);
        assertFalse(params.validateParameters());

        params = new CirclePackingAlgorithmParameters(100, 150, 200, 10, 5, 50, 2);
        assertFalse(params.validateParameters());

        params = new CirclePackingAlgorithmParameters(100, 150, 200, 5, 10, -50, 2);
        assertFalse(params.validateParameters());

        params = new CirclePackingAlgorithmParameters(100, 150, 200, 5, 10, 50, 0);
        assertFalse(params.validateParameters());
    }
}