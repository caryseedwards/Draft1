package parameters;

import java.awt.*;

public class CirclePackingParameters{
    // Canvas parameters
    public int canvasWidth = 500;
    public int canvasHeight = 500;
    public Color backgroundColor = Color.WHITE;
    public int animationSpeed = 1;

    // Boundary shape parameters
    public String boundaryType = "circle";
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

    // Packing circle parameters
    public int minRadius = 5, maxRadius = 20, maxAttempts = 100;
    public Color circleFillColour = Color.YELLOW;
    public Color circleLineColour = Color.BLACK;
    public float circleLineWidth = 1;
    // Setter methods for Canvas parameters
    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    // Setter methods for Boundary shape parameters
    public void setBoundaryType(String boundaryType) {
        this.boundaryType = boundaryType;
    }

    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    public void setCircleRadius(int circleRadius) {
        this.circleRadius = circleRadius;
    }

    public void setRectWidth(int rectWidth) {
        this.rectWidth = rectWidth;
    }

    public void setRectHeight(int rectHeight) {
        this.rectHeight = rectHeight;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
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

    public void setBoundaryLineWidth(float boundaryLineWidth) {
        this.boundaryLineWidth = boundaryLineWidth;
    }

    // Setter methods for Packing circle parameters
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

    public void setCircleLineWidth(float circleLineWidth) {
        this.circleLineWidth = circleLineWidth;
    }
}