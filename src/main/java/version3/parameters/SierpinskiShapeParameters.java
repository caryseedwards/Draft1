package version3.parameters;

import java.awt.*;

/**
 * Responsible for housing and configuring the specific Sierpinski Algorithm values
 * @author carysedwards
 */
public class SierpinskiShapeParameters {
    public int centreX, centreY, polygonSize, depth;
    public Color shapeFillColour, shapeLineColour;
    public int shapeLineWidth;
    public String shapeType;

    /**
     * Sets the centre x co-ordinate
     * @param centreX - the x co-ordinate
     */
    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    /**
     * Sets the centre y co-ordinate
     * @param centreY - the y co-ordinate
     */
    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    /**
     * Sets the polygon size
     * @param polygonSize - the size
     */
    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }


    /**
     * Sets the recursive depth of the algorithm
     * @param depth - the recursive depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Sets the shape type
     * @param shapeType - circle, triangle, square, hexagon
     */
    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    /**
     * Sets the shape fill colour
     * @param shapeFillColour - colour to fill the shape
     */
    public void setShapeFillColour(Color shapeFillColour) {
        this.shapeFillColour = shapeFillColour;
    }

    /**
     * Sets the shape line colour
     * @param shapeLineColour - colour of the shape line
     */
    public void setShapeLineColour(Color shapeLineColour) {
        this.shapeLineColour = shapeLineColour;
    }

    /**
     * Sets the shape line width
     * @param shapeLineWidth - width of shape line
     */
    public void setShapeLineWidth(int shapeLineWidth) {
        this.shapeLineWidth = shapeLineWidth;
    }
}