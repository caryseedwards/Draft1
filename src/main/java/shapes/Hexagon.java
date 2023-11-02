package shapes;

import java.awt.*;
import java.awt.geom.Path2D;

public class Hexagon implements PatternShape {

    public int x;
    public int y;
    public double size;
    private Path2D boundaryHexagon;

    public Hexagon(int x, int y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
        boundaryHexagon = getBounds(x, y, size);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getSize() {
        return size;
    }

    @Override
    public Point randomPositionInside() {
        int x, y;
        do {
            double angle = Math.random() * Math.PI * 2;
            double distance = Math.random() * size;
            x = this.x + (int) (distance * Math.cos(angle));
            y = this.y + (int) (distance * Math.sin(angle));
        } while (!boundaryHexagon.contains(x, y));
        return new Point(x, y);
    }

    public Path2D.Double getBounds(double x, double y, double radius) {
        Path2D.Double hexagon = new Path2D.Double();
        for (int i = 0; i < 6; i++) {
            int xPoint = (int) (x + radius * Math.cos(i * Math.PI / 3));
            int yPoint = (int) (y + radius * Math.sin(i * Math.PI / 3));
            if (i == 0) {
                hexagon.moveTo(xPoint, yPoint);
            } else {
                hexagon.lineTo(xPoint, yPoint);
            }
        }
        hexagon.closePath();
        return hexagon;
    }

    @Override
    public boolean isInside(Circle circle) {
        boolean isInside = true; // Assume true, and set to false if we find a counter-example.
        // Check if the circle is fully inside the hexagon.
        for (int angle = 0; angle < 360; angle += 5) {
            double rad = Math.toRadians(angle);
            int pointX = (int) (circle.getX() + circle.getRadius() * Math.cos(rad));
            int pointY = (int) (circle.getY() + circle.getRadius() * Math.sin(rad));
            if (!boundaryHexagon.contains(pointX, pointY)) {
                isInside = false; // Set to false as soon as we find one point outside
            }
        }
        return isInside;
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];
        for (int i = 0; i < 6; i++) {
            xPoints[i] = (int) (x + size * Math.cos(i * Math.PI / 3));
            yPoints[i] = (int) (y + size * Math.sin(i * Math.PI / 3));
        }

        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 6);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(xPoints, yPoints, 6);
    }

    public void drawRadial(Graphics2D g2d, int x, int y, double radius, Color lineColor, float lineWidth, Color fillColor, String lineType) {

        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            xPoints[i] = (int) (x + radius * Math.cos(Math.PI * (i / 3.0)));
            yPoints[i] = (int) (y + radius * Math.sin(Math.PI * (i / 3.0)));
        }
        // Set fill color
        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 6);

        // Set line color and type
        g2d.setColor(lineColor);
        if ("dashed".equals(lineType)) {
            float[] dash = {5.0f};
            g2d.setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dash, 0.0f));
        } else if ("dotted".equals(lineType)) {
            float[] dash = {1.0f};
            g2d.setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dash, 0.0f));
        } else {
            g2d.setStroke(new BasicStroke(lineWidth));
        }
        g2d.drawPolygon(xPoints, yPoints, 6);
    }
}
