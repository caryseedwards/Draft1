package unit_test.algorithms;

import static org.junit.Assert.*;

import algorithms.CirclePacking;
import org.junit.Test;
import parameters.CirclePackingParameters;
import shapes.Circle;
import shapes.Hexagon;
import shapes.Square;

public class CirclePackingTest {
    @Test
    public void testSetBoundaryCircle() {
        CirclePackingParameters params = new CirclePackingParameters();
        params.boundaryType = "circle";
        CirclePacking packing = new CirclePacking(params);
        packing.setBoundary("circle");
        assertTrue(packing.getBoundaryShape() instanceof Circle);
    }

    @Test
    public void testCirclePackingConstructor() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        assertNotNull(packing.getBoundaryShape());
        assertFalse(packing.getCircles().isEmpty());
    }

    @Test
    public void testSetBoundarySquare() {
        CirclePackingParameters params = new CirclePackingParameters();
        params.boundaryType = "square";
        CirclePacking packing = new CirclePacking(params);

        packing.setBoundary("square");
        assertTrue(packing.getBoundaryShape() instanceof Square);
    }

    @Test
    public void testAddCircleWithinBoundary() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        packing.addCircle();
        assertTrue(packing.getCircles().stream().allMatch(circle ->
                packing.getBoundaryShape().isInside(circle)));
    }

    @Test
    public void testNoOverlappingCircles() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        packing.addCircle();
        for (int i = 0; i < packing.getCircles().size(); i++) {
            for (int j = i + 1; j < packing.getCircles().size(); j++) {
                assertFalse(packing.getCircles().get(i).overlaps(packing.getCircles().get(j)));
            }
        }
    }

    @Test
    public void testBoundaryAndCircleIntegration() {
        CirclePackingParameters params = new CirclePackingParameters();
        params.boundaryType = "hexagon";
        CirclePacking packing = new CirclePacking(params);

        packing.setBoundary("hexagon");
        packing.addCircle();

        assertTrue(packing.getBoundaryShape() instanceof Hexagon);
        assertFalse(packing.getCircles().isEmpty());
        assertTrue(packing.getCircles().stream().allMatch(circle ->
                packing.getBoundaryShape().isInside(circle)));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetBoundaryWithInvalidType() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);
        packing.setBoundary("invalidType");
    }


    @Test
    public void testCirclePlacement() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        packing.addCircle();
        Circle lastAddedCircle = packing.getCircles().get(packing.getCircles().size() - 1);
        assertTrue(packing.getBoundaryShape().isInside(lastAddedCircle));
    }

    @Test
    public void testCircleRadius() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        packing.addCircle();
        for (Circle circle : packing.getCircles()) {
            assertTrue(circle.getRadius() >= params.minRadius && circle.getRadius() <= params.maxRadius);
        }
    }

    @Test
    public void testParameterUpdates() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        params.setBoundaryType("square");
        packing.setBoundary(params.boundaryType);
        assertTrue(packing.getBoundaryShape() instanceof Square);
    }

    @Test
    public void testParameterModification() {
        CirclePackingParameters params = new CirclePackingParameters();
        params.setMinRadius(10);
        params.setMaxRadius(20);
        CirclePacking packing = new CirclePacking(params);

        packing.addCircle();
        for (Circle circle : packing.getCircles()) {
            assertTrue(circle.getRadius() >= 10 && circle.getRadius() <= 20);
        }
    }

    @Test
    public void testRepetitiveSetBoundaryCalls() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        packing.setBoundary("circle");
        assertTrue(packing.getBoundaryShape() instanceof Circle);

        packing.setBoundary("square");
        assertTrue(packing.getBoundaryShape() instanceof Square);
    }

    @Test
    public void testCircleCountAfterMultipleAdditions() {
        CirclePackingParameters params = new CirclePackingParameters();
        CirclePacking packing = new CirclePacking(params);

        int initialCount = packing.getCircles().size();
        packing.addCircle(); // Call multiple times as needed
        assertTrue(packing.getCircles().size() > initialCount);
    }
}