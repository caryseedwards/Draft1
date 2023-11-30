package version3.shapes;

import java.awt.*;

/**
 * Implements a Hexagon Shape to use in the algorithms
 * @author carysedwards
 */
public class Hexagon implements PatternShape {
    public int centerX, centerY;
    public double radius;

    /**
     * Constructor for a hexagon object
     * @param x - the starting x co-ordinate
     * @param y - the starting y co-ordinate
     * @param radius - the scaling factor for the hexagon
     */
    public Hexagon(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    /**
     * Calculates a random position inside the hexagon
     * @return A new point containing co-ordinates for a random point in the hexagon
     */
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

    /**
     * Calculates a random position inside the hexagon
     * @return A new point containing co-ordinates for a random point in the hexagon
     */
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

    /**
     * Helper method to check if a hexagon is inside a circle
     * @param circle - the circle
     * @return True if the hexagon fits inside the circle
     */
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

    /**
     * Draws the hexagon onto the given graphics object
     * @param g2d - the graphics object to drawn
     * @param lineColor - the line colour of the hexagon
     * @param lineWidth - the line width of the hexagon
     * @param fillColor - the fill colour of the hexagon
     * @param lineType - the line type of the hexagon
     */
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

    /**
     * Sets the starting x and y co-ordinates of the hexagon
     * @param x - the x co-ordinate
     * @param y - the y co-ordinate
     */
    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    /**
     * Sets the scaling factor for the hexagon
     * @param scale - the scale of the hexagon
     */
    @Override
    public void setScale(double scale) {
        this.radius = scale;
    }
}
