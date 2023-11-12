package gui.controller;

import gui.model.ParametersModel;
import gui.view.RecursivePanelView;
import gui.view.utilities;

import java.awt.*;

public class RecursiveShapeController {
    ParametersModel model;
    private final RecursivePanelView view;

    public RecursiveShapeController(ParametersModel model, RecursivePanelView view) {
        this.view = view;
        this.model = model;
        initController();
    }

    public void initController() {
        // Add action listeners to the view components
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        view.getStartXTextField().addActionListener(e -> updateStartX());
        view.getStartYTextField().addActionListener(e -> updateStartY());
        view.getRecursiveDepthTextField().addActionListener(e -> updateRecursiveDepth());
        view.getInitialRadiusTextField().addActionListener(e -> updateInitialRadius());
        view.getNumShapeTextField().addActionListener(e -> updateNumShapes());
        view.getLargeShapeType().addItemListener(e -> updateLargeShapeType());
        view.getLargeShapeColourButton().addActionListener(e -> updateLargeShapeFillColour());
        view.getLargeLineColourButton().addActionListener(e -> updateLargeShapeLineColour());
        view.getLargeLineWidthTextField().addActionListener(e -> updateLargeLineWidth());
        view.getSmallShapeType().addItemListener(e -> updateSmallShapeType());
        view.getSmallShapeColourButton().addActionListener(e -> updateSmallShapeFillColour());
        view.getSmallLineColourButton().addActionListener(e -> updateSmallShapeLineColour());
        view.getSmallLineWidthTextField().addActionListener(e -> updateSmallLineWidth());
    }

    public void updateStartX() {
        model.getRecursiveParams().setCenterX(Integer.parseInt(view.getStartXTextField().getText()));
    }

    public void updateStartY() {
        model.getRecursiveParams().setCenterY(Integer.parseInt(view.getStartYTextField().getText()));
    }

    public void updateRecursiveDepth() {
        model.getRecursiveParams().setDepth(Integer.parseInt(view.getRecursiveDepthTextField().getText()));
    }

    public void updateInitialRadius() {
        model.getRecursiveParams().setInitialSize(Integer.parseInt(view.getInitialRadiusTextField().getText()));
    }

    public void updateNumShapes() {
        model.getRecursiveParams().setNumShapes(Integer.parseInt(view.getNumShapeTextField().getText()));
    }

    public void updateLargeShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getLargeShapeType().getSelectedItem().toLowerCase());
    }

    public void updateLargeShapeFillColour() {
        Color color = utilities.getColourFromButton(view.getLargeShapeColourButton());
        model.getShapesParams().get(0).setFillColour(color);
    }

    public void updateLargeShapeLineColour() {
        Color color = utilities.getColourFromButton(view.getLargeLineColourButton());
        model.getShapesParams().get(0).setLineColour(color);
    }

    public void updateLargeLineWidth() {
        model.getShapesParams().get(0).setLineWidth(Integer.parseInt(view.getLargeLineWidthTextField().getText()));
    }

    public void updateSmallShapeType() {
        model.getShapesParams().get(1).setShapeType(view.getSmallShapeType().getSelectedItem().toLowerCase());
    }

    public void updateSmallShapeFillColour() {
        Color color = utilities.getColourFromButton(view.getSmallShapeColourButton());
        model.getShapesParams().get(1).setFillColour(color);
    }

    public void updateSmallShapeLineColour() {
        Color color = utilities.getColourFromButton(view.getSmallLineColourButton());
        model.getShapesParams().get(1).setLineColour(color);
    }

    public void updateSmallLineWidth() {
        model.getShapesParams().get(1).setLineWidth(Integer.parseInt(view.getSmallLineWidthTextField().getText()));
    }


}
