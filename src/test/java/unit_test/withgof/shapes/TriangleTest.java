package unit_test.withgof.shapes;

import org.junit.Before;
import org.junit.Test;
import withgof.shapes.Circle;
import withgof.shapes.Triangle;

import java.awt.*;

import static org.junit.Assert.*;

public class TriangleTest {
    private Triangle triangle;

    @Before
    public void setUp() {
        triangle = new Triangle(10, 10, 15);
    }

    @Test
    public void testSetVerticesNull() {
        triangle.setVertices();
        assertNotNull("Vertex 1 should not be null", new Point(triangle.getX1(), triangle.getY1()));
        assertNotNull("Vertex 2 should not be null", new Point(triangle.getX2(), triangle.getY2()));
        assertNotNull("Vertex 3 should not be null", new Point(triangle.getX3(), triangle.getY3()));
    }

    private void validateTriangleVertices(Triangle triangle, int centerX, int centerY, double radius) {
        int expectedX1 = centerX;
        int expectedY1 = (int)(centerY - radius);
        int expectedX2 = (int)(centerX - radius * Math.cos(Math.toRadians(30)));
        int expectedY2 = (int)(centerY + radius * Math.sin(Math.toRadians(30)));
        int expectedX3 = (int)(centerX + radius * Math.cos(Math.toRadians(30)));
        int expectedY3 = (int)(centerY + radius * Math.sin(Math.toRadians(30)));

        assertEquals("Vertex x1 should be set correctly", expectedX1, triangle.getX1());
        assertEquals("Vertex y1 should be set correctly", expectedY1, triangle.getY1());
        assertEquals("Vertex x2 should be set correctly", expectedX2, triangle.getX2());
        assertEquals("Vertex y2 should be set correctly", expectedY2, triangle.getY2());
        assertEquals("Vertex x3 should be set correctly", expectedX3, triangle.getX3());
        assertEquals("Vertex y3 should be set correctly", expectedY3, triangle.getY3());
    }

    @Test
    public void testSetVerticesOnCreation() {
        Triangle triangle1 = new Triangle(10, 10, 5);
        validateTriangleVertices(triangle1, 10, 10, 5);

        Triangle triangle2 = new Triangle(20, 20, 10);
        validateTriangleVertices(triangle2, 20, 20, 10);

        Triangle triangle3 = new Triangle(5, 5, 2);
        validateTriangleVertices(triangle3, 5, 5, 2);
    }

    @Test
    public void testRandomPositionInside() {
        Point point = triangle.randomPositionInside();
        assertTrue("The point should be inside the triangle", triangle.isPointInside(point.x, point.y));
    }

    @Test
    public void testIsInsideTrue() {
        Circle circle = new Circle(10, 10, 5);
        assertTrue("Triangle should be inside the circle", triangle.isInside(circle));
    }

    @Test
    public void testUpdateVerticesAfterSetPosition() {
        triangle.setPosition(20, 20);
        validateTriangleVertices(triangle, 20, 20, 15);
    }

    @Test
    public void testUpdateVerticesAfterSetScale() {
        triangle.setScale(8);
        validateTriangleVertices(triangle, 10, 10, 8);
    }

    @Test
    public void testIsInsideFalse() {
        Circle circle = new Circle(60, 20, 3);
        assertFalse("Triangle should not be inside the circle", triangle.isInside(circle));
    }

    @Test
    public void testIsPointInsideTrue() {
        assertTrue("Point should be inside triangle", triangle.isPointInside(10, 10));
    }

    @Test
    public void testIsPointInsideFalse() {
        assertFalse("Point should not be inside triangle", triangle.isPointInside(0, 0));
    }

    @Test
    public void testSetPosition() {
        triangle.setPosition(15, 15);
        assertEquals("Center X should be updated", 15, triangle.getCenterX());
        assertEquals("Center Y should be updated", 15, triangle.getCenterY());
    }

    @Test
    public void testSetScale() {
        triangle.setScale(10);
        assertEquals("Radius should be updated", 10, triangle.getRadius(), 0.0);
    }

}


