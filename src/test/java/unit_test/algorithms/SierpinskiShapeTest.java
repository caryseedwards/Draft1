package unit_test.algorithms;

import algorithms.SierpinskiShape;
import org.junit.Test;
import parameters.SierpinskiShapeParameters;
import shapes.Circle;
import shapes.Hexagon;
import shapes.Square;
import shapes.Triangle;

import static org.junit.Assert.*;

public class SierpinskiShapeTest {

    @Test
    public void testConstructorAndParameterInitialization() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setCentreX(100);
        params.setCentreY(100);
        params.setPolygonSize(200);
        params.setDepth(3);
        params.setShapeType("triangle");
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        assertEquals(params, sierpinskiShape.getParams());
    }

    @Test
    public void testInitializeShapesWithCircle() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("circle");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        sierpinskiShape.initializeShapes();
        assertFalse(sierpinskiShape.getShapesToDraw().isEmpty());
        assertTrue(sierpinskiShape.getShapesToDraw().get(0) instanceof Circle);
    }

    @Test
    public void testInitializeShapesWithTriagle() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("triangle");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        sierpinskiShape.initializeShapes();
        assertFalse(sierpinskiShape.getShapesToDraw().isEmpty());
        assertTrue(sierpinskiShape.getShapesToDraw().get(0) instanceof Triangle);
    }

    @Test
    public void testInitializeShapesWithSquare() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("square");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        sierpinskiShape.initializeShapes();
        assertFalse(sierpinskiShape.getShapesToDraw().isEmpty());
        assertTrue(sierpinskiShape.getShapesToDraw().get(0) instanceof Square);
    }

    @Test
    public void testInitializeShapesWithHexagon() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("hexagon");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        sierpinskiShape.initializeShapes();
        assertFalse(sierpinskiShape.getShapesToDraw().isEmpty());
        assertTrue(sierpinskiShape.getShapesToDraw().get(0) instanceof Hexagon);
    }

    @Test
    public void testDepthZeroBehavior() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setDepth(0);
        params.setShapeType("triangle");
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);
        sierpinskiShape.initializeShapes();
        assertFalse(sierpinskiShape.getShapesToDraw().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidShapeTypeHandling() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("invalidShapeType");
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);
        sierpinskiShape.initializeShapes();
    }

    @Test
    public void testDepthOneBehavior() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("circle");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);
        sierpinskiShape.initializeShapes();
        assertEquals(1, sierpinskiShape.getShapesToDraw().size());
    }

    @Test
    public void testShapesListClearing() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("triangle");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);
        sierpinskiShape.initializeShapes();
        int initialSize = sierpinskiShape.getShapesToDraw().size();
        sierpinskiShape.initializeShapes();
        assertEquals(initialSize, sierpinskiShape.getShapesToDraw().size());
    }

    @Test
    public void testParameterChangeEffect() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setShapeType("triangle");
        params.setDepth(1);
        SierpinskiShape sierpinskiShape = new SierpinskiShape(params);

        sierpinskiShape.initializeShapes();
        int countAfterFirstInit = sierpinskiShape.getShapesToDraw().size();

        params.setShapeType("square");
        sierpinskiShape.initializeShapes();
        int countAfterSecondInit = sierpinskiShape.getShapesToDraw().size();

        assertNotEquals(countAfterFirstInit, countAfterSecondInit);
    }
}
