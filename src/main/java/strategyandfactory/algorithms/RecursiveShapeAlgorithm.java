package strategyandfactory.algorithms;

import strategyandfactory.parameters.CanvasParameters;
import strategyandfactory.parameters.RecursiveShapeAlgorithmParameters;
import strategyandfactory.parameters.ShapeParameters;
import strategyandfactory.shapes.Shape;
import strategyandfactory.shapes.ShapeFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The implementation of the Recursive Shape algorithm
 * Will recursively draw two shapes in a Euclidean pattern
 * @author carysedwards
 */
public class RecursiveShapeAlgorithm implements AlgorithmStrategy {
    private final ShapeFactory shapeFactory;
    private final ArrayList<Shape> shapesToDraw;
    private final CanvasParameters canvasParameters;
    private final ShapeParameters largeShapeParameters;
    private final ShapeParameters smallShapeParameters;
    private final RecursiveShapeAlgorithmParameters algorithmParameters;

    /**
     * Constructor to create the recursive shape algorithm
     * @param canvasParameters - details of the canvas to draw upon
     * @param shapeParameters - details of the shapes used within the algorithm
     * @param algorithmParameters - details of the algorithm
     */
    public RecursiveShapeAlgorithm(CanvasParameters canvasParameters, ArrayList<ShapeParameters> shapeParameters, RecursiveShapeAlgorithmParameters algorithmParameters) {
        this.canvasParameters = canvasParameters;
        this.algorithmParameters = algorithmParameters;
        this.largeShapeParameters = shapeParameters.get(0);
        this.smallShapeParameters = shapeParameters.get(1);
        this.shapesToDraw = new ArrayList<>();
        this.shapeFactory = new ShapeFactory();
    }

    /**
     * Validates the parameters passed to ensure the algorithm is safe to execute
     * @return True if the parameters used are valid
     */
    @Override
    public boolean validateParameters() {
        return canvasParameters.validateParameters() && largeShapeParameters.validateParameters() && smallShapeParameters.validateParameters() && algorithmParameters.validateParameters();
    }

    /**
     * Executes the algorithm based on the parameters already passed
     */
    @Override
    public void executeAlgorithm() {
        if (validateParameters()) {
            addPattern(algorithmParameters.getCenterX(), algorithmParameters.getCenterY(), algorithmParameters.getInitialSize(), algorithmParameters.getDepth());
        }
    }

    /**
     * Draws the algorithm to the graphics object based on the parameters already passed
     * @param g - The graphics object to draw to
     */
    @Override
    public void drawPattern(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(canvasParameters.getBackgroundColour());
        g2d.fillRect(0, 0, canvasParameters.getWidth(), canvasParameters.getHeight());
        for (Shape shape : shapesToDraw) {
            shape.draw(g2d, shape.getParameters().getLineColour(), shape.getParameters().getLineWidth(),
                    shape.getParameters().getFillColour(), "solid");
        }
    }

    /**
     * The business logic for the recursive algorithm
     * @param x - the starting x co-ordinate for the shape
     * @param y - the starting y co-ordinate for the shape
     * @param size - the size of the shape to draw
     * @param depth - the recusive depth of how many shapes to draw
     */
    public void addPattern(int x, int y, int size, int depth) {
        if (depth == 0) return;
        Shape newLargeShape = shapeFactory.createShape(x, y, size, largeShapeParameters);
        shapesToDraw.add(newLargeShape);
        double angleStep = Math.PI * 2 / algorithmParameters.getNumShapes();
        int smallerSize = (int) (size * Math.sin(angleStep / 2));

        for (int i = 0; i < algorithmParameters.getNumShapes(); i++) {
            double angle = i * angleStep;
            int newX = (int) (x + size * Math.cos(angle));
            int newY = (int) (y + size * Math.sin(angle));

            Shape newSmallShape = shapeFactory.createShape(newX, newY, smallerSize, smallShapeParameters);
            shapesToDraw.add(newSmallShape);
            addPattern(newX, newY, smallerSize, depth - 1);
        }
    }

    /**
     * Saves the current state of the algorithm to a PNG file at the specified path
     * @param filePath The file path where the image will be saved
     */
    public void saveImage(String filePath) {
        BufferedImage image = new BufferedImage(canvasParameters.getWidth(), canvasParameters.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        drawPattern(g2d);

        try {
            File file = new File(filePath);
            ImageIO.write(image, "PNG", file);
        } catch (IOException ex) {
            System.err.println("Error saving image: " + ex.getMessage());
        } finally {
            g2d.dispose();
        }
    }

    /**
     * Gets the shapes already calculated to draw to the canvas
     * @return shapesToDraw
     */
    public ArrayList<Shape> getShapesToDraw() {
        return shapesToDraw;
    }

    /**
     * Gets the large shape parameters selected for this algorithm
     * @return largeShapeParameters
     */
    public ShapeParameters getLargeShapeParameters() {
        return largeShapeParameters;
    }

    /**
     * Gets the small shape parameters selected for this algorithm
     * @return smallShapeParameters
     */
    public ShapeParameters getSmallShapeParameters() {
        return smallShapeParameters;
    }
}
