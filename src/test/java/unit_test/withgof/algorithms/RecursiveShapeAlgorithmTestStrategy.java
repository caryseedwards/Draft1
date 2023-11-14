package unit_test.withgof.algorithms;

import org.junit.Before;
import org.junit.Test;
import withgof.algorithms.RecursiveShapeAlgorithm;
import withgof.parameters.CanvasParameters;
import withgof.parameters.RecursiveShapeAlgorithmParameters;
import withgof.parameters.ShapeParameters;
import withgof.shapes.Shape;
import withgof.shapes.*;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecursiveShapeAlgorithmTestStrategy {
    CanvasParameters canvas;
    ArrayList<ShapeParameters> shapes;
    RecursiveShapeAlgorithmParameters algorithm;
    RecursiveShapeAlgorithm test;
    @Before
    public void createTestInstance() {
        canvas = new CanvasParameters(500, 500, Color.WHITE);
        shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("square", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("triangle", 2, Color.GRAY, Color.YELLOW));
        algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);
        test = new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }
    private RecursiveShapeAlgorithm refreshTestInstanceWithShapeType(String largeShapeType, String smallShapeType) {
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters(largeShapeType, 1, Color.BLACK, Color.BLACK));
        shapes.add(new ShapeParameters(smallShapeType, 2, Color.BLACK, Color.YELLOW));
        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }
    private RecursiveShapeAlgorithm createTestInstanceWithUpdatedParameters() {
        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }
    private int calculateTotalNumberOfShapes(int depth, int numSmallShapes) {
        if (depth == 0) return 1;
        // Each level of depth adds numSmallShapes per each shape of the previous level
        return calculateTotalNumberOfShapes(depth - 1, numSmallShapes) * (1 + numSmallShapes);
    }
    private int calculateNumberOfLargeShapes(int depth) {
        // One large shape per level of depth
        return depth;
    }
    private int calculateNumberOfSmallShapes(int depth, int numSmallShapes) {
        // One large shape per level of depth
        return calculateTotalNumberOfShapes(depth, numSmallShapes) - calculateNumberOfLargeShapes(depth);
    }
    @Test
    public void testInitializationForDifferentShapes() {
        String[] shapeTypes = {"circle", "square", "triangle", "hexagon"};
        for (String largeShapeType : shapeTypes) {
            for (String smallShapeType : shapeTypes) {
                RecursiveShapeAlgorithm pattern = refreshTestInstanceWithShapeType(largeShapeType, smallShapeType);
                assertNotNull("Algorithm should be initialised for shape types: " + largeShapeType + ", " + smallShapeType, pattern);
            }
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidShapeType() {
        refreshTestInstanceWithShapeType("invalidShape", "circle").executeAlgorithm();
    }
    @Test
    public void testAddPattern() {
        test.executeAlgorithm();
        assertFalse(test.getShapesToDraw().isEmpty());
    }

//    @Test
//    public void testCreateShape() {
//        Shape testShape = test.createShape("triangle", 100, 100, 50);
//        assertTrue(testShape instanceof Triangle);
//        testShape = test.createShape("circle", 100, 100, 50);
//        assertTrue(testShape instanceof Circle);
//        testShape = test.createShape("hexagon", 100, 100, 50);
//        assertTrue(testShape instanceof Hexagon);
//        testShape = test.createShape("square", 100, 100, 50);
//        assertTrue(testShape instanceof Square);
//    }

    @Test
    public void testInitialiseShapes() {
        RecursiveShapeAlgorithm recursiveShape = refreshTestInstanceWithShapeType("square", "circle");

        assertSame("square", recursiveShape.getLargeShapeParameters().getShapeType());
        assertSame( "circle",recursiveShape.getSmallShapeParameters().getShapeType());
    }


    @Test
    public void testShapesHaveTheirDifferentParameters(){
        test.executeAlgorithm();
        assertSame("Large shapes should be drawn with the expected parameter fill colour: BLACK", test.getShapesToDraw().get(0).getParameters().getFillColour(), Color.WHITE);
        assertSame("Large shapes should be drawn with their expected parameter line colour : BLACK", test.getShapesToDraw().get(0).getParameters().getLineColour(), Color.BLACK);
        assertEquals("Large shapes should be drawn with their expected parameter line width : 1.0f", 1, test.getShapesToDraw().get(0).getParameters().getLineWidth(), 0.0);
        assertSame("Small shape should with the expected parameter colour: YELLOW", test.getShapesToDraw().get(1).getParameters().getFillColour(), Color.YELLOW);
        assertSame("Large shapes should be drawn with their expected parameter line colour : BLACK", test.getShapesToDraw().get(1).getParameters().getLineColour(), Color.GRAY);
        assertEquals("Large shapes should be drawn with their expected parameter line width : 1.0f", 2, test.getShapesToDraw().get(1).getParameters().getLineWidth(), 0.0);

    }
    @Test
    public void testZeroDepth() {
        algorithm.setDepth(0);
        RecursiveShapeAlgorithm pattern = refreshTestInstanceWithShapeType("hexagon", "triangle");
        pattern.executeAlgorithm();
        assertTrue("No shapes should be drawn at zero depth, but has drawn"+pattern.getShapesToDraw().size()+ "withoutgof/shapes", pattern.getShapesToDraw().isEmpty());
    }

    @Test
    public void testTotalNumberOfShapes() {
        algorithm.setDepth(1);
        algorithm.setNumShapes(6);
        test = createTestInstanceWithUpdatedParameters();
        test.executeAlgorithm();
        int expectedNumberOfShapes = calculateTotalNumberOfShapes(algorithm.getDepth(), algorithm.getNumShapes());
        assertEquals("Expected "+ expectedNumberOfShapes +"number of large shapes, but have " + test.getShapesToDraw().size()+" instead.",expectedNumberOfShapes, test.getShapesToDraw().size());
    }

    @Test
    public void testNumberOfLargeShapes() {
        algorithm.setDepth(1);
        algorithm.setNumShapes(6);
        test = createTestInstanceWithUpdatedParameters();
        test.executeAlgorithm();
        int expectedNumberOfLargeShapes = calculateNumberOfLargeShapes(algorithm.getDepth());
        long actualNumberOfLargeShapes = test.getShapesToDraw().stream()
                .filter(shape -> shape instanceof Square)
                .count();
        assertEquals("Expected "+ expectedNumberOfLargeShapes +"number of large shapes, but have " + actualNumberOfLargeShapes+" instead.",expectedNumberOfLargeShapes, actualNumberOfLargeShapes);
    }

    @Test
    public void testNumberOfSmallShapes() {
        algorithm.setDepth(1);
        algorithm.setNumShapes(6);
        test = createTestInstanceWithUpdatedParameters();
        test.executeAlgorithm();
        int expectedNumberOfSmallShapes = calculateNumberOfSmallShapes(algorithm.getDepth(), algorithm.getNumShapes());
        long actualNumberOfSmallShapes = test.getShapesToDraw().stream()
                .filter(shape -> (shape instanceof Triangle))
                .count();
        assertEquals("Expected "+ expectedNumberOfSmallShapes +"number of small shapes, but have " + actualNumberOfSmallShapes+" instead.",expectedNumberOfSmallShapes, actualNumberOfSmallShapes);
    }

}
