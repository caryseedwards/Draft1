package unit_test.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;
import algorithms.RecursiveShape;
import parameters.RecursiveShapeParameters;
import shapes.*;
import shapes.Shape;

public class RecursiveShapeTest {

    @Test
    public void testRecursiveShapeConstructor() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape recursiveShape = new RecursiveShape(params);

        assertNotNull(recursiveShape.getLargeShape());
        assertNotNull(recursiveShape.getSmallShape());
    }

    @Test
    public void testAddPattern() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape recursiveShape = new RecursiveShape(params);
        assertFalse(recursiveShape.getShapesToDraw().isEmpty());
    }

    @Test
    public void testCreateShape() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape recursiveShape = new RecursiveShape(params);
        Shape testShape = recursiveShape.createShape("circle", 100, 100, 50);
        assertTrue(testShape instanceof Circle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShapeWithIllegalType() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.setLargeShapeType("circle");
        params.setSmallShapeType("circle");
        RecursiveShape recursiveShape = new RecursiveShape(params);
        recursiveShape.createShape("unknownShape", 100, 100, 50);
    }

    @Test
    public void testInitialiseShapes() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.setLargeShapeType("square");
        params.setSmallShapeType("circle");
        RecursiveShape recursiveShape = new RecursiveShape(params);

        assertTrue(recursiveShape.getLargeShape() instanceof Square);
        assertTrue(recursiveShape.getSmallShape() instanceof Circle);
    }

    @Test
    public void testInitialiseShapesWithDifferentCombinations() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.setLargeShapeType("triangle");
        params.setSmallShapeType("hexagon");
        RecursiveShape recursiveShape = new RecursiveShape(params);

        assertTrue(recursiveShape.getLargeShape() instanceof Triangle);
        assertTrue(recursiveShape.getSmallShape() instanceof Hexagon);
    }

    @Test
    public void testEdgeCases() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        params.setDepth(0);
        RecursiveShape recursiveShape = new RecursiveShape(params);
        assertTrue(recursiveShape.getShapesToDraw().isEmpty());
    }

    @Test(expected = StackOverflowError.class)
    public void testInvalidDepthHandling() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        params.setDepth(-1);
        new RecursiveShape(params);
    }

    @Test
    public void testParameterUpdateReflection() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        params.setLargeShapeType("circle");
        RecursiveShape recursiveShape = new RecursiveShape(params);

        assertEquals("circle", recursiveShape.getParams().largeShapeType);

        params.setLargeShapeType("square");
        assertEquals("square", recursiveShape.getParams().largeShapeType);
    }

    @Test
    public void testDepthZeroBehavior() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        params.setDepth(0);
        RecursiveShape recursiveShape = new RecursiveShape(params);

        assertTrue(recursiveShape.getShapesToDraw().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidShapeTypeHandling() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        RecursiveShape recursiveShape = new RecursiveShape(params);

        recursiveShape.createShape("invalidShapeType", 100, 100, 50);
    }

    @Test
    public void testShapeTypeConsistency() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.initialiseUserParameters();
        params.setLargeShapeType("circle");
        params.setSmallShapeType("square");
        RecursiveShape recursiveShape = new RecursiveShape(params);

        assertTrue(recursiveShape.getLargeShape() instanceof Circle);
        assertTrue(recursiveShape.getSmallShape() instanceof Square);
    }
}

