package strategyandfactory.gui.controller;

import strategyandfactory.gui.model.ParametersModel;
import strategyandfactory.gui.view.panel.SierpinskiPanelView;
import strategyandfactory.gui.view.utilities;
import strategyandfactory.validate.Validate;

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

    public void updateStartY() {
        Integer startY = Validate.safelyParseInteger(view.getStartYTextField().getText());
        if (startY != null) {
            model.getSierpinskiParams().setCentreY(startY);
        }
    }

    public void updateSize() {
        Integer size = Validate.safelyParseInteger(view.getSizeTextField().getText());
        if (size != null) {
            model.getSierpinskiParams().setPolygonSize(size);
        }
    }

    public void updateDepth() {
        Integer depth = Validate.safelyParseInteger(view.getDepthTextField().getText());
        if (depth != null) {
            model.getSierpinskiParams().setDepth(depth);
        }
    }

    public void updateShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getShapeTypeChoice().getSelectedItem().toLowerCase());
    }

    public void updateFillColour() {
        model.getShapesParams().get(0).setFillColour(utilities.getColourFromButton(view.getFillColourButton()));
    }

    public void updateLineColour() {
        model.getShapesParams().get(0).setLineColour(utilities.getColourFromButton(view.getLineColourButton()));
    }

    public void updateLineWidth() {
        Integer lineWidth = Validate.safelyParseInteger(view.getLineWidthTextField().getText());
        if (lineWidth != null) {
            model.getShapesParams().get(0).setLineWidth(lineWidth);
        }
    }
}