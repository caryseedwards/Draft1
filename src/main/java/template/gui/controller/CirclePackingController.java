package template.gui.controller;

import template.gui.model.ParametersModel;
import template.gui.view.panel.CirclePackingPanelView;
import template.gui.view.utilities;
import template.validate.Validate;

import java.awt.*;

public class CirclePackingController {
    private final ParametersModel model;
    private final CirclePackingPanelView view;

    public CirclePackingController(ParametersModel model, CirclePackingPanelView view) {
        this.view = view;
        this.model = model;
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        model.getCanvasParams().setBackgroundColour(Color.WHITE);
        model.getShapesParams().get(1).setShapeType("circle");
        updateModelWithPanelSettings();
    }

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

    public void updateStartX() {
        Integer startX = Validate.safelyParseInteger(view.getStartXTextField().getText());
        if (startX != null) {
            model.getPackingParams().setCentreX(startX);
        }
    }

    public void updateStartY() {
        Integer startY = Validate.safelyParseInteger(view.getStartYTextField().getText());
        if (startY != null) {
            model.getPackingParams().setCentreY(startY);
        }
    }

    public void updateMaxAttempts() {
        Integer maxAttempts = Validate.safelyParseInteger(view.getMaxAttemptsTextField().getText());
        if (maxAttempts != null) {
            model.getPackingParams().setMaxAttempts(maxAttempts);
        }
    }

    public void updateBoundaryShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getBoundaryShapeType().getSelectedItem().toLowerCase());
    }

    public void updateBoundaryFillColour() {
        model.getShapesParams().get(0).setFillColour(utilities.getColourFromButton(view.getBoundaryFillColourButton()));
    }

    public void updateBoundaryLineColour() {
        model.getShapesParams().get(0).setLineColour(utilities.getColourFromButton(view.getBoundaryLineColourButton()));
    }

    public void updateBoundaryLineWidth() {
        Integer boundaryLineWidth = Validate.safelyParseInteger(view.getBoundaryLineWidthTextField().getText());
        if (boundaryLineWidth != null) {
            model.getShapesParams().get(0).setLineWidth(boundaryLineWidth);
        }
    }

    public void updateBoundaryRadius() {
        Integer boundaryRadius = Validate.safelyParseInteger(view.getBoundaryRadiusTextField().getText());
        if (boundaryRadius != null) {
            model.getPackingParams().setPolygonSize(boundaryRadius);
        }
    }

    public void updatePackingShapeType() {
        model.getShapesParams().get(1).setShapeType("circle");
    }

    public void updatePackingFillColour() {
        model.getShapesParams().get(1).setFillColour(utilities.getColourFromButton(view.getPackingFillColourButton()));
    }

    public void updatePackingLineColour() {
        model.getShapesParams().get(1).setLineColour(utilities.getColourFromButton(view.getPackingLineColourButton()));
    }

    public void updatePackingLineWidth() {
        Integer packingLineWidth = Validate.safelyParseInteger(view.getPackingLineWidthTextField().getText());
        if (packingLineWidth != null) {
            model.getShapesParams().get(1).setLineWidth(packingLineWidth);
        }
    }

    public void updateMinRadius() {
        Integer minRadius = Validate.safelyParseInteger(view.getMinRadiusCircleTextField().getText());
        if (minRadius != null) {
            model.getPackingParams().setMinRadius(minRadius);
        }
    }

    public void updateMaxRadius() {
        Integer maxRadius = Validate.safelyParseInteger(view.getMaxRadiusCircleTextField().getText());
        if (maxRadius != null) {
            model.getPackingParams().setMaxRadius(maxRadius);
        }
    }
}