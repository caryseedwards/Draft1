package gui.controller;

import gui.model.ParametersModel;
import gui.view.CirclePackingPanelView;

import java.awt.*;
import javax.swing.JColorChooser;

public class CirclePackingController {
    private ParametersModel model;
    private CirclePackingPanelView view;
    public CirclePackingController(ParametersModel model,CirclePackingPanelView view) {
        this.view = view;
        this.model = model;
        model.getCanvasParams().setWidth(view.getCanvasWidth());
        model.getCanvasParams().setHeight(view.getCanvasHeight());
        initController();
    }

    private void initController() {
        // Initialize the controller with action listeners for all relevant view components
        view.getStartXTextField().addActionListener(e -> updateStartX());
        view.getStartYTextField().addActionListener(e -> updateStartY());
        view.getMaxAttemptsTextField().addActionListener(e -> updateMaxAttempts());
        view.getBoundaryShapeType().addItemListener(e -> updateBoundaryShapeType());
        view.getBoundaryFillColourButton().addActionListener(e -> updateBoundaryFillColor());
        view.getBoundaryLineColourButton().addActionListener(e -> updateBoundaryLineColor());
        view.getBoundaryLineWidthTextField().addActionListener(e -> updateBoundaryLineWidth());
        view.getBoundaryRadiusTextField().addActionListener(e -> updateBoundaryRadius());
        view.getPackingFillColourButton().addActionListener(e -> updatePackingFillColor());
        view.getPackingLineColourButton().addActionListener(e -> updatePackingLineColor());
        view.getPackingLineWidthTextField().addActionListener(e -> updatePackingLineWidth());
        view.getMinRadiusCircleTextField().addActionListener(e -> updateMinRadius());
        view.getMaxRadiusCircleTextField().addActionListener(e -> updateMaxRadius());
    }

    private void updateStartX() {
        model.getPackingParams().setCentreX(Integer.parseInt(view.getStartXTextField().getText()));
    }

    private void updateStartY() {
        model.getPackingParams().setCentreY(Integer.parseInt(view.getStartYTextField().getText()));
    }

    private void updateMaxAttempts() {
        model.getPackingParams().setMaxAttempts(Integer.parseInt(view.getMaxAttemptsTextField().getText()));
    }

    private void updateBoundaryShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getBoundaryShapeType().getSelectedItem());
    }

    private void updateBoundaryFillColor() {
        Color color = JColorChooser.showDialog(null, "Choose Boundary Shape Fill Colour", model.getShapesParams().get(0).getFillColour());
        if (color != null) {
            model.getShapesParams().get(0).setFillColour(color);
        }
    }

    private void updateBoundaryLineColor() {
        Color color = JColorChooser.showDialog(null, "Choose Large Shape Line Color", model.getShapesParams().get(0).getLineColour());
        if (color != null) {
            model.getShapesParams().get(0).setLineColour(color);
        }
    }

    private void updateBoundaryLineWidth() {
        model.getShapesParams().get(0).setLineWidth(Integer.parseInt(view.getBoundaryLineWidthTextField().getText()));
    }

    private void updateBoundaryRadius() {
        model.getPackingParams().setPolygonSize(Integer.parseInt(view.getBoundaryRadiusTextField().getText()));
    }

    private void updatePackingFillColor() {
        Color color = JColorChooser.showDialog(null, "Choose Packing Shape Fill Color", model.getShapesParams().get(1).getFillColour());
        if (color != null) {
            model.getShapesParams().get(1).setFillColour(color);
        }
    }

    private void updatePackingLineColor() {
        Color color = JColorChooser.showDialog(null, "Choose Packing Shape Line Color", model.getShapesParams().get(1).getLineColour());
        if (color != null) {
            model.getShapesParams().get(1).setLineColour(color);
        }
    }

    private void updatePackingLineWidth() {
        model.getShapesParams().get(1).setLineWidth(Integer.parseInt(view.getPackingLineWidthTextField().getText()));
    }

    private void updateMinRadius() {
        model.getPackingParams().setMinRadius(Integer.parseInt(view.getMinRadiusCircleTextField().getText()));
    }

    private void updateMaxRadius() {
        model.getPackingParams().setMaxRadius(Integer.parseInt(view.getMaxRadiusCircleTextField().getText()));
    }
}
