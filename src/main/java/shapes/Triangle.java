package shapes;

import java.awt.*;

public class Triangle implements PatternShape {
    int centerX, centerY;
    double radius;
    int x1, y1, x2, y2, x3, y3;

    public Triangle(int x, int y, double radius) {
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
        setVertices();
    }
    public void setVertices(){
        // Vertex 1
         x1 = (int)(centerX + radius * Math.cos(Math.toRadians(0)));
         y1 = (int)(centerY + radius * Math.sin(Math.toRadians(0)));

        // Vertex 2
         x2 = (int)(centerX + radius * Math.cos(Math.toRadians(120)));
         y2 = (int)(centerY + radius * Math.sin(Math.toRadians(120)));

        // Vertex 3
         x3 = (int)(centerX + radius * Math.cos(Math.toRadians(240)));
         y3 = (int)(centerY + radius * Math.sin(Math.toRadians(240)));
    }

    public int[] getVertices() {
        return new int[]{x1, y1, x2, y2, x3, y3};
    }

    @Override
    public Point randomPositionInside() {
        double r1 = Math.sqrt(Math.random());
        double r2 = Math.random();
        int[] vertices = getVertices();
        int x = (int) (r1 * vertices[0] + r2 * vertices[2] + (1 - r1 - r2) * vertices[4]);
        int y = (int) (r1 * vertices[1] + r2 * vertices[3] + (1 - r1 - r2) * vertices[5]);
        return new Point(x, y);
    }

    @Override
    public boolean isInside(Circle circle) {
        int[] vertices = getVertices();
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

    public boolean isPointInside(int x, int y) {
        // Logic to check if a point (x, y) is inside the triangle
        int[] vertices = getVertices();
        int[] xPoints = {vertices[0], vertices[2], vertices[4]};
        int[] yPoints = {vertices[1], vertices[3], vertices[5]};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        return triangle.contains(x, y);
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        int[] vertices = getVertices();
        int[] xPoints = {vertices[0], vertices[2], vertices[4]};
        int[] yPoints = {vertices[1], vertices[3], vertices[5]};

        g2d.setColor(fillColor);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void setPosition(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    @Override
    public void setScale(double scale) {
        this.radius = scale;
    }

}
