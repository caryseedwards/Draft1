package template.gui.controller;

import template.gui.model.ParametersModel;
import template.gui.view.panel.SierpinskiPanelView;
import template.gui.view.utilities;
import template.validate.Validate;

/**
 * The controller for the Sierpinski Shape algorithm via the GUI
 * Part of the MVC pattern
 * @author carysedwards
 */
public class SierpinskiController {
    private final ParametersModel model;
    private final SierpinskiPanelView view;

    /**
     * Creates the Sierpinski Shape controller
     * @param model - the corresponding model for the controller
     * @param view - the corresponding view for the controller
     */
    public SierpinskiController(ParametersModel model, SierpinskiPanelView view) {
        this.model = model;
        this.view = view;
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        updateModelWithPanelSettings();
    }

    /**
     * Updates the algorithm parameters by retrieving the values set in the GUI
     */
    public void updateModelWithPanelSettings() {
        updateStartX();
        updateStartY();
        updateSize();
        updateDepth();
        updateShapeType();
        updateFillColour();
        updateLineColour();
        updateLineWidth();
    }

    /**
     * Updates the startX field for the parameter based on the GUI input
     */
    public void updateStartX() {
        Integer startX = Validate.safelyParseInteger(view.getStartXTextField().getText());
        if (startX != null) {
            model.getSierpinskiParams().setCentreX(startX);
        }
    }

    /**
     * Updates the startY field for the parameter based on the GUI input
     */
    public void updateStartY() {
        Integer startY = Validate.safelyParseInteger(view.getStartYTextField().getText());
        if (startY != null) {
            model.getSierpinskiParams().setCentreY(startY);
        }
    }

    /**
     * Updates the size field for the parameter based on the GUI input
     */
    public void updateSize() {
        Integer size = Validate.safelyParseInteger(view.getSizeTextField().getText());
        if (size != null) {
            model.getSierpinskiParams().setPolygonSize(size);
        }
    }

    /**
     * Updates the depth field for the parameter based on the GUI input
     */
    public void updateDepth() {
        Integer depth = Validate.safelyParseInteger(view.getDepthTextField().getText());
        if (depth != null) {
            model.getSierpinskiParams().setDepth(depth);
        }
    }

    /**
     * Updates the shape type field for the parameter based on the GUI input
     */
    public void updateShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getShapeTypeChoice().getSelectedItem().toLowerCase());
    }

    /**
     * Updates the shape fill colour field for the parameter based on the GUI input
     */
    public void updateFillColour() {
        model.getShapesParams().get(0).setFillColour(utilities.getColourFromButton(view.getFillColourButton()));
    }

    /**
     * Updates the line colour field for the parameter based on the GUI input
     */
    public void updateLineColour() {
        model.getShapesParams().get(0).setLineColour(utilities.getColourFromButton(view.getLineColourButton()));
    }

    /**
     * Updates the line width field for the parameter based on the GUI input
     */
    public void updateLineWidth() {
        Integer lineWidth = Validate.safelyParseInteger(view.getLineWidthTextField().getText());
        if (lineWidth != null) {
            model.getShapesParams().get(0).setLineWidth(lineWidth);
        }
    }
}