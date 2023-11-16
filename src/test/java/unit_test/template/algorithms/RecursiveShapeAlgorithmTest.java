package unit_test.template.algorithms;

import template.algorithms.RecursiveShapeAlgorithm;
import org.junit.Test;
import template.parameters.CanvasParameters;
import template.parameters.RecursiveShapeAlgorithmParameters;
import template.parameters.ShapeParameters;
import template.shapes.*;
import template.shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecursiveShapeAlgorithmTest {
    private RecursiveShapeAlgorithm createTestInstance() {
        CanvasParameters canvas = new CanvasParameters(500, 500, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("square", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("triangle", 2, Color.GRAY, Color.YELLOW));
        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);

        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }
    private RecursiveShapeAlgorithm createTestInstanceWithShapeType(String largeShapeType, String smallShapeType) {
        CanvasParameters canvas = new CanvasParameters(500, 500, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters(largeShapeType, 1, Color.BLACK, Color.BLACK));
        shapes.add(new ShapeParameters(smallShapeType, 2, Color.BLACK, Color.YELLOW));
        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);

        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }
    private int calculateTotalNumberOfShapes(int depth, int numSmallShapes) {
        if (depth == 0) return 1;
        return calculateTotalNumberOfShapes(depth - 1, numSmallShapes) * (1 + numSmallShapes);
    }
    private int calculateNumberOfLargeShapes(int depth) {
        return depth;
    }
    private int calculateNumberOfSmallShapes(int depth, int numSmallShapes) {
        return calculateTotalNumberOfShapes(depth, numSmallShapes) - calculateNumberOfLargeShapes(depth);
    }
    @Test
    public void testInitializationForDifferentShapes() {
        String[] shapeTypes = {"circle", "square", "triangle", "hexagon"};
        for (String largeShapeType : shapeTypes) {
            for (String smallShapeType : shapeTypes) {
                RecursiveShapeAlgorithm pattern = createTestInstanceWithShapeType(largeShapeType, smallShapeType);
                assertNotNull("Algorithm should be initialised for shape types: " + largeShapeType + ", " + smallShapeType, pattern);
            }
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidShapeType() {
        createTestInstanceWithShapeType("invalidShape", "circle").executeAlgorithm();
    }
    @Test
    public void testAddPattern() {
        RecursiveShapeAlgorithm recursiveShape = createTestInstance();
        recursiveShape.executeAlgorithm();
        assertFalse(recursiveShape.getShapesToDraw().isEmpty());
    }

    @Test
    public void testCreateShape() {
        RecursiveShapeAlgorithm recursiveShape = createTestInstance();
        Shape testShape = recursiveShape.createShape("triangle", 100, 100, 50);
        assertTrue(testShape instanceof Triangle);
        testShape = recursiveShape.createShape("circle", 100, 100, 50);
        assertTrue(testShape instanceof Circle);
        testShape = recursiveShape.createShape("hexagon", 100, 100, 50);
        assertTrue(testShape instanceof Hexagon);
        testShape = recursiveShape.createShape("square", 100, 100, 50);
        assertTrue(testShape instanceof Square);

    }

    @Test
    public void testInitialiseShapes() {
        RecursiveShapeAlgorithm recursiveShape = createTestInstanceWithShapeType("square", "circle");

        assertSame("square", recursiveShape.getLargeShapeParams().getShapeType());
        assertSame( "circle",recursiveShape.getSmallShapeParams().getShapeType());
    }


    @Test
    public void testShapesHaveTheirDifferentParameters(){
        RecursiveShapeAlgorithm pattern = createTestInstance();
        pattern.executeAlgorithm();
        assertSame("Large shapes should be drawn with the expected parameter fill colour: BLACK", pattern.getShapesToDraw().get(0).getShapeParameters().getFillColour(), Color.WHITE);
        assertSame("Large shapes should be drawn with their expected parameter line colour : BLACK", pattern.getShapesToDraw().get(0).getShapeParameters().getLineColour(), Color.BLACK);
        assertEquals("Large shapes should be drawn with their expected parameter line width : 1.0f", 1, pattern.getShapesToDraw().get(0).getShapeParameters().getLineWidth(), 0.0);
        assertSame("Small shape should with the expected parameter colour: YELLOW", pattern.getShapesToDraw().get(1).getShapeParameters().getFillColour(), Color.YELLOW);
        assertSame("Large shapes should be drawn with their expected parameter line colour : BLACK", pattern.getShapesToDraw().get(1).getShapeParameters().getLineColour(), Color.GRAY);
        assertEquals("Large shapes should be drawn with their expected parameter line width : 1.0f", 2, pattern.getShapesToDraw().get(1).getShapeParameters().getLineWidth(), 0.0);

    }
    @Test
    public void testZeroDepth() {
        RecursiveShapeAlgorithm pattern = createTestInstanceWithShapeType("hexagon", "triangle");
        pattern.getParams().setDepth(0);
        pattern.executeAlgorithm();
        assertTrue("No shapes should be drawn at zero depth, but has drawn"+pattern.getShapesToDraw().size()+ "template/shapes", pattern.getShapesToDraw().isEmpty());
    }

    @Test
    public void testTotalNumberOfShapes() {
        RecursiveShapeAlgorithm pattern = createTestInstance();
        pattern.getParams().setDepth(1);
        pattern.getParams().setNumShapes(6);
        pattern.executeAlgorithm();
        int expectedNumberOfShapes = calculateTotalNumberOfShapes(pattern.getParams().getDepth(), pattern.getParams().getNumShapes());
        assertEquals("Expected "+ expectedNumberOfShapes +"number of large shapes, but have " + pattern.getShapesToDraw().size()+" instead.",expectedNumberOfShapes, pattern.getShapesToDraw().size());
    }

    @Test
    public void testNumberOfLargeShapes() {
        RecursiveShapeAlgorithm pattern = createTestInstance();
        pattern.getParams().setDepth(1);
        pattern.getParams().setNumShapes(6);
        pattern.executeAlgorithm();
        int expectedNumberOfLargeShapes = calculateNumberOfLargeShapes(pattern.getParams().getDepth());
        long actualNumberOfLargeShapes = pattern.getShapesToDraw().stream()
                .filter(shape -> shape instanceof Square)
                .count();
        assertEquals("Expected "+ expectedNumberOfLargeShapes +"number of large shapes, but have " + actualNumberOfLargeShapes+" instead.",expectedNumberOfLargeShapes, actualNumberOfLargeShapes);
    }

    @Test
    public void testNumberOfSmallShapes() {
        RecursiveShapeAlgorithm pattern = createTestInstance();
        pattern.getParams().setDepth(1);
        pattern.getParams().setNumShapes(6);
        pattern.executeAlgorithm();
        int expectedNumberOfSmallShapes = calculateNumberOfSmallShapes(pattern.getParams().getDepth(), pattern.getParams().getNumShapes());
        long actualNumberOfSmallShapes = pattern.getShapesToDraw().stream()
                .filter(shape -> (shape instanceof Triangle))
                .count();
        assertEquals("Expected "+ expectedNumberOfSmallShapes +"number of small shapes, but have " + actualNumberOfSmallShapes+" instead.",expectedNumberOfSmallShapes, actualNumberOfSmallShapes);
    }
}
