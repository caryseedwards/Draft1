package withgof.parameters;

import java.awt.*;

public class ShapeParameters extends Parameters {
    private String shapeType;
    private float lineWidth;
    private Color lineColour;
    private Color fillColour;

    public ShapeParameters(String shapeType, float lineWidth, Color lineColour, Color fillColour) {
        this.parameterType = "shape";
        this.shapeType = shapeType;
        this.lineWidth = lineWidth;
        this.lineColour = lineColour;
        this.fillColour = fillColour;
    }

    @Override
    public boolean validateParameters() {
        try {
            if (shapeType == null || shapeType.isEmpty()) {
                throw new IllegalArgumentException("Shape type is null or empty");
            }
            if (lineWidth <= 0.0f) {
                throw new IllegalArgumentException("Line width must be positive");
            }
            if (lineColour == null || fillColour == null) {
                throw new IllegalArgumentException("Line or Fill colour is null");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color getLineColour() {
        return lineColour;
    }

    public void setLineColour(Color lineColour) {
        this.lineColour = lineColour;
    }

    public Color getFillColour() {
        return fillColour;
    }

    public void setFillColour(Color fillColour) {
        this.fillColour = fillColour;
    }
}
