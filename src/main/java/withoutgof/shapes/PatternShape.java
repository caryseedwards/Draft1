package withoutgof.shapes;

import java.awt.*;

/**
 * Interface for creating Shapes to be used by the algorithms
 * @author carysedwards
 */
public interface PatternShape {
    /**
     * Generates a random point inside the shape
     * @return a Point inside the shape
     */
    Point randomPositionInside();

    /**
     * Checks if a point is inside the shape
     * @return true if the point is inside the shape
     */
    boolean isInside(Circle circle);

    /**
     * Draws the shape  onto the given graphics object
     * @param g2d - the graphics object to drawn
     * @param lineColor - the line colour of the shape
     * @param lineWidth - the line width of the shape
     * @param fillColor - the fill colour of the shape
     * @param lineType - the line type of the shape
     */
    void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType);

    /**
     * Sets the position of the shape
     * @param x starting x co-ordinate
     * @param y starting y co-ordinate
     */
    void setPosition(int x, int y);

    /**
     * Sets the scaling factor of the shape
     * @param scale the scaling factor
     */
    void setScale(double scale);
}