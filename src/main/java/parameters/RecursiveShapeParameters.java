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
    public int initialSize;
    public int depth;
    public int numShapes;


    // Setters

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setInitialRadius(int initialRadius) {
        this.initialSize = initialRadius;
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

    public void initialiseUserParameters(){
// Canvas
        canvasSizeX =1000;
        canvasSizeY =1000;
        backgroundColor = Color.WHITE;
        lineColor = Color.BLACK;
        lineWidth = 2.0f;  // 2 pixels wide


        largeShapeType = "triangle";  // "circle", "triangle", "hexagon" or "square"
        largeShapeLineColor = Color.BLACK;
        largeShapeLineWidth = 1.0f;
        largeShapeFillColor = new Color(0, 0, 0, 22);  // RGBA where A is alpha (opacity);
        largeShapeLineType = "dashed"; // "solid", "dashed", "dotted"

        smallShapeType = "triangle";
        smallShapeLineColor = new Color(0, 0, 0, 250); ;
        smallShapeLineWidth = 1.0f;
        smallShapeFillColor = new Color(0, 0, 255, 150);  // RGBA where A is alpha (opacity);;
        smallShapeLineType = "dashed"; // "solid", "dashed", "dotted"

        centerX = 500;
        centerY = 500;
        initialSize = 250;
        depth = 6;
        numShapes = 5;

    }
}

