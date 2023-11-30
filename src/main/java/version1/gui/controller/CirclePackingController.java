package version1.gui.controller;

import version1.gui.model.ParametersModel;
import version1.gui.view.panel.CirclePackingPanelView;
import version1.gui.view.Utilities;
import version1.validate.Validate;

import java.awt.*;

/**
 * The controller for the Circle Packing algorithm via the GUI
 * Part of the MVC pattern
 * @author carysedwards
 */
public class CirclePackingController {
    private final ParametersModel model;
    private final CirclePackingPanelView view;

    /**
     * Creates the Circle Packing controller
     * @param model - the corresponding model for the controller
     * @param view - the corresponding view for the controller
     */
    public CirclePackingController(ParametersModel model, CirclePackingPanelView view) {
        this.view = view;
        this.model = model;
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        model.getCanvasParams().setBackgroundColour(Color.WHITE);
        model.getShapesParams().get(1).setShapeType("circle");
        updateModelWithPanelSettings();
    }

    /**
     * Updates the algorithm parameters by retrieving the values set in the GUI
     */
    public void updateModelWithPanelSettings() {
        updateStartX();
        updateStartY();
        updateMaxAttempts();
        updateBoundaryShapeType();
        updateBoundaryFillColour();
        updateBoundaryLineColour();
        updateBoundaryLineWidth();
        updateBoundaryRadius();
        updatePackingFillColour();
        updatePackingLineColour();
        updatePackingLineWidth();
        updateMinRadius();
        updateMaxRadius();
        updatePackingShapeType();
    }

    /**
     * Updates the startX field for the parameter based on the GUI input
     */
    public void updateStartX() {
        Integer startX = Validate.safelyParseInteger(view.getStartXTextField().getText());
        if (startX != null) {
            model.getPackingParams().setCentreX(startX);
        }
    }

    /**
     * Updates the startY field for the parameter based on the GUI input
     */
    public void updateStartY() {
        Integer startY = Validate.safelyParseInteger(view.getStartYTextField().getText());
        if (startY != null) {
            model.getPackingParams().setCentreY(startY);
        }
    }

    /**
     * Updates the maxAttempts field for the parameter based on the GUI input
     */
    public void updateMaxAttempts() {
        Integer maxAttempts = Validate.safelyParseInteger(view.getMaxAttemptsTextField().getText());
        if (maxAttempts != null) {
            model.getPackingParams().setMaxAttempts(maxAttempts);
        }
    }

    /**
     * Updates the boundary shape field for the parameter based on the GUI input
     */
    public void updateBoundaryShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getBoundaryShapeType().getSelectedItem().toLowerCase());
    }


    /**
     * Updates the boundary shape fill colour field for the parameter based on the GUI input
     */
    public void updateBoundaryFillColour() {
        model.getShapesParams().get(0).setFillColour(Utilities.getColourFromButton(view.getBoundaryFillColourButton()));
    }

    /**
     * Updates the boundary shape line colour field for the parameter based on the GUI input
     */
    public void updateBoundaryLineColour() {
        model.getShapesParams().get(0).setLineColour(Utilities.getColourFromButton(view.getBoundaryLineColourButton()));
    }

    /**
     * Updates the boundary shape line width field for the parameter based on the GUI input
     */
    public void updateBoundaryLineWidth() {
        Integer boundaryLineWidth = Validate.safelyParseInteger(view.getBoundaryLineWidthTextField().getText());
        if (boundaryLineWidth != null) {
            model.getShapesParams().get(0).setLineWidth(boundaryLineWidth);
        }
    }

    /**
     * Updates the boundary shape radius field for the parameter based on the GUI input
     */
    public void updateBoundaryRadius() {
        Integer boundaryRadius = Validate.safelyParseInteger(view.getBoundaryRadiusTextField().getText());
        if (boundaryRadius != null) {
            model.getPackingParams().setPolygonSize(boundaryRadius);
        }
    }

    /**
     * Updates the packing shape type to be a circle for parameter based on the GUI input
     */
    public void updatePackingShapeType() {
        model.getShapesParams().get(1).setShapeType("circle");
    }

    /**
     * Updates the packing shape fill colour parameter based on the GUI input
     */
    public void updatePackingFillColour() {
        model.getShapesParams().get(1).setFillColour(Utilities.getColourFromButton(view.getPackingFillColourButton()));
    }

    /**
     * Updates the packing shape line colour parameter based on the GUI input
     */
    public void updatePackingLineColour() {
        model.getShapesParams().get(1).setLineColour(Utilities.getColourFromButton(view.getPackingLineColourButton()));
    }

    /**
     * Updates the packing shape line width parameter based on the GUI input
     */
    public void updatePackingLineWidth() {
        Integer packingLineWidth = Validate.safelyParseInteger(view.getPackingLineWidthTextField().getText());
        if (packingLineWidth != null) {
            model.getShapesParams().get(1).setLineWidth(packingLineWidth);
        }
    }

    /**
     * Updates the packing shape minimum radius parameter based on the GUI input
     */
    public void updateMinRadius() {
        Integer minRadius = Validate.safelyParseInteger(view.getMinRadiusCircleTextField().getText());
        if (minRadius != null) {
            model.getPackingParams().setMinRadius(minRadius);
        }
    }

    /**
     * Updates the packing shape maximum radius parameter based on the GUI input
     */
    public void updateMaxRadius() {
        Integer maxRadius = Validate.safelyParseInteger(view.getMaxRadiusCircleTextField().getText());
        if (maxRadius != null) {
            model.getPackingParams().setMaxRadius(maxRadius);
        }
    }
}
