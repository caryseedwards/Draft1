package parameters;

import java.awt.*;
import java.util.Objects;

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
    public void initialiseDefaultParameters() {
        this.parameterType = "shape";
        this.shapeType = "circle";
        this.lineWidth = 0.1f;
        this.lineColour = Color.BLACK;
        this.fillColour = Color.WHITE;
    }

    @Override
    public boolean validateParameters() {
        try {
            // Check if shapeType is not null and not empty
            if (shapeType == null || shapeType.isEmpty()) {
                throw new IllegalArgumentException("Shape type is null or empty");
            }
            // Check if lineWidth is positive
            if (lineWidth <= 0.0f) {
                throw new IllegalArgumentException("Line width must be positive");
            }
            // Check if both lineColour and fillColour are not null
            if (lineColour == null || fillColour == null) {
                throw new IllegalArgumentException("Line or Fill colour is null");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public ShapeParameters copy() {
        return new ShapeParameters(this.shapeType, this.lineWidth, this.lineColour,this.fillColour);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ShapeParameters that = (ShapeParameters) other;
        return Float.compare(that.lineWidth, lineWidth) == 0 &&
                Objects.equals(shapeType, that.shapeType) &&
                Objects.equals(lineColour, that.lineColour) &&
                Objects.equals(fillColour, that.fillColour);
    }
    // Getters
    public String getShapeType() {return shapeType;}
    public float getLineWidth() {return lineWidth;}
    public Color getLineColour() {return lineColour;}
    public Color getFillColour() {return fillColour;}

    // Setters
    public void setShapeType(String shapeType) {this.shapeType = shapeType;}
    public void setLineWidth(float lineWidth) {this.lineWidth = lineWidth;}
    public void setLineColour(Color lineColour) {this.lineColour = lineColour;}
    public void setFillColour(Color fillColour) {this.fillColour = fillColour;}
}
