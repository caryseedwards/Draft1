package shapes;

import java.awt.*;

public class Square implements PatternShape {
    @Override
    public void draw(Graphics2D g2d, int x, int y, double radius, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        // Set fill color
        g2d.setColor(fillColor);
        g2d.fillRect(x - (int) radius, y - (int) radius, (int) (2 * radius), (int) (2 * radius));

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
        g2d.drawRect(x - (int) radius, y - (int) radius, (int) (2 * radius), (int) (2 * radius));
    }
}
