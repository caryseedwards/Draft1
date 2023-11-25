package template.algorithms;

import template.parameters.CanvasParameters;
import template.parameters.Parameters;
import template.parameters.ShapeParameters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Parent abstract class for the three types of algorithms
 * @author carysedwards
 */
public abstract class Algorithm extends JPanel {
    public Graphics2D pattern;
    private CanvasParameters canvasParams = new CanvasParameters(0, 0, Color.WHITE);
    private ArrayList<ShapeParameters> shapeParams = new ArrayList<>();
    private Parameters algorithmParams;

    /**
     * Creates an algorithm based on input parameters
     * @param canvasParams - the canvas parameters
     * @param shapeParams -the shape parameters
     * @param algorithmParams - the algorithm parameters
     */
    public Algorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
        setAlgorithmParams(algorithmParams);
        setCanvasParameters(canvasParams);
        setShapeParameters(shapeParams);
    }

    /**
     * Initialises the algorithm
     */
    protected abstract void initialiseAlgorithm();

    public boolean validateParameters() {
        return canvasParams.validateParameters() &&
                algorithmParams.validateParameters() &&
                shapeParams.stream().allMatch(ShapeParameters::validateParameters);
    }

    /**
     * Executes the algorithm
     */
    public abstract void executeAlgorithm();

    /**
     * Draws the algorithm output to the graphics object
     * @param g - the graphics object
     */
    public abstract void drawPattern(Graphics g);

    /**
     * Paints the graphics object to the canvas
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPattern(g);
    }

    /**
     * Gets the canvas parameters
     * @return canvasParams
     */
    public CanvasParameters getCanvasParameters() {
        return this.canvasParams;
    }

    /**
     * Sets the canvas parameters
     * @param canvasParams - the canvas parameters
     */
    public void setCanvasParameters(CanvasParameters canvasParams) {
        this.canvasParams = canvasParams;
         validateParameters();
    }

    /**
     * Gets the shape parameters
     * @return shapeParams
     */
    public ArrayList<ShapeParameters> getShapeParameters() {
        return shapeParams;
    }

    /**
     * Sets the shape parameters
     * @param shapeParams - the shape parameters
     */
    public void setShapeParameters(ArrayList<ShapeParameters> shapeParams) {
        this.shapeParams = shapeParams;
        validateParameters();
    }

    /**
     * Gets the algorithm parameters
     * @return algorithmParams
     */
    public Parameters getAlgorithmParams() {
        return algorithmParams;
    }

    /**
     * Sets the algorithm parameters
     * @param algorithmParams - the algorithm parameters
     */
    public void setAlgorithmParams(Parameters algorithmParams) {
        this.algorithmParams = algorithmParams;
        validateParameters();
    }
}
