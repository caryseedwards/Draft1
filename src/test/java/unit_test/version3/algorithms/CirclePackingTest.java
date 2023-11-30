package unit_test.version3.algorithms;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import version3.algorithms.CirclePacking;
import version3.parameters.CirclePackingParameters;
import version3.shapes.*;

public class CirclePackingTest {
    private CirclePacking circlePacking;
    private CirclePackingParameters params;

    @Before
    public void setUp() {
        params = new CirclePackingParameters();
        circlePacking = new CirclePacking(params);
    }

    @Test
    public void testConstructor() {
        assertNotNull("CirclePacking instance should not be null", circlePacking);
    }

    @Test
    public void testSetBoundaryCircle() {
        circlePacking.setBoundary("circle");
        assertTrue("Boundary shape should be Circle", circlePacking.getBoundaryShape() instanceof Circle);
    }

    @Test
    public void testSetBoundarySquare() {
        circlePacking.setBoundary("square");
        assertTrue("Boundary shape should be Square", circlePacking.getBoundaryShape() instanceof Square);
    }

    @Test
    public void testSetBoundaryTriangle() {
        circlePacking.setBoundary("triangle");
        assertTrue("Boundary shape should be Triangle", circlePacking.getBoundaryShape() instanceof Triangle);
    }

    @Test
    public void testSetBoundaryHexagon() {
        circlePacking.setBoundary("hexagon");
        assertTrue("Boundary shape should be Hexagon", circlePacking.getBoundaryShape() instanceof Hexagon);
    }

    @Test
    public void testAddCircle() {
        int initialSize = circlePacking.getCircles().size();
        circlePacking.addCircle();
        assertTrue("Circles list should grow after adding a circle", circlePacking.getCircles().size() > initialSize);
    }

    @Test
    public void testCirclesWithinBoundary() {
        circlePacking.addCircle();
        boolean allInside = circlePacking.getCircles().stream().allMatch(circle -> circlePacking.getBoundaryShape().isInside(circle));
        assertTrue("All circles should be inside the boundary", allInside);
    }

    @Test
    public void testNoOverlap() {
        circlePacking.addCircle();
        for (int i = 0; i < circlePacking.getCircles().size(); i++) {
            for (int j = i + 1; j < circlePacking.getCircles().size(); j++) {
                assertFalse("Circles should not overlap", circlePacking.getCircles().get(i).overlaps(circlePacking.getCircles().get(j)));
            }
        }
    }
}
