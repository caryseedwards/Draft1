package parameters;

import java.awt.*;

public class RecursiveShapeParameters {
    public int canvasSizeX = 500;
    public int canvasSizeY = 500;
    public Color lineColor = Color.BLACK;
    public float lineWidth = 1.0f;
    public Color backgroundColor = Color.WHITE;

    // Pattern repetition
    public double repeatX = 0;
    public double repeatY = 0;
    public double patternSpacingX = 0;
    public double patternSpacingY = 0;
    public int numPatternsX = 0;
    public int numPatternsY = 0;

    public String largeShapeType = "circle";
    public Color largeShapeLineColor = Color.BLACK;
    public float largeShapeLineWidth = 1.0f;
    public Color largeShapeFillColor = new Color(0, 0, 0, 128);  // RGBA where A is alpha (opacity)
    public String largeShapeLineType = "solid"; // "solid", "dashed", "dotted"

    public String smallShapeType = "circle";
    public Color smallShapeLineColor = Color.BLACK;
    public float smallShapeLineWidth = 1.0f;
    public Color smallShapeFillColor = new Color(0, 0, 0, 128);  // RGBA where A is alpha (opacity)
    public String smallShapeLineType = "solid"; // "solid", "dashed", "dotted"


    public int centerX = 250;
    public int centerY = 250;
    public double initialRadius = 150.0;
    public int depth = 4;
    public int numShapes = 6;

    public void initialiseUserParameters() {
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
        initialRadius = 250.0;
        depth = 3;
        numShapes = 6;

        //Repetition
        repeatX = 3.0;
        repeatY = 3.0;
        patternSpacingX = this.initialRadius * this.repeatX;
        patternSpacingY = this.initialRadius * this.repeatY;
        numPatternsX = (int) (canvasSizeX / patternSpacingX);
        numPatternsY = (int) (canvasSizeY / patternSpacingY);
    }
}

