package unit_test.version1.shapes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import version1.shapes.Circle;
import version1.shapes.Square;

import java.awt.*;

public class SquareTest {
    private Square square;

    @Before
    public void setUp() {
        square = new Square(10, 10, 5);
    }

    @Test
    public void testSquareInitialization() {
        assertEquals("Center X should be initialized correctly", 10, square.centerX);
        assertEquals("Center Y should be initialized correctly", 10, square.centerY);
        assertEquals("Radius should be initialized correctly", 5, square.radius, 0.0);
    }

    @Test
    public void testIsInsideTrue() {
        Circle circle = new Circle(10, 10, 2);
        assertTrue("Circle should be inside square", square.isInside(circle));
    }

    @Test
    public void testIsInsideFalse() {
        Circle circle = new Circle(20, 20, 3);
        assertFalse("Circle should not be inside square", square.isInside(circle));
    }

    @Test
    public void testRandomPositionInside() {
        Point point = square.randomPositionInside();
        assertTrue("Point should be inside square",
                point.x >= square.centerX - square.radius &&
                        point.x <= square.centerX + square.radius &&
                        point.y >= square.centerY - square.radius &&
                        point.y <= square.centerY + square.radius);
    }

    @Test
    public void testSetPosition() {
        square.setPosition(15, 15);
        assertEquals("Center X should be updated", 15, square.centerX);
        assertEquals("Center Y should be updated", 15, square.centerY);
    }

    @Test
    public void testSetScale() {
        square.setScale(10);
        assertEquals("Radius should be updated", 10, square.radius, 0.0);
    }

}
