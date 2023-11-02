package shapes;

import java.awt.*;

public class Square implements PatternShape {
    public int centerX;
    public int centerY;
    public double width;
    public double height;

    public Square(int x, int y, double width, double height) {
        this.centerX = x;
        this.centerY = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return centerX;
    }

    public int getY() {
        return centerY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean isInside(Circle circle) {
        return circle.centerX - circle.radius >= this.centerX - this.width/2 &&
                circle.centerX + circle.radius <= this.centerX + this.width/2 &&
                circle.centerY - circle.radius >= this.centerY - this.height/2 &&
                circle.centerY + circle.radius <= this.centerY + this.height/2;
    }
    @Override
    public Point randomPositionInside() {
        int x = this.centerX + (int) (Math.random() * width) - (int) width/2;
        int y = this.centerY + (int) (Math.random() * height) - (int) height/2;
        return new Point(x, y);
    }

    @Override
    public void draw(Graphics2D g2d, Color lineColor, float lineWidth, Color fillColor, String lineType){
        int x = centerX - (int) (width / 2);
        int y = centerY - (int) (height / 2);

        g2d.setColor(fillColor);
        g2d.fillRect(x, y, (int) width, (int) height);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawRect(x, y, (int) width, (int) height);
    }

    public void drawPrev(Graphics2D g2d, int x, int y, double size, Color lineColor, float lineWidth, Color fillColor, String lineType) {
        g2d.setColor(fillColor);
        g2d.fillRect(x - (int) size / 2, y - (int) size / 2, (int) size, (int) size);

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(lineWidth));
        g2d.drawRect(x - (int) size / 2, y - (int) size / 2, (int) size, (int) size);
    }

    public void drawRadial(Graphics2D g2d, int x, int y, double radius, Color lineColor, float lineWidth, Color fillColor, String lineType) {
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
