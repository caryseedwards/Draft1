package unit_test.withoutgof.algorithms;

import static org.junit.Assert.*;
import org.junit.Test;
import withoutgof.algorithms.SierpinskiShape;
import withoutgof.parameters.SierpinskiShapeParameters;

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
