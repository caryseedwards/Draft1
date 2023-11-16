package withoutgof.shapes;

import java.awt.*;

public class Triangle implements PatternShape {
    public int centerX, centerY;
    public double radius;
    public int x1, y1, x2, y2, x3, y3;

    public Triangle(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
        setVertices();
    }

    public void setVertices(){
        // Vertex 1
        x1 = centerX;
        y1 = (int)(centerY - radius);

        // Vertex 2
        x2 = (int)(centerX - radius * Math.cos(Math.toRadians(30)));
        y2 = (int)(centerY + radius * Math.sin(Math.toRadians(30)));

        // Vertex 3
        x3 = (int)(centerX + radius * Math.cos(Math.toRadians(30)));
        y3 = (int)(centerY + radius * Math.sin(Math.toRadians(30)));
    }


    @Override
    public Point randomPositionInside() {
        double r1 = Math.sqrt(Math.random());
        double r2 = Math.random();
        int x = (int) (r1 * x1 + r2 * x2 + (1 - r1 - r2) * x3);
        int y = (int) (r1 * y1 + r2 * y2 + (1 - r1 - r2) * y3);
        return new Point(x, y);
    }

    @Override
    public boolean isInside(Circle circle) {
        return isPointInside(circle.centerX - (int)circle.radius, circle.centerY) &&
                isPointInside(circle.centerX + (int)circle.radius, circle.centerY) &&
                isPointInside(circle.centerX, circle.centerY - (int)circle.radius) &&
                isPointInside(circle.centerX, circle.centerY + (int)circle.radius);
    }


    public boolean isPointInside(int x, int y) {
        Polygon triangle = new Polygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        return triangle.contains(x, y);
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        g2d.setColor(fillColor);
        g2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
    }

    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        setVertices();
    }

    @Override
    public void setScale(double scale) {
        this.radius = scale;
        setVertices();
    }
}
