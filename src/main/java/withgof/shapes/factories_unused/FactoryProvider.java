package withgof.shapes.factories_unused;

public class FactoryProvider {
    public static ShapeFactory getFactory(String type) {
        return switch (type.toLowerCase()) {
            case "circle" -> new CircleFactory();
            case "hexagon" -> new HexagonFactory();
            case "square" -> new SquareFactory();
            case "triangle" -> new TriangleFactory();
            default -> throw new IllegalArgumentException("Unknown shape type: " + type);
        };
    }
}
