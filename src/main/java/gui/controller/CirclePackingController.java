package gui.controller;

import gui.model.ParametersModel;
import gui.view.panel.CirclePackingPanelView;
import gui.view.utilities;

import java.awt.*;

public class CirclePackingController {
    private ParametersModel model;
    private CirclePackingPanelView view;
    public CirclePackingController(ParametersModel model,CirclePackingPanelView view) {
        this.view = view;
        this.model = model;
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        model.getCanvasParams().setBackgroundColour(Color.WHITE);
        model.getShapesParams().get(1).setShapeType("circle");
        initController();
    }

    private void initController() {
        view.getStartXTextField().addActionListener(e -> updateStartX());
        view.getStartYTextField().addActionListener(e -> updateStartY());
        view.getMaxAttemptsTextField().addActionListener(e -> updateMaxAttempts());
        view.getBoundaryShapeType().addItemListener(e -> updateBoundaryShapeType());
        view.getBoundaryFillColourButton().addActionListener(e -> updateBoundaryFillColour());
        view.getBoundaryLineColourButton().addActionListener(e -> updateBoundaryLineColour());
        view.getBoundaryLineWidthTextField().addActionListener(e -> updateBoundaryLineWidth());
        view.getBoundaryRadiusTextField().addActionListener(e -> updateBoundaryRadius());
        model.getShapesParams().get(1).setShapeType("circle");
        view.getPackingFillColourButton().addActionListener(e -> updatePackingFillColour());
        view.getPackingLineColourButton().addActionListener(e -> updatePackingLineColour());
        view.getPackingLineWidthTextField().addActionListener(e -> updatePackingLineWidth());
        view.getMinRadiusCircleTextField().addActionListener(e -> updateMinRadius());
        view.getMaxRadiusCircleTextField().addActionListener(e -> updateMaxRadius());
        updatePackingShapeType();
    }

    public void updateStartX() {
        model.getPackingParams().setCentreX(Integer.parseInt(view.getStartXTextField().getText()));
    }

    public void updateStartY() {
        model.getPackingParams().setCentreY(Integer.parseInt(view.getStartYTextField().getText()));
    }

    public void updateMaxAttempts() {
        model.getPackingParams().setMaxAttempts(Integer.parseInt(view.getMaxAttemptsTextField().getText()));
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
        model.getShapesParams().get(0).setLineWidth(Integer.parseInt(view.getBoundaryLineWidthTextField().getText()));
    }

    public void updateBoundaryRadius() {
        model.getPackingParams().setPolygonSize(Integer.parseInt(view.getBoundaryRadiusTextField().getText()));
    }

    public void updatePackingShapeType(){
        model.getShapesParams().get(1).setShapeType("circle");
    }
    public void updatePackingFillColour() {
        model.getShapesParams().get(1).setFillColour(utilities.getColourFromButton(view.getPackingFillColourButton()));
    }

    public void updatePackingLineColour() {
        model.getShapesParams().get(1).setLineColour(utilities.getColourFromButton(view.getPackingLineColourButton()));
    }

    public void updatePackingLineWidth() {
        model.getShapesParams().get(1).setLineWidth(Integer.parseInt(view.getPackingLineWidthTextField().getText()));
    }

    public void updateMinRadius() {
        model.getPackingParams().setMinRadius(Integer.parseInt(view.getMinRadiusCircleTextField().getText()));
    }

    public void updateMaxRadius() {
        model.getPackingParams().setMaxRadius(Integer.parseInt(view.getMaxRadiusCircleTextField().getText()));
    }
}
