package version3.shapes;

import java.awt.*;

/**
 * Implements a Square Shape to use in the algorithms
 * @author carysedwards
 */
public class Square implements PatternShape {
    public int centerX, centerY;
    public double radius;

    /**
     * Constructor for a square object
     * @param x - the starting x co-ordinate
     * @param y - the starting y co-ordinate
     * @param radius - the scaling factor for the square
     */
    public Square(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    /**
     * Helper method to check if a Square is inside a circle
     * @param circle - the circle
     * @return True if the square fits inside of the circle
     */
    @Override
    public boolean isInside(Circle circle) {
        double sideLength = 2 * radius;
        return circle.centerX - circle.getRadius() >= this.centerX - sideLength / 2 &&
                circle.centerX + circle.getRadius() <= this.centerX + sideLength / 2 &&
                circle.centerY - circle.getRadius() >= this.centerY - sideLength / 2 &&
                circle.centerY + circle.getRadius() <= this.centerY + sideLength / 2;
    }

    /**
     * Calculates a random position inside the square
     * @return A new point containing co-ordinates for a random point in the square
     */
    @Override
    public Point randomPositionInside() {
        double sideLength = 2 * radius;
        int x = (int) (this.centerX + (Math.random() * sideLength) - sideLength / 2);
        int y = (int) (this.centerY + (Math.random() * sideLength) - sideLength / 2);
        return new Point(x, y);
    }

    /**
     * Draws the square onto the given graphics object
     * @param g2d - the graphics object to drawn
     * @param lineColor - the line colour of the square
     * @param lineWidth - the line width of the square
     * @param fillColor - the fill colour of the square
     * @param lineType - the line type of the square
     */
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

    /**
     * Sets the starting x and y co-ordinates of the square
     * @param x - the x co-ordinate
     * @param y - the y co-ordinate
     */
    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    /**
     * Sets the scaling factor for the square
     * @param scale - the scale of the square
     */
    @Override
    public void setScale(double scale) {
        this.radius = scale;
    }
}
