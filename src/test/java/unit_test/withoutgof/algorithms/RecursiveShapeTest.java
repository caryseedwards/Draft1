package unit_test.withoutgof.algorithms;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import withoutgof.algorithms.RecursiveShape;
import withoutgof.parameters.RecursiveShapeParameters;
import withoutgof.shapes.*;

public class RecursiveShapeTest {
    private RecursiveShape recursiveShape;
    private RecursiveShapeParameters params;

    @Before
    public void setUp() {
        params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        recursiveShape = new RecursiveShape(params);
    }

    @Test
    public void testConstructor() {
        assertNotNull("RecursiveShape instance should not be null", recursiveShape);
    }

    @Test
    public void testInitialiseLargeShape() {
        params.largeShapeType = "circle";
        recursiveShape = new RecursiveShape(params);
        assertTrue("Large shape should be Circle", recursiveShape.getLargeShape() instanceof Circle);

        params.largeShapeType = "square";
        recursiveShape = new RecursiveShape(params);
        assertTrue("Large shape should be Square", recursiveShape.getLargeShape() instanceof Square);
    }

    @Test
    public void testInitialiseSmallShape() {
        params.smallShapeType = "circle";
        recursiveShape = new RecursiveShape(params);
        assertTrue("Small shape should be Circle", recursiveShape.getSmallShape() instanceof Circle);

        params.smallShapeType = "square";
        recursiveShape = new RecursiveShape(params);
        assertTrue("Small shape should be Square", recursiveShape.getSmallShape() instanceof Square);
    }

    @Test
    public void testShapeTypes() {
        String[] shapeTypes = {"circle", "square", "triangle", "hexagon"};
        for (String type : shapeTypes) {
            params.largeShapeType = type;
            params.smallShapeType = type;
            recursiveShape = new RecursiveShape(params);

            String message = String.format("Shape type %s should be initialized correctly", type);
            assertTrue(message, recursiveShape.getLargeShape().getClass().getSimpleName().toLowerCase().contains(type));
            assertTrue(message, recursiveShape.getSmallShape().getClass().getSimpleName().toLowerCase().contains(type));
        }
    }
}
