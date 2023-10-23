package draft1;

import java.awt.*;

public class EuclideanParameters {
    public int canvasSizeX;
    public int canvasSizeY;
    public Color lineColor;
    public float lineWidth;
    public Color backgroundColor;

    // Pattern repetition
    double repeatX;
    double repeatY;
    double patternSpacingX;
    double patternSpacingY;
    int numPatternsX;
    int numPatternsY;

    public String shapeType;
    public String smallShapeType;

    public int centerX, centerY;
    public double initialRadius;
    public int depth;
    public int numShapes;

    public void initialiseParameters(){

        // Canvas
        this.canvasSizeX = 500;
        this.canvasSizeY = 500;
        this.backgroundColor = Color.WHITE;
        this.lineColor = Color.BLACK;
        this.lineWidth = 1.0f;  // 2 pixels wide

        this.shapeType = "circle";  // "circle" or "square"
        this.smallShapeType = "circle";

        this.centerX = 250;
        this.centerY = 250;
        this.initialRadius = 50.0;
        this.depth = 3;
        this.numShapes = 4;

        //Repetition
        this.repeatX = 3.0;
        this.repeatY = 3.0;
        this.patternSpacingX = this.initialRadius * this.repeatX;
        this.patternSpacingY = this.initialRadius * this.repeatY;
        this.numPatternsX = (int) (canvasSizeX / patternSpacingX);
        this.numPatternsY = (int) (canvasSizeY / patternSpacingY);

    }
}

