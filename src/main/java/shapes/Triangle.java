package shapes;

import java.awt.*;

public class Triangle implements PatternShape {
    @Override
    public void draw(Graphics2D g2d, int x, int y, double radius, Color lineColor, float lineWidth, Color fillColor, String lineType) {

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        for (int i = 0; i < 3; i++) {
            xPoints[i] = (int) (x + radius * Math.cos(Math.PI * (i * 2.0 / 3 - 0.5)));
            yPoints[i] = (int) (y + radius * Math.sin(Math.PI * (i * 2.0 / 3 - 0.5)));
        }

        // Set fill color
        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 3);;
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

        g2d.drawPolygon(xPoints, yPoints, 3);
    }
}
