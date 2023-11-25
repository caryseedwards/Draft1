package template.gui.model;
import template.parameters.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * The Model MVC component for the GUI
 * @author carysedwards
 */
public class ParametersModel {
    private CanvasParameters canvas;
    private ArrayList<ShapeParameters> shapes;
    private RecursiveShapeAlgorithmParameters rap;
    private CirclePackingAlgorithmParameters cap;
    private SierpinskiShapeAlgorithmParameters sap;

    /**
     * Creates the Parameters model which is used to control inputs
     * to the algorithms
     */
    public ParametersModel() {
        setCanvasParams(new CanvasParameters(500, 500, Color.WHITE));
        ArrayList<ShapeParameters> shapesDefault = new ArrayList<>();
        shapesDefault.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapesDefault.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        setShapesParams(shapesDefault);
        setRecursiveParams(new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6));
        setPackingParams(new CirclePackingAlgorithmParameters(250, 250, 100, 5, 50, 1000, 2));
        setSierpinskiParams(new SierpinskiShapeAlgorithmParameters(250, 250, 100, 4));
    }

    /**
     * Gets the canvas parameters
     * @return canvas
     */
    public CanvasParameters getCanvasParams() {
        return this.canvas;
    }

    /**
     * Sets the canvas parameters
     * @param canvas - the canvas parameters
     */
    public void setCanvasParams(CanvasParameters canvas) {
        canvas.validateParameters();
        this.canvas = canvas;
    }

    /**
     * Gets the shape parameters
     * @return shapes
     */
    public ArrayList<ShapeParameters> getShapesParams() {
        return this.shapes;
    }

    /**
     * Sets the shape parameters
     * @param shapes - the canvas parameters
     */
    public void setShapesParams(ArrayList<ShapeParameters> shapes) {
        for (ShapeParameters shapeParameters : shapes) {
            shapeParameters.validateParameters();
        }
        this.shapes = shapes;
    }

    /**
     * Gets the recursive shape algorithm parameters
     * @return rap
     */
    public RecursiveShapeAlgorithmParameters getRecursiveParams() {
        return this.rap;
    }

    /**
     * Sets the recursive shape algorithm parameters
     * @param rap - the recursive shape algorithm parameters
     */
    public void setRecursiveParams(RecursiveShapeAlgorithmParameters rap) {
        if (rap.validateParameters()) {
            this.rap = rap;
        }
    }

    /**
     * Gets the Circle Packing algorithm parameters
     * @return cap
     */
    public CirclePackingAlgorithmParameters getPackingParams() {
        return this.cap;
    }

    /**
     * Sets the circle packing algorithm parameters
     * @param cap - the circle packing parameters
     */
    public void setPackingParams(CirclePackingAlgorithmParameters cap) {
        if (cap.validateParameters()) {
            this.cap = cap;
        }
    }

    /**
     * Gets the sierpinski shape parameters
     * @return sap
     */
    public SierpinskiShapeAlgorithmParameters getSierpinskiParams() {
        return this.sap;
    }

    /**
     * Sets the Sierpinski Shape algorithm parameters
     * @param ssp - the Sierpinski Shape parameters
     */
    public void setSierpinskiParams(SierpinskiShapeAlgorithmParameters ssp) {
        if (ssp.validateParameters()) {
            this.sap = ssp;
        }
    }
}
