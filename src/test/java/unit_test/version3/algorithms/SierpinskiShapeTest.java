package unit_test.version3.algorithms;

import static org.junit.Assert.*;
import org.junit.Test;
import version3.algorithms.SierpinskiShape;
import version3.parameters.SierpinskiShapeParameters;

public class SierpinskiShapeTest {

    @Test
    public void testConstructorAndParameterInitialization() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.centreX = 100;
        params.centreY = 100;
        params.polygonSize = 200;
        params.depth = 3;
        params.shapeType = "triangle";
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        assertNotNull("SierpinskiShape instance should not be null", sierpinskiShape);
        assertEquals("Parameters should match", params, sierpinskiShape.getParams());
    }
}
