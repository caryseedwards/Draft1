package gui.controller;

import gui.model.ParametersModel;
import gui.view.SierpinskiPanelView;

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
        view.getStartXTextField().addActionListener(e -> updateStartX());
        view.getStartYTextField().addActionListener(e -> updateStartY());
        view.getSizeTextField().addActionListener(e -> updateSize());
        view.getDepthTextField().addActionListener(e -> updateDepth());
        view.getShapeTypeChoice().addItemListener(e -> updateShapeType());
        view.getFillColourButton().addActionListener(e -> updateFillColour());
        view.getLineColourButton().addActionListener(e -> updateLineColour());
        view.getLineWidthTextField().addActionListener(e -> updateLineWidth());
    }

    private void updateStartX() {
        model.getSierpinskiParams().setCentreX(parseIntSafe(view.getStartXTextField().getText()));
    }

    private void updateStartY() {
        model.getSierpinskiParams().setCentreY(parseIntSafe(view.getStartYTextField().getText()));
    }

    private void updateSize() {
        model.getSierpinskiParams().setPolygonSize(parseIntSafe(view.getSizeTextField().getText()));
    }

    private void updateDepth() {
        model.getSierpinskiParams().setDepth(parseIntSafe(view.getDepthTextField().getText()));
    }

    private void updateShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getShapeTypeChoice().getSelectedItem().toLowerCase());
    }

    private void updateFillColour() {
        model.getShapesParams().get(0).setFillColour(view.getFillColourButton().getBackground());
    }

    private void updateLineColour() {
        model.getShapesParams().get(0).setLineColour(view.getLineColourButton().getBackground());
    }

    private void updateLineWidth() {
        model.getShapesParams().get(0).setLineWidth(parseIntSafe(view.getLineWidthTextField().getText()));
    }

    private int parseIntSafe(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0; // Default value or error handling
        }
    }
}

