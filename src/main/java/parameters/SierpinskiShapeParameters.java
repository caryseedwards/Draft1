package parameters;

import java.awt.*;

public class SierpinskiShapeParameters {
    public int centreX, centreY, polygonSize, depth;
    public Color shapeFillColour, shapeLineColour;
    public int shapeLineWidth;
    public String shapeType;

    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }

    public void setDepth(int depth){this.depth = depth;}

    public void setShapeType(String shapeType){ this.shapeType = shapeType;}

    public void setShapeFillColour(Color shapeFillColour) {
        this.shapeFillColour = shapeFillColour;
    }

    public void setShapeLineColour(Color shapeLineColour) {
        this.shapeLineColour = shapeLineColour;
    }

    public void setShapeLineWidth(int shapeLineWidth) {
        this.shapeLineWidth = shapeLineWidth;
    }
}