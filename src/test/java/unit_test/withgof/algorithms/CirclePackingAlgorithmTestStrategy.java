package unit_test.withgof.algorithms;

import org.junit.Test;
import withgof.algorithms.CirclePackingAlgorithm;
import withgof.parameters.CanvasParameters;
import withgof.parameters.CirclePackingAlgorithmParameters;
import withgof.parameters.ShapeParameters;
import withgof.shapes.Circle;
import withgof.shapes.Hexagon;
import withgof.shapes.Square;
import withgof.shapes.Triangle;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CirclePackingAlgorithmTestStrategy {
    CanvasParameters canvas;
    ArrayList<ShapeParameters> shapes;
    CirclePackingAlgorithmParameters algorithm;

    private CirclePackingAlgorithm createTestInstance() {
        canvas = new CanvasParameters(500, 500, Color.WHITE);
        shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        algorithm = new CirclePackingAlgorithmParameters(250, 250, 200, 5, 50, 100, 1);

        return new CirclePackingAlgorithm(canvas, shapes, algorithm);
    }
    @Test
    public void testInitializationAndBoundaryShape() {
        CirclePackingAlgorithm packing = createTestInstance();
        assertNotNull("Boundary shape should be initialized", packing.getBoundaryShape());
    }
    @Test
    public void testCirclePackingConstructor() {
        CirclePackingAlgorithm packing = createTestInstance();
        assertNotNull(packing.getBoundaryShape());
        assertTrue(packing.getCircles().isEmpty());
    }

    @Test
    public void testSetBoundaryCircle() {
        CirclePackingAlgorithm packing = createTestInstance();
        assertTrue(packing.getBoundaryShape() instanceof Circle);
    }
    @Test
    public void testSetBoundarySquare() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.setBoundaryShape("square");
        assertTrue(packing.getBoundaryShape() instanceof Square);
    }
    @Test
    public void testRepetitiveSetBoundaryCalls() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.setBoundaryShape("triangle");
        assertTrue(packing.getBoundaryShape() instanceof Triangle);

        packing.setBoundaryShape("hexagon");
        assertTrue(packing.getBoundaryShape() instanceof Hexagon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBoundaryType() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.setBoundaryShape("invalidType");
    }

    @Test
    public void testAddCircle() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.addCircles();
        assertFalse("Circles list should not be empty after adding circles", packing.getCircles().isEmpty());
        assertTrue("All circles should be inside the boundary",
                packing.getCircles().stream().allMatch(circle -> packing.getBoundaryShape().isInside(circle)));
    }
    @Test
    public void testCircleCountAfterMultipleAdditions() {
        CirclePackingAlgorithm packing = createTestInstance();
        int initialCount = packing.getCircles().size();
        packing.addCircles(); // Call multiple times as needed
        assertTrue(packing.getCircles().size() > initialCount);
    }
    @Test
    public void testParameterModification() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.getAlgorithmParameters().setMinRadius(10);
        packing.getAlgorithmParameters().setMaxRadius(20);
        packing.addCircles();
        for (Circle circle : packing.getCircles()) {
            assertTrue(circle.getRadius() >= 10 && circle.getRadius() <= 20);
        }
    }

    @Test
    public void testNoOverlappingCircles() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.addCircles();
        ArrayList<Circle> circles = packing.getCircles();
        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                assertFalse("Circles should not overlap", circles.get(i).overlaps(circles.get(j)));
            }
        }
    }

    @Test
    public void testCircleRadiusConstraints() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.addCircles();
        for (Circle circle : packing.getCircles()) {
            double radius = circle.getRadius();
            assertTrue("Circle radius should be within constraints",
                    radius >= algorithm.getMinRadius() && radius <=  algorithm.getMaxRadius());
        }
    }
    @Test
    public void testBoundaryAndCircleIntegration() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.setBoundaryShape("hexagon");
        packing.executeAlgorithm();

        assertTrue(packing.getBoundaryShape() instanceof Hexagon);
        assertFalse(packing.getCircles().isEmpty());
        assertTrue(packing.getCircles().stream().allMatch(circle ->
                packing.getBoundaryShape().isInside(circle)));
    }
    @Test
    public void testCirclePlacement() {
        CirclePackingAlgorithm packing = createTestInstance();
        packing.addCircles();
        Circle lastAddedCircle = packing.getCircles().get(packing.getCircles().size() - 1);
        assertTrue(packing.getBoundaryShape().isInside(lastAddedCircle));
    }

}
