package template.shapes;

import template.parameters.ShapeParameters;

import java.awt.*;

public abstract class Shape {
    public ShapeParameters params;

    public abstract Point randomPositionInside();

    public abstract boolean isInside(Circle circle);

    public abstract void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType);

    public abstract void setPosition(int x, int y);

    public abstract void setScale(double scale);

    public ShapeParameters getShapeParameters() {
        return this.params;
    }

    public void setShapeParameters(ShapeParameters params) {
        this.params = params;
    }
}