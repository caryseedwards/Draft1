package shapes;

import java.awt.*;

public class Triangle extends Shape {
    public int centerX, centerY;
    public double radius;
    public int x1, y1, x2, y2, x3, y3;

    public Triangle(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
        setVertices();
    }

    public void setVertices() {
        x1 = centerX;
        y1 = (int) (centerY - radius);
        x2 = (int) (centerX - radius * Math.cos(Math.toRadians(30)));
        y2 = (int) (centerY + radius * Math.sin(Math.toRadians(30)));
        x3 = (int) (centerX + radius * Math.cos(Math.toRadians(30)));
        y3 = (int) (centerY + radius * Math.sin(Math.toRadians(30)));
    }

    @Override
    public Point randomPositionInside() {
        double r1 = Math.random();
        double r2 = Math.random();
        if (r1 + r2 > 1) {
            r1 = 1 - r1;
            r2 = 1 - r2;
        }
        int x = (int) ((1 - r1 - r2) * x1 + r1 * x2 + r2 * x3);
        int y = (int) ((1 - r1 - r2) * y1 + r1 * y2 + r2 * y3);
        return new Point(x, y);
    }

    @Override
    public boolean isInside(Circle circle) {
        for (int angle = 0; angle < 360; angle += 5) {
            double rad = Math.toRadians(angle);
            int pointX = (int) (circle.centerX + circle.radius * Math.cos(rad));
            int pointY = (int) (circle.centerY + circle.radius * Math.sin(rad));
            if (!isPointInside(pointX, pointY)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPointInside(int x, int y) {
        Polygon triangle = new Polygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        return triangle.contains(x, y);
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        g2d.setColor(fillColor);
        g2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
    }

    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        setVertices();
    }

    @Override
    public void setScale(double scale) {
        this.radius = scale;
        setVertices();
    }
}
