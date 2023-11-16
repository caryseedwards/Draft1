package template.shapes;

import java.awt.*;

public class Hexagon extends Shape {
    public int centerX, centerY;
    public double radius;

    public Hexagon(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    @Override
    public Point randomPositionInside() {
        int x, y;
        do {
            double angle = Math.random() * Math.PI * 2;
            double distance = Math.random() * radius;
            x = centerX + (int) (distance * Math.cos(angle));
            y = centerY + (int) (distance * Math.sin(angle));
        } while (!isPointInside(x, y));
        return new Point(x, y);
    }

    public boolean isPointInside(int x, int y) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];
        for (int i = 0; i < 6; i++) {
            xPoints[i] = (int) (centerX + radius * Math.cos(i * Math.PI / 3));
            yPoints[i] = (int) (centerY + radius * Math.sin(i * Math.PI / 3));
        }
        Polygon hexagon = new Polygon(xPoints, yPoints, 6);
        return hexagon.contains(x, y);
    }

    @Override
    public boolean isInside(Circle circle) {
        for (int angle = 0; angle < 360; angle += 5) {
            double rad = Math.toRadians(angle);
            int pointX = (int) (circle.getX() + circle.getRadius() * Math.cos(rad));
            int pointY = (int) (circle.getY() + circle.getRadius() * Math.sin(rad));
            if (!isPointInside(pointX, pointY)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];
        for (int i = 0; i < 6; i++) {
            xPoints[i] = (int) (centerX + radius * Math.cos(i * Math.PI / 3));
            yPoints[i] = (int) (centerY + radius * Math.sin(i * Math.PI / 3));
        }

        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 6);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(xPoints, yPoints, 6);
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
}
