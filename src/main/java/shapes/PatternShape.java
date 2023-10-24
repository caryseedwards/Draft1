package shapes;

import java.awt.*;

public interface PatternShape {
        void draw(Graphics2D g2d, int x, int y, double radius, Color lineColor, float lineWidth, Color fillColor, String lineType);
}
