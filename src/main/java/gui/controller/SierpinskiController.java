package gui.controller;

import gui.model.ParametersModel;
import gui.view.SierpinskiPanelView;

import java.awt.*;

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
    public void hardUpdateParams() {
        updateStartX();
        updateStartY();
        updateSize();
        updateDepth();
        updateShapeType();
        updateFillColour();
        updateLineColour();
        updateLineWidth();
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
        model.getShapesParams().get(0).setFillColour(view.getColorFromButton(view.getFillColourButton()));
    }

    private void updateLineColour() {
        model.getShapesParams().get(0).setLineColour(view.getColorFromButton(view.getLineColourButton()));
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
    public void printModelParameters() {
        System.out.println("Sierpinski Shape Parameters:");
        System.out.println("Start X: " + model.getSierpinskiParams().getCentreX());
        System.out.println("Start Y: " + model.getSierpinskiParams().getCentreY());
        System.out.println("Size: " + model.getSierpinskiParams().getPolygonSize());
        System.out.println("Depth: " + model.getSierpinskiParams().getDepth());
        System.out.println("Shape Type: " + model.getShapesParams().get(0).getShapeType());
        System.out.println("Fill Color: " + model.getShapesParams().get(0).getFillColour());
        System.out.println("Line Color: " + model.getShapesParams().get(0).getLineColour());
        System.out.println("Line Width: " + model.getShapesParams().get(0).getLineWidth());
    }

}

