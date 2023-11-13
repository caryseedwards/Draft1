package unit_test.withoutgof.algorithms;

import withoutgof.algorithms.SierpinskiShapeAlgorithm;
import org.junit.Test;
import withoutgof.parameters.CanvasParameters;
import withoutgof.parameters.ShapeParameters;
import withoutgof.parameters.SierpinskiShapeAlgorithmParameters;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SierpinskiShapeAlgorithmTest {
    private SierpinskiShapeAlgorithm createTestInstance() {
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);

        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }
    private SierpinskiShapeAlgorithm createTestInstanceWithShapeType(String shapeType) {
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters(shapeType, 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);

        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }

    @Test
    public void testInitialisation() {
        SierpinskiShapeAlgorithm sierpinski = createTestInstance();
        assertNotNull("Algorithm should have been initialized", sierpinski);
    }
    @Test
    public void testInitialisationWithDifferentShapes() {
        String[] shapeTypes = {"triangle", "circle", "square", "hexagon"};
        for (String shapeType : shapeTypes) {
            SierpinskiShapeAlgorithm sierpinski = createTestInstanceWithShapeType(shapeType);
            assertNotNull("Algorithm should be initialized for shape type: " + shapeType, sierpinski);
        }
    }
    @Test
    public void testInitialisationWithInvalidShape() {
        assertThrows(IllegalArgumentException.class, () -> createTestInstanceWithShapeType("invalidShape"));
    }
    @Test
    public void testParameterValidation() {
        SierpinskiShapeAlgorithm sierpinski = createTestInstance();
        SierpinskiShapeAlgorithmParameters testParams = new SierpinskiShapeAlgorithmParameters(20,20,20,3);
        sierpinski.setAlgorithmParams(testParams);
        assertTrue("Valid parameters should pass validation", sierpinski.validateParameters());

        // Test with invalid parameters
        testParams.setDepth(-1);
        assertFalse("Invalid parameters should fail validation", sierpinski.validateParameters());
    }
}
