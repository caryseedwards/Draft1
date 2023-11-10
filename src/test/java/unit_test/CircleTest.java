package unit_test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import shapes.Circle;

public class CircleTest {
    private Circle circle;

    @Before
    public void setUp() {
        // Initialize a Circle object before each test
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
}
