package parameters;

import java.awt.*;

public class RecursiveShapeParameters {
    public int canvasSizeX;
    public int canvasSizeY;
    public Color lineColor = Color.BLACK;
    public float lineWidth = 1.0f;
    public Color backgroundColor = Color.WHITE;

    public String largeShapeType;
    public Color largeShapeLineColor;
    public float largeShapeLineWidth;
    public Color largeShapeFillColor;  // RGBA where A is alpha (opacity)
    public String largeShapeLineType = "solid"; // "solid", "dashed", "dotted"

    public String smallShapeType;
    public Color smallShapeLineColor = Color.BLACK;
    public float smallShapeLineWidth;
    public Color smallShapeFillColor;  // RGBA where A is alpha (opacity)
    public String smallShapeLineType = "solid"; // "solid", "dashed", "dotted"


    public int centerX;
    public int centerY;
    public double initialRadius;
    public int depth;
    public int numShapes;

    // Setters

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setInitialRadius(double initialRadius) {
        this.initialRadius = initialRadius;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setNumShapes(int numShapes) {
        this.numShapes = numShapes;
    }

    public void setLargeShapeType(String largeShapeType) {
        this.largeShapeType = largeShapeType;
    }

    public void setLargeShapeLineColor(Color largeShapeLineColor) {
        this.largeShapeLineColor = largeShapeLineColor;
    }

    public void setLargeShapeLineWidth(float largeShapeLineWidth) {
        this.largeShapeLineWidth = largeShapeLineWidth;
    }

    public void setLargeShapeFillColor(Color largeShapeFillColor) {
        this.largeShapeFillColor = largeShapeFillColor;
    }

    public void setSmallShapeType(String smallShapeType) {
        this.smallShapeType = smallShapeType;
    }

    public void setSmallShapeLineColor(Color smallShapeLineColor) {
        this.smallShapeLineColor = smallShapeLineColor;
    }

    public void setSmallShapeLineWidth(float smallShapeLineWidth) {
        this.smallShapeLineWidth = smallShapeLineWidth;
    }

    public void setSmallShapeFillColor(Color smallShapeFillColor) {
        this.smallShapeFillColor = smallShapeFillColor;
    }


}

