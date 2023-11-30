package version2.shapes;

import version2.parameters.ShapeParameters;


/**
 * Implementation of the Simple Factory Pattern used to create shapes
 * @author carysedwards
 */
public class ShapeFactory {

    /**
     * Creates a shape based on given parameters
     * @param x - the starting x co-ordinate
     * @param y - the starting y co-ordinate
     * @param radius - the scaling factor for the shape
     * @param parameters - the shape parameters for the shape
     * @return the shape
     */
    public Shape createShape(int x, int y, double radius, ShapeParameters parameters) {
        Shape newShape = switch (parameters.getShapeType()) {
            case "circle" -> createCircle(x, y, radius);
            case "square" -> createSquare(x, y, radius);
            case "triangle" -> createTriangle(x, y, radius);
            case "hexagon" -> createHexagon(x, y, radius);
            default -> throw new IllegalArgumentException("Invalid shape type: " + parameters.getShapeType());
        };
        newShape.setParameters(parameters);
        return newShape;
    }

    /**
     * Creates a circle based on given information
     * @param x - starting x position
     * @param y - the starting y position
     * @param radius - the scaling factor
     * @return A new circle
     */
    private Circle createCircle(int x, int y, double radius) {
        return new Circle(x, y, radius);
    }

    /**
     * Creates a square based on given information
     * @param x - starting x position
     * @param y - the starting y position
     * @param radius - the scaling factor
     * @return A new square
     */
    private Square createSquare(int x, int y, double radius) {
        return new Square(x, y, radius);
    }

    /**
     * Creates a triangle based on given information
     * @param x - starting x position
     * @param y - the starting y position
     * @param radius - the scaling factor
     * @return A new triangle
     */
    private Triangle createTriangle(int x, int y, double radius) {
        return new Triangle(x, y, radius);
    }

    /**
     * Creates a hexagon based on given information
     * @param x - starting x position
     * @param y - the starting y position
     * @param radius - the scaling factor
     * @return A new hexagon
     */
    private Hexagon createHexagon(int x, int y, double radius) {
        return new Hexagon(x, y, radius);
    }
}
