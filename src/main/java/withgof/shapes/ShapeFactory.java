package withgof.shapes;

import withgof.parameters.ShapeParameters;

public class ShapeFactory {
    public Shape createShape(int x, int y, double radius, ShapeParameters parameters) {
        Shape newShape;
        switch (parameters.getShapeType()) {
            case "circle":
                newShape = new Circle(x, y, radius);
                break;
            case "square":
                newShape = new Square(x, y, radius);
                break;
            case "triangle":
                newShape = new Triangle(x, y, radius);
                break;
            case "hexagon":
                newShape = new Hexagon(x, y, radius);
                break;
            default:
                throw new IllegalArgumentException("Invalid shape type: " + parameters.getShapeType());
        }
        newShape.setParameters(parameters);
        return newShape;
    }
    public Circle createCircle(int x, int y, double radius){
        return new Circle(x, y, radius);
    }
    public Square createSquare(int x, int y, double radius){
        return new Square(x, y, radius);
    }
    public Triangle createTriangle(int x, int y, double radius){
        return new Triangle(x, y, radius);
    }
    public Hexagon createHexagon(int x, int y, double radius){
        return new Hexagon(x, y, radius);
    }
}
