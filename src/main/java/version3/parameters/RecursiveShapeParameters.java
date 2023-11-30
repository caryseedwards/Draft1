package version3.parameters;

import java.awt.*;

/**
 * Responsible for housing and configuring the specific Recursive Shape Algorithm values
 * @author carysedwards
 */
public class RecursiveShapeParameters {
    public int canvasSizeX;
    public int canvasSizeY;
    public Color backgroundColor = Color.WHITE;

    public String largeShapeType;
    public Color largeShapeLineColor;
    public int largeShapeLineWidth;
    public Color largeShapeFillColor;
    public String largeShapeLineType = "solid";

    public String smallShapeType;
    public Color smallShapeLineColor = Color.BLACK;
    public int smallShapeLineWidth;
    public Color smallShapeFillColor;
    public String smallShapeLineType = "solid";

    public int centerX;
    public int centerY;
    public int initialSize;
    public int depth;
    public int numShapes;

    /**
     * Sets the centre x co-ordinate
     * @param centerX - the x co-ordinate
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    /**
     * Sets the centre y co-ordinate
     * @param centerY - the y co-ordinate
     */
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    /**
     * Sets the initial size of the shapes
     * @param initialRadius - initial size of the shapes
     */
    public void setInitialRadius(int initialRadius) {
        this.initialSize = initialRadius;
    }

    /**
     * Sets the recursive depth of the algorithm
     * @param depth - depth of the algorithm
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Sets the number of the secondary shapes drawn
     * @param numShapes - number of secondary shapes to draw
     */
    public void setNumShapes(int numShapes) {
        this.numShapes = numShapes;
    }

    /**
     * Sets the large shape type
     * @param largeShapeType - circle, triangle. square, hexagon
     */
    public void setLargeShapeType(String largeShapeType) {
        this.largeShapeType = largeShapeType;
    }

    /**
     * Sets the large shape line colour
     * @param largeShapeLineColor - line colour for large shape
     */
    public void setLargeShapeLineColor(Color largeShapeLineColor) {
        this.largeShapeLineColor = largeShapeLineColor;
    }

    /**
     * Sets the large shape line width
     * @param largeShapeLineWidth - line width for large shape
     */
    public void setLargeShapeLineWidth(int largeShapeLineWidth) {
        this.largeShapeLineWidth = largeShapeLineWidth;
    }

    /**
     * SEts the large shape fill colour
     * @param largeShapeFillColor - fill colour for large shape
     */
    public void setLargeShapeFillColor(Color largeShapeFillColor) {
        this.largeShapeFillColor = largeShapeFillColor;
    }

    /**
     * Sets the small shape type
     * @param smallShapeType - circle, triangle. square, hexagon
     */
    public void setSmallShapeType(String smallShapeType) {
        this.smallShapeType = smallShapeType;
    }

    /**
     * Sets the small shape line colour
     * @param smallShapeLineColor - line colour for small shape
     */
    public void setSmallShapeLineColor(Color smallShapeLineColor) {
        this.smallShapeLineColor = smallShapeLineColor;
    }

    /**
     * Sets the small shape line width
     * @param smallShapeLineWidth - line width for small shape
     */
    public void setSmallShapeLineWidth(int smallShapeLineWidth) {
        this.smallShapeLineWidth = smallShapeLineWidth;
    }

    /**
     * SEts the small shape fill colour
     * @param smallShapeFillColor - colour for small shape
     */
    public void setSmallShapeFillColor(Color smallShapeFillColor) {
        this.smallShapeFillColor = smallShapeFillColor;
    }

    /**
     * Initialises defaults for the recusrive shape parameters
     */
    public void initialiseUserParameters() {
        canvasSizeX = 800;
        canvasSizeY = 800;
        backgroundColor = Color.WHITE;

        largeShapeType = "triangle";
        largeShapeLineColor = Color.BLACK;
        largeShapeLineWidth = 1;
        largeShapeFillColor = new Color(0, 0, 0, 0);
        largeShapeLineType = "solid";

        smallShapeType = "triangle";
        smallShapeLineColor = Color.BLACK;
        smallShapeLineWidth = 1;
        smallShapeFillColor = new Color(0, 0, 0, 0);
        smallShapeLineType = "solid";

        centerX = canvasSizeX / 2;
        centerY = canvasSizeY / 2;
        initialSize = 150;
        depth = 4;
        numShapes = 6;
    }
}

