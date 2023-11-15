package unit_test.withgof.shapes;

import org.junit.Before;
import org.junit.Test;
import withgof.shapes.Circle;
import withgof.shapes.Square;

import java.awt.*;

import static org.junit.Assert.*;

public class SquareTest {
    private Square square;

    @Before
    public void setUp() {
        square = new Square(10, 10, 5);
    }

    @Test
    public void testSquareInitialization() {
        assertEquals("Center X should be initialized correctly", 10, square.getCenterX());
        assertEquals("Center Y should be initialized correctly", 10, square.getCenterY());
        assertEquals("Radius should be initialized correctly", 5, square.getRadius(), 0.0);
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
                point.x >= square.getCenterX() - square.getRadius() &&
                        point.x <= square.getCenterX() + square.getRadius() &&
                        point.y >= square.getCenterY() - square.getRadius() &&
                        point.y <= square.getCenterY() + square.getRadius());
    }

    @Test
    public void testSetPosition() {
        square.setPosition(15, 15);
        assertEquals("Center X should be updated", 15, square.getCenterX());
        assertEquals("Center Y should be updated", 15, square.getCenterY());
    }

    @Test
    public void testSetScale() {
        square.setScale(10);
        assertEquals("Radius should be updated", 10, square.getRadius(), 0.0);
    }

}
