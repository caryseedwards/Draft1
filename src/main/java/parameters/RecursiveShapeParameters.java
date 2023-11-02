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
    public double initialSize;
    public int depth;
    public int numShapes;


    // Boundary shape parameters
    public int centreX = 250;
    public int centreY = 250;
    public int circleRadius = 150;
    public int rectWidth = 150;
    public int rectHeight = 100;
    public int x1 = 400,y1 = 100,x2 = 100,y2 = 700,x3 = 700,y3 = 700;
    public int polygonSize = 100;
    public Color boundaryFillColour = Color.WHITE;
    public Color boundaryLineColour = Color.RED;
    public float boundaryLineWidth = 1;

    // Setters

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setInitialRadius(double initialRadius) {
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
        largeShapeFillColor = new Color(0, 0, 0, 250);  // RGBA where A is alpha (opacity);
        largeShapeLineType = "dashed"; // "solid", "dashed", "dotted"

        smallShapeType = "triangle";
        smallShapeLineColor = new Color(0, 0, 0, 250); ;
        smallShapeLineWidth = 1.0f;
        smallShapeFillColor = new Color(0, 0, 255, 150);  // RGBA where A is alpha (opacity);;
        smallShapeLineType = "dashed"; // "solid", "dashed", "dotted"

        centerX = 500;
        centerY = 500;
        initialSize = 250.0;
        depth = 3;
        numShapes = 6;

    }
}

