package gui.controller;

import gui.model.ParametersModel;
import gui.view.panel.SierpinskiPanelView;
import gui.view.utilities;
import validate.Validate;

public class SierpinskiController {
    private final ParametersModel model;
    private final SierpinskiPanelView view;

    public SierpinskiController(ParametersModel model, SierpinskiPanelView view) {
        this.model = model;
        this.view = view;
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        initController();
    }

    private void initController() {
        view.getStartXTextField().addTextListener(e -> updateStartX());
        view.getStartYTextField().addTextListener(e -> updateStartY());
        view.getSizeTextField().addTextListener(e -> updateSize());
        view.getDepthTextField().addTextListener(e -> updateDepth());
        view.getShapeTypeChoice().addItemListener(e -> updateShapeType());
        view.getFillColourButton().addActionListener(e -> updateFillColour());
        view.getLineColourButton().addActionListener(e -> updateLineColour());
        view.getLineWidthTextField().addTextListener(e -> updateLineWidth());
    }

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