package strategyandfactory.shapes;

import java.awt.*;

public class Circle extends Shape {
    private int centerX;
    private int centerY;
    private double radius;

    public Circle(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    public int getX() {
        return centerX;
    }

    public int getY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    public boolean overlaps(Circle other) {
        int dx = this.centerX - other.centerX;
        int dy = this.centerY - other.centerY;
        int distance = dx * dx + dy * dy;
        return distance < (this.radius + other.radius) * (this.radius + other.radius);
    }

    @Override
    public Point randomPositionInside() {
        double angle = 2 * Math.PI * Math.random();
        double radiusScale = Math.random();
        double scaledRadius = radius * Math.sqrt(radiusScale);
        double newX = centerX + scaledRadius * Math.cos(angle);
        double newY = centerY + scaledRadius * Math.sin(angle);
        int finalX = (int) (newX >= centerX ? Math.floor(newX) : Math.ceil(newX));
        int finalY = (int) (newY >= centerY ? Math.floor(newY) : Math.ceil(newY));
        return new Point(finalX, finalY);
    }

    @Override
    public boolean isInside(Circle boundary) {
        int dx = this.centerX - boundary.centerX;
        int dy = this.centerY - boundary.centerY;
        int distance = dx * dx + dy * dy;
        return distance <= (boundary.radius - this.radius) * (boundary.radius - this.radius);
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        int x = centerX - (int) radius;
        int y = centerY - (int) radius;
        int diameter = (int) (radius * 2);

        g2d.setColor(fillColor);
        g2d.fillOval(x, y, diameter, diameter);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawOval(x, y, diameter, diameter);
    }

    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    @Override
    public void setScale(double size) {
        this.radius = size;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

}
