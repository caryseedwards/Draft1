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

    public void updateStartX() {
        model.getSierpinskiParams().setCentreX(Integer.parseInt(view.getStartXTextField().getText()));
    }

    public void updateStartY() {
        model.getSierpinskiParams().setCentreY(Integer.parseInt(view.getStartYTextField().getText()));
    }

    public void updateSize() {
        model.getSierpinskiParams().setPolygonSize(Integer.parseInt(view.getSizeTextField().getText()));
    }

    public void updateDepth() {
        model.getSierpinskiParams().setDepth(Integer.parseInt(view.getDepthTextField().getText()));
    }

    public void updateShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getShapeTypeChoice().getSelectedItem().toLowerCase());
    }

    public void updateFillColour() {
        model.getShapesParams().get(0).setFillColour(view.getColorFromButton(view.getFillColourButton()));
    }

    public void updateLineColour() {
        model.getShapesParams().get(0).setLineColour(view.getColorFromButton(view.getLineColourButton()));
    }

    public void updateLineWidth() {
        model.getShapesParams().get(0).setLineWidth(Integer.parseInt(view.getLineWidthTextField().getText()));
    }



}