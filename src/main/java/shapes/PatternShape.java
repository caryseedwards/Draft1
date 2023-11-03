package shapes;

import java.awt.*;

public interface PatternShape {
        Point randomPositionInside();
        boolean isInside(Circle circle);
        void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType);
        void setPosition(int x, int y);
        void setScale(double scale);
}