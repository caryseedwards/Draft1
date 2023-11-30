package version2.gui.controller;

import version2.gui.model.ParametersModel;
import version2.gui.view.panel.RecursivePanelView;
import version2.gui.view.Utilities;
import version2.validate.Validate;

import java.awt.*;

/**
 * The controller for the Recursive Shape algorithm via the GUI
 * Part of the MVC pattern
 * @author carysedwards
 */
public class RecursiveShapeController {
    private final RecursivePanelView view;
    private final ParametersModel model;

    /**
     * Creates the Recursive Shape controller
     * @param model - the corresponding model for the controller
     * @param view - the corresponding view for the controller
     */
    public RecursiveShapeController(ParametersModel model, RecursivePanelView view) {
        this.view = view;
        this.model = model;
        updateModelWithPanelSettings();
    }

    /**
     * Updates the algorithm parameters by retrieving the values set in the GUI
     */
    public void updateModelWithPanelSettings() {
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        updateStartX();
        updateStartY();
        updateRecursiveDepth();
        updateInitialRadius();
        updateNumShapes();
        updateLargeShapeType();
        updateLargeShapeFillColour();
        updateLargeShapeLineColour();
        updateLargeLineWidth();
        updateSmallShapeType();
        updateSmallShapeFillColour();
        updateSmallShapeLineColour();
        updateSmallLineWidth();
    }

    /**
     * Updates the startX field for the parameter based on the GUI input
     */
    public void updateStartX() {
        Integer startX = Validate.safelyParseInteger(view.getStartXTextField().getText());
        if (startX != null) {
            model.getRecursiveParams().setCenterX(startX);
        }
    }

    /**
     * Updates the startY field for the parameter based on the GUI input
     */
    public void updateStartY() {
        Integer startY = Validate.safelyParseInteger(view.getStartYTextField().getText());
        if (startY != null) {
            model.getRecursiveParams().setCenterY(startY);
        }
    }

    /**
     * Updates the recursive field for the parameter based on the GUI input
     */
    public void updateRecursiveDepth() {
        Integer depth = Validate.safelyParseInteger(view.getRecursiveDepthTextField().getText());
        if (depth != null) {
            model.getRecursiveParams().setDepth(depth);
        }
    }

    /**
     * Updates the initial radius field for the parameter based on the GUI input
     */
    public void updateInitialRadius() {
        Integer initialRadius = Validate.safelyParseInteger(view.getInitialRadiusTextField().getText());
        if (initialRadius != null) {
            model.getRecursiveParams().setInitialSize(initialRadius);
        }
    }

    /**
     * Updates the number of shapes field for the parameter based on the GUI input
     */
    public void updateNumShapes() {
        Integer numShapes = Validate.safelyParseInteger(view.getNumShapeTextField().getText());
        if (numShapes != null) {
            model.getRecursiveParams().setNumShapes(numShapes);
        }
    }

    /**
     * Updates the larger shape type field for the parameter based on the GUI input
     */
    public void updateLargeShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getLargeShapeType().getSelectedItem().toLowerCase());
    }

    /**
     * Updates the larger shape fill colour field for the parameter based on the GUI input
     */
    public void updateLargeShapeFillColour() {
        Color color = Utilities.getColourFromButton(view.getLargeShapeColourButton());
        model.getShapesParams().get(0).setFillColour(color);
    }

    /**
     * Updates the larger shape line colour field for the parameter based on the GUI input
     */
    public void updateLargeShapeLineColour() {
        Color color = Utilities.getColourFromButton(view.getLargeLineColourButton());
        model.getShapesParams().get(0).setLineColour(color);
    }

    /**
     * Updates the larger shape line width field for the parameter based on the GUI input
     */
    public void updateLargeLineWidth() {
        Integer largeLineWidth = Validate.safelyParseInteger(view.getLargeLineWidthTextField().getText());
        if (largeLineWidth != null) {
            model.getShapesParams().get(0).setLineWidth(largeLineWidth);
        }
    }

    /**
     * Updates the smaller shape type field for the parameter based on the GUI input
     */
    public void updateSmallShapeType() {
        model.getShapesParams().get(1).setShapeType(view.getSmallShapeType().getSelectedItem().toLowerCase());
    }

    /**
     * Updates the smaller shape fill colour field for the parameter based on the GUI input
     */
    public void updateSmallShapeFillColour() {
        Color color = Utilities.getColourFromButton(view.getSmallShapeColourButton());
        model.getShapesParams().get(1).setFillColour(color);
    }

    /**
     * Updates the smaller shape line colour field for the parameter based on the GUI input
     */
    public void updateSmallShapeLineColour() {
        Color color = Utilities.getColourFromButton(view.getSmallLineColourButton());
        model.getShapesParams().get(1).setLineColour(color);
    }

    /**
     * Updates the smaller shape line width field for the parameter based on the GUI input
     */
    public void updateSmallLineWidth() {
        Integer smallLineWidth = Validate.safelyParseInteger(view.getSmallLineWidthTextField().getText());
        if (smallLineWidth != null) {
            model.getShapesParams().get(1).setLineWidth(smallLineWidth);
        }
    }
}
