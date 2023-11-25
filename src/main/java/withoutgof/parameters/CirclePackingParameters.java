package withoutgof.parameters;

import java.awt.*;

/**
 * Responsible for housing and configuring the specific Circle Packing Algorithm values
 * @author carysedwards
 */
public class CirclePackingParameters {
    public int canvasWidth = 500;
    public int canvasHeight = 500;
    public Color backgroundColor = Color.WHITE;
    public int animationSpeed = 1;

    public String boundaryType = "triangle";
    public int centreX = 250;
    public int centreY = 250;
    public int polygonSize = 111;
    public Color boundaryFillColour = Color.WHITE;
    public Color boundaryLineColour = Color.RED;
    public int boundaryLineWidth = 1;

    public int minRadius = 5, maxRadius = 22, maxAttempts = 100;
    public Color circleFillColour = Color.YELLOW;
    public Color circleLineColour = Color.BLACK;
    public int circleLineWidth = 1;

    /**
     * Sets the boundary shape
     * @param boundaryType - the type of shape
     */
    public void setBoundaryType(String boundaryType) {
        this.boundaryType = boundaryType;
    }

    /**
     * Sets the center X co-ordinate
     * @param centreX - the x co-ordinate
     */
    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    /**
     * Sets the center Y co-ordinate
     * @param centreY - the y co-ordinate
     */
    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    /**
     * Sets the boundary polygon size
     * @param polygonSize - boundary polygon size
     */
    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }

    /**
     * Sets the boundary fill colour
     * @param boundaryFillColour - colour for the boundary shape
     */
    public void setBoundaryFillColour(Color boundaryFillColour) {
        this.boundaryFillColour = boundaryFillColour;
    }

    /**
     * Sets the boundary line colour
     * @param boundaryLineColour - colour for the boundary line
     */
    public void setBoundaryLineColour(Color boundaryLineColour) {
        this.boundaryLineColour = boundaryLineColour;
    }

    /**
     * Sets the boundary line width
     * @param boundaryLineWidth - width of boundary line
     */
    public void setBoundaryLineWidth(int boundaryLineWidth) {
        this.boundaryLineWidth = boundaryLineWidth;
    }

    /**
     * Sets the minimum radius for filling circles
     * @param minRadius - minimum size of filling circles
     */
    public void setMinRadius(int minRadius) {
        this.minRadius = minRadius;
    }

    /**
     * Sets the maximum radius for filling circles
     * @param maxRadius - maximum size of filling circles
     */
    public void setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
    }

    /**
     * sets the maximum number of attempts to place a circle before the algorithm terminates
     * @param maxAttempts - number of attempts
     */
    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    /**
     * Sets the filling circle fill colour
     * @param circleFillColour - colour for fill circles
     */
    public void setCircleFillColour(Color circleFillColour) {
        this.circleFillColour = circleFillColour;
    }

    /**
     * Sets the filling circle line colours
     * @param circleLineColour - filling circle line colours
     */
    public void setCircleLineColour(Color circleLineColour) {
        this.circleLineColour = circleLineColour;
    }

    /**
     * Sets the filling circle line width
     * @param circleLineWidth - filling circle line width
     */
    public void setCircleLineWidth(int circleLineWidth) {
        this.circleLineWidth = circleLineWidth;
    }
}