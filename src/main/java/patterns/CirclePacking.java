package patterns;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class CirclePacking extends JPanel {

    // General Parameters
    private Color backgroundColor;
    private Color circleColor;
    private Color boundaryColor;
    private int canvasWidth;
    private int canvasHeight;
    private int animationSpeed;

    // Circle Parameters
    private int minRadius;
    private int maxRadius;
    private int maxAttempts;

    // Boundary Parameters
    private String boundaryType;

    private final ArrayList<Circle> circles;
    private Circle boundaryCircle;
    private Rectangle boundarySquare;
    private Path2D boundaryTriangle;
    private Path2D boundaryHexagon;

    public CirclePacking(String boundaryType, int maxRadius, int minRadius, int timeInterval) {
        circles = new ArrayList<>();
        initParams(boundaryType, maxRadius, minRadius, timeInterval, Color.WHITE, Color.BLACK, Color.RED, 800, 800);
    }

    public void setGeneralParams(Color bg, Color cc, Color bc, int width, int height, int speed) {
        initParams(boundaryType, maxRadius, minRadius, speed, bg, cc, bc, width, height);
    }

    public void setCircleParams(int minRad, int maxRad, int maxAttempts) {
        this.minRadius = minRad;
        this.maxRadius = maxRad;
        this.maxAttempts = maxAttempts;
    }

    private void initParams(String boundaryType, int maxRad, int minRad, int speed,
                            Color bg, Color cc, Color bc, int width, int height) {
        this.boundaryType = boundaryType;
        this.maxRadius = maxRad;
        this.minRadius = minRad;
        this.animationSpeed = speed;
        this.backgroundColor = bg;
        this.circleColor = cc;
        this.boundaryColor = bc;
        this.canvasWidth = width;
        this.canvasHeight = height;

        setBoundary(boundaryType);
    }

    public void setBoundary(String type) {
        boundaryType = type;
        switch (type) {
            case "circle":
                boundaryCircle = new Circle(400, 400, 300);
                break;
            case "square":
                boundarySquare = new Rectangle(200, 200, 400, 400);
                break;
            case "triangle":
                boundaryTriangle = new Path2D.Double();
                boundaryTriangle.moveTo(400, 100);
                boundaryTriangle.lineTo(100, 700);
                boundaryTriangle.lineTo(700, 700);
                boundaryTriangle.closePath();
                break;
            case "hexagon":
                boundaryHexagon = new Path2D.Double();
                for (int i = 0; i < 6; i++) {
                    int x = (int) (400 + 300 * Math.cos(i * Math.PI / 3));
                    int y = (int) (400 + 300 * Math.sin(i * Math.PI / 3));
                    if (i == 0) {
                        boundaryHexagon.moveTo(x, y);
                    } else {
                        boundaryHexagon.lineTo(x, y);
                    }
                }
                boundaryHexagon.closePath();
                break;
        }
    }

    public void addCircle() {
        int radius = minRadius + (int) (Math.random() * (maxRadius - minRadius));

        for (int i = 0; i < maxAttempts; i++) {
           // int radius = minRadius + (int) (Math.random() * maxRadius);
            int x = 0, y = 0;
            Circle newCircle;

            switch (boundaryType) {
                case "circle":
                    x = boundaryCircle.x - boundaryCircle.radius + radius +
                            (int) (Math.random() * (2 * boundaryCircle.radius - 2 * radius));
                    y = boundaryCircle.y - boundaryCircle.radius + radius +
                            (int) (Math.random() * (2 * boundaryCircle.radius - 2 * radius));
                    break;
                case "square":
                    x = boundarySquare.x + radius +
                            (int) (Math.random() * (boundarySquare.width - 2 * radius));
                    y = boundarySquare.y + radius +
                            (int) (Math.random() * (boundarySquare.height - 2 * radius));
                    break;
                case "triangle":
                    double r1 = Math.sqrt(Math.random());
                    double r2 = Math.random();
                    double r3 = 1 - r1 - r2;
                    x = (int) (r1 * 400 + r2 * 100 + r3 * 700);
                    y = (int) (r1 * 100 + r2 * 700 + r3 * 700);
                    break;
                case "hexagon":
                    double angle = Math.random() * Math.PI * 2; // Angle in radians
                    double distance = Math.random() * (300 - radius); // Distance from center
                    x = 400 + (int) (distance * Math.cos(angle));
                    y = 400 + (int) (distance * Math.sin(angle));
                    break;
            }
            newCircle = new Circle(x, y, radius);

            boolean overlaps = circles.stream().anyMatch(newCircle::overlaps);

            if (!overlaps) {
                boolean isInside = false;
                switch (boundaryType) {
                    case "circle":
                        isInside = newCircle.isInside(boundaryCircle);
                        break;
                    case "square":
                        isInside = boundarySquare.contains(newCircle.x, newCircle.y);
                        break;
                    case "triangle":
                        // Check if the circle is fully inside the triangle.
                        for (int angle = 0; angle < 360; angle += 5) {  // You can adjust the step
                            double rad = Math.toRadians(angle);
                            int pointX = (int) (newCircle.x + radius * Math.cos(rad));
                            int pointY = (int) (newCircle.y + radius * Math.sin(rad));
                            if (!boundaryTriangle.contains(pointX, pointY)) {
                                isInside = false;
                                break;
                            }
                            isInside = true;
                        }
                        break;
                    case "hexagon":
                        isInside = true; // Assume true, and set to false if we find a counter-example.
                        // Check if the circle is fully inside the hexagon.
                        for (int angle = 0; angle < 360; angle += 5) {
                            double rad = Math.toRadians(angle);
                            int pointX = (int) (newCircle.x + radius * Math.cos(rad));
                            int pointY = (int) (newCircle.y + radius * Math.sin(rad));
                            if (!boundaryHexagon.contains(pointX, pointY)) {
                                isInside = false; // Set to false as soon as we find one point outside
                                break;
                            }
                        }
                        break;
                    default:
                        isInside = false;
                }

                if (isInside) {
                    circles.add(newCircle);
                    return;
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, canvasWidth, canvasHeight);

        // Set boundary color
        g2d.setColor(boundaryColor);


        switch (boundaryType) {
            case "circle":
                g2d.drawOval(boundaryCircle.x - boundaryCircle.radius, boundaryCircle.y - boundaryCircle.radius,
                        2 * boundaryCircle.radius, 2 * boundaryCircle.radius);
                break;
            case "square":
                g2d.drawRect(boundarySquare.x, boundarySquare.y, boundarySquare.width, boundarySquare.height);
                break;
            case "triangle":
                g2d.draw(boundaryTriangle);
                break;
            case "hexagon":
                g2d.draw(boundaryHexagon);
                break;
        }

        // Set circle color
        g2d.setColor(circleColor);

        for (Circle circle : circles) {
            g2d.drawOval(circle.x - circle.radius, circle.y - circle.radius, 2 * circle.radius, 2 * circle.radius);
        }
    }

    private static class Circle {
        int x, y, radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public boolean overlaps(Circle other) {
            int dx = this.x - other.x;
            int dy = this.y - other.y;
            int distance = dx * dx + dy * dy;
            return distance < (this.radius + other.radius) * (this.radius + other.radius);
        }

        public boolean isInside(Circle boundary) {
            int dx = this.x - boundary.x;
            int dy = this.y - boundary.y;
            int distance = dx * dx + dy * dy;
            return distance <= (boundary.radius - this.radius) * (boundary.radius - this.radius);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Packing in Shapes");

        // Instantiate CirclePacking with some initial values
        CirclePacking packing = new CirclePacking("triangle", 100, 10, 100);

        // Update general parameters
        packing.setGeneralParams(Color.WHITE, Color.BLACK, Color.RED, 1000, 1000, 1);

        // Update circle parameters
        packing.setCircleParams(5, 50, 100);

        frame.add(packing);
        frame.setSize(packing.canvasWidth, packing.canvasHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(packing.animationSpeed, e -> {
            packing.addCircle();
            packing.repaint();
        });
        timer.start();
    }

}
