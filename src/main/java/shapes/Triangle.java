package shapes;

import java.awt.*;
import java.awt.geom.Path2D;

public class Triangle implements PatternShape {
    int x1, y1, x2, y2, x3, y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double area() {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) / 2.0);
    }

    private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) / 2.0);
    }

    public boolean contains(int x, int y) {
        /* Calculate area of triangle ABC */
        double A = area();

        /* Calculate area of triangle PBC */
        double A1 = area(x, y, x2, y2, x3, y3);

        /* Calculate area of triangle PAC */
        double A2 = area(x1, y1, x, y, x3, y3);

        /* Calculate area of triangle PAB */
        double A3 = area(x1, y1, x2, y2, x, y);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    @Override
    public Point randomPositionInside() {
        double r1 = Math.sqrt(Math.random());
        double r2 = Math.random();
        double r3 = 1 - r1 - r2;
        int x = (int) (r1 * x1 + r2 * x2 + r3 * x3);
        int y = (int) (r1 * y1 + r2 * y2 + r3 * y3);
        return new Point(x, y);
    }

    public boolean isInside(Circle circle) {
        for (int angle = 0; angle < 360; angle += 5) {
            double rad = Math.toRadians(angle);
            int pointX = (int) (circle.getX() + circle.radius * Math.cos(rad));
            int pointY = (int) (circle.getY() + circle.radius * Math.sin(rad));
            if (!this.contains(pointX, pointY)) {
                return false;
            }
        }
        return true;
    }

    public Path2D.Double getBounds(double x, double y, double radius) {
        Path2D.Double triangle = new Path2D.Double();
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        for (int i = 0; i < 3; i++) {
            xPoints[i] = (int) (x + radius * Math.cos(Math.PI * (i * 2.0 / 3 - 0.5)));
            yPoints[i] = (int) (y + radius * Math.sin(Math.PI * (i * 2.0 / 3 - 0.5)));
        }
        triangle.moveTo(xPoints[0], yPoints[0]);
        for(int i = 1; i < 3; i++) {
            triangle.lineTo(xPoints[i], yPoints[i]);
        }
        triangle.closePath();
        return triangle;
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType){
        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};

        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    public void drawPrev(Graphics2D g2d, int x, int y, double size, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        int[] xPoints = {x, (int) (x - size / 2), (int) (x + size / 2)};
        int[] yPoints = {(int) (y - size / Math.sqrt(2)), (int) (y + size / Math.sqrt(2)), (int) (y + size / Math.sqrt(2))};

        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    public void drawRadial(Graphics2D g2d, int x, int y, double radius, Color lineColor, float lineWidth, Color fillColor, String lineType) {

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
