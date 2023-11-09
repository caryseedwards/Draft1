package shapes;

import java.awt.*;

public class Circle extends Shape {
    public int centerX, centerY;
    public double radius;

    public Circle(int x, int y, int radius) {
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
        double radiusScale = Math.sqrt(Math.random());
        int newX = (int) (centerX + radius * radiusScale * Math.cos(angle));
        int newY = (int) (centerY + radius * radiusScale * Math.sin(angle));
        return new Point(newX, newY);
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

}
