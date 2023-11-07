package parameters;

import java.awt.*;

public class RecursiveShapeParameters {
    public int canvasSizeX;
    public int canvasSizeY;
    public Color backgroundColor = Color.WHITE;

    public String largeShapeType;
    public Color largeShapeLineColor;
    public float largeShapeLineWidth;
    public Color largeShapeFillColor;
    public String largeShapeLineType = "solid";

    public String smallShapeType;
    public Color smallShapeLineColor = Color.BLACK;
    public float smallShapeLineWidth;
    public Color smallShapeFillColor;
    public String smallShapeLineType = "solid";


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

    public void initialiseUserParameters() {
        canvasSizeX = 800;
        canvasSizeY = 800;
        backgroundColor = Color.WHITE;

        largeShapeType = "triangle";
        largeShapeLineColor = Color.BLACK;
        largeShapeLineWidth = 1.0f;
        largeShapeFillColor = new Color(0, 0, 0, 0);
        largeShapeLineType = "solid";

        smallShapeType = "triangle";
        smallShapeLineColor = Color.BLACK;
        smallShapeLineWidth = 1.0f;
        smallShapeFillColor = new Color(0, 0, 0, 0);
        smallShapeLineType = "solid";

        centerX = canvasSizeX / 2;
        centerY = canvasSizeY / 2;
        initialSize = 150;
        depth = 4;
        numShapes = 6;
    }

}

