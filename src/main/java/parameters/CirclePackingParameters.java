package parameters;

import java.awt.*;

public class CirclePackingParameters{
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

    public void setBoundaryType(String boundaryType) {
        this.boundaryType = boundaryType;
    }

    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }

    public void setBoundaryFillColour(Color boundaryFillColour) {
        this.boundaryFillColour = boundaryFillColour;
    }

    public void setBoundaryLineColour(Color boundaryLineColour) {
        this.boundaryLineColour = boundaryLineColour;
    }

    public void setBoundaryLineWidth(int boundaryLineWidth) {
        this.boundaryLineWidth = boundaryLineWidth;
    }

    public void setMinRadius(int minRadius) {
        this.minRadius = minRadius;
    }

    public void setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setCircleFillColour(Color circleFillColour) {
        this.circleFillColour = circleFillColour;
    }

    public void setCircleLineColour(Color circleLineColour) {
        this.circleLineColour = circleLineColour;
    }

    public void setCircleLineWidth(int circleLineWidth) {
        this.circleLineWidth = circleLineWidth;
    }
}