package unit_test.template.shapes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import template.shapes.Circle;

import java.awt.*;

public class CircleTest {
    private Circle circle;

    @Before
    public void setUp() {
        circle = new Circle(10, 10, 5);
    }

    @Test
    public void testGetX() {
        assertEquals("Testing getX()", 10, circle.getX());
    }

    @Test
    public void testGetY() {
        assertEquals("Testing getY()", 10, circle.getY());
    }

    @Test
    public void testGetRadius() {
        assertEquals("Testing getRadius()", 5, circle.getRadius(), 0.0);
    }

    @Test
    public void testOverlapsTrue() {
        Circle otherCircle = new Circle(12, 10, 4);
        assertTrue("Testing overlaps() where circles do overlap", circle.overlaps(otherCircle));
    }

    @Test
    public void testOverlapsFalse() {
        Circle otherCircle = new Circle(20, 20, 3);
        assertFalse("Testing overlaps() where circles do not overlap", circle.overlaps(otherCircle));
    }

    @Test
    public void testSetPosition() {
        circle.setPosition(15, 15);
        assertEquals("Center X should be updated", 15, circle.centerX);
        assertEquals("Center Y should be updated", 15, circle.centerY);
    }

    @Test
    public void testSetScale() {
        circle.setScale(10);
        assertEquals("Radius should be updated", 10, circle.radius, 0.0);
    }

    @Test
    public void testRandomPositionInside() {
        Point randomPoint = circle.randomPositionInside();
        assertNotNull(randomPoint);
        assertTrue(Math.pow(randomPoint.x - circle.centerX, 2) + Math.pow(randomPoint.y - circle.centerY, 2) <= Math.pow(circle.radius, 2));
    }

    @Test
    public void testIsInsideTrue() {
        Circle boundary = new Circle(10, 10, 10);
        assertTrue(circle.isInside(boundary));
    }

    @Test
    public void testIsInsideEdgeCase() {
        Circle boundary = new Circle(10, 10, 5);
        assertTrue(circle.isInside(boundary));
    }
}
