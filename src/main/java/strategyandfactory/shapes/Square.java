package strategyandfactory.shapes;

import java.awt.*;

public class Square extends Shape {
    private int centerX;
    private int centerY;
    private double radius;

    public Square(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    @Override
    public boolean isInside(Circle circle) {
        double sideLength = 2 * radius;
        return circle.getCenterX() - circle.getRadius() >= this.centerX - sideLength / 2 &&
                circle.getCenterX() + circle.getRadius() <= this.centerX + sideLength / 2 &&
                circle.getCenterY() - circle.getRadius() >= this.centerY - sideLength / 2 &&
                circle.getCenterY() + circle.getRadius() <= this.centerY + sideLength / 2;
    }

    @Override
    public Point randomPositionInside() {
        double sideLength = 2 * radius;
        int x = (int) (this.centerX + (Math.random() * sideLength) - sideLength / 2);
        int y = (int) (this.centerY + (Math.random() * sideLength) - sideLength / 2);
        return new Point(x, y);
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        double sideLength = 2 * radius;
        double x = centerX - (sideLength / 2);
        double y = centerY - (sideLength / 2);

        g2d.setColor(fillColor);
        g2d.fillRect((int) x, (int) y, (int) sideLength, (int) sideLength);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawRect((int) x, (int) y, (int) sideLength, (int) sideLength);
    }

    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    @Override
    public void setScale(double scale) {
        this.radius = scale;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }
}