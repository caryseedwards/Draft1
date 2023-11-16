package unit_test.withoutgof.parameters;

import org.junit.Test;
import template.parameters.RecursiveShapeAlgorithmParameters;

import static org.junit.Assert.*;

public class RecursiveShapeAlgorithmParametersTest {

    @Test
    public void testConstructorAndGetters() {
        RecursiveShapeAlgorithmParameters params = new RecursiveShapeAlgorithmParameters(100, 150, 200, 3, 5);
        assertEquals(100, params.getCenterX());
        assertEquals(150, params.getCenterY());
        assertEquals(200, params.getInitialSize());
        assertEquals(3, params.getDepth());
        assertEquals(5, params.getNumShapes());
    }

    @Test
    public void testSetters() {
        RecursiveShapeAlgorithmParameters params = new RecursiveShapeAlgorithmParameters(100, 150, 200, 3, 5);

        params.setCenterX(200);
        assertEquals(200, params.getCenterX());

        params.setCenterY(250);
        assertEquals(250, params.getCenterY());

        params.setInitialSize(300);
        assertEquals(300, params.getInitialSize());

        params.setDepth(4);
        assertEquals(4, params.getDepth());

        params.setNumShapes(6);
        assertEquals(6, params.getNumShapes());
    }

    @Test
    public void testValidateParametersValid() {
        RecursiveShapeAlgorithmParameters params = new RecursiveShapeAlgorithmParameters(100, 150, 200, 3, 5);
        assertTrue(params.validateParameters());
    }

    @Test
    public void testValidateParametersInvalid() {
        RecursiveShapeAlgorithmParameters params;

        params = new RecursiveShapeAlgorithmParameters(100, 150, -200, 3, 5);
        assertFalse(params.validateParameters());

        params = new RecursiveShapeAlgorithmParameters(100, 150, 200, -3, 5);
        assertFalse(params.validateParameters());

        params = new RecursiveShapeAlgorithmParameters(100, 150, 200, 3, 0);
        assertFalse(params.validateParameters());
    }
}
