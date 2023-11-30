package version2.shapes;

import java.awt.*;

/**
 * Implements a Circle Shape to use in the algorithms
 */
public class Circle extends Shape {
    private int centerX;
    private int centerY;
    private double radius;

    /**
     * Constructor for a circle object
     * @param x - the starting x co-ordinate
     * @param y - the starting y co-ordinate
     * @param radius - the scaling factor for the circle
     */
    public Circle(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    /**
     * Checks if this circle overlaps another circle 
     * @param other - the other circle
     * @return true if the circles overlap
     */
    public boolean overlaps(Circle other) {
        int dx = this.centerX - other.centerX;
        int dy = this.centerY - other.centerY;
        int distance = dx * dx + dy * dy;
        return distance < (this.radius + other.radius) * (this.radius + other.radius);
    }

    /**
     * Calculates a random position inside the circle
     * @return A new point containing co-ordinates for a random point in the circle
     */
    @Override
    public Point randomPositionInside() {
        double angle = 2 * Math.PI * Math.random();
        double radiusScale = Math.random();
        double scaledRadius = radius * Math.sqrt(radiusScale);
        double newX = centerX + scaledRadius * Math.cos(angle);
        double newY = centerY + scaledRadius * Math.sin(angle);
        int finalX;
        if (newX >= centerX) {
            finalX = (int) Math.floor(newX);
        } else {
            finalX = (int) Math.ceil(newX);
        }

        int finalY;
        if (newY >= centerY) {
            finalY = (int) Math.floor(newY);
        } else {
            finalY = (int) Math.ceil(newY);
        }
        return new Point(finalX, finalY);
    }

    /**
     * Helper method to check this circle is inside another circle
     * @param boundary - the other circle
     * @return true if this circle is inside another circle
     */
    @Override
    public boolean isInside(Circle boundary) {
        int dx = this.centerX - boundary.centerX;
        int dy = this.centerY - boundary.centerY;
        int distance = dx * dx + dy * dy;
        return distance <= (boundary.radius - this.radius) * (boundary.radius - this.radius);
    }

    /**
     * Draws the circle onto the given graphics object
     * @param g2d - the graphics object to drawn
     * @param lineColor - the line colour of the circle
     * @param lineWidth - the line width of the circle
     * @param fillColor - the fill colour of the circle
     * @param lineType - the line type of the circle
     */
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

    /**
     * Sets the starting x and y co-ordinates of the circle
     * @param x - the x co-ordinate
     * @param y - the y co-ordinate
     */
    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    /**
     * Sets the scaling factor for the circle
     * @param size - the scale of the circle
     */
    @Override
    public void setScale(double size) {
        this.radius = size;
    }

    /**
     * Gets the circle's centrex co-ordinate
     * @return centerX
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * Gets the circle's centrey co-ordinate
     * @return centerY
     */
    public int getCenterY() {
        return centerY;
    }
    
    /**
     * Gets the circle's centrex co-ordinate
     * @return centerX
     */
    public int getX() {
        return centerX;
    }

    /**
     * Gets the circle's centrey co-ordinate
     * @return centerY
     */
    public int getY() {
        return centerY;
    }

    /**
     * Gets the circle's radius / scaling factor
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

}
