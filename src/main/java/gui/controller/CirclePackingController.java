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
        model.getCanvasParams().setBackgroundColour(Color.WHITE);
        model.getShapesParams().get(1).setShapeType("circle");
        initController();
    }

    private void initController() {
        view.getStartXTextField().addActionListener(e -> updateStartX());
        view.getStartYTextField().addActionListener(e -> updateStartY());
        view.getMaxAttemptsTextField().addActionListener(e -> updateMaxAttempts());
        view.getBoundaryShapeType().addItemListener(e -> updateBoundaryShapeType());
        view.getBoundaryFillColourButton().addActionListener(e -> updateBoundaryFillColor());
        view.getBoundaryLineColourButton().addActionListener(e -> updateBoundaryLineColor());
        view.getBoundaryLineWidthTextField().addActionListener(e -> updateBoundaryLineWidth());
        view.getBoundaryRadiusTextField().addActionListener(e -> updateBoundaryRadius());
        model.getShapesParams().get(1).setShapeType("circle");
        view.getPackingFillColourButton().addActionListener(e -> updatePackingFillColor());
        view.getPackingLineColourButton().addActionListener(e -> updatePackingLineColor());
        view.getPackingLineWidthTextField().addActionListener(e -> updatePackingLineWidth());
        view.getMinRadiusCircleTextField().addActionListener(e -> updateMinRadius());
        view.getMaxRadiusCircleTextField().addActionListener(e -> updateMaxRadius());
        updatePackingShapeType();
    }
    public void hardUpdateParams() {
        updateStartX();
        updateStartY();
        updateMaxAttempts();
        updateBoundaryShapeType();
        updateBoundaryFillColor();
        updateBoundaryLineColor();
        updateBoundaryLineWidth();
        updateBoundaryRadius();
        updatePackingShapeType();
        updatePackingFillColor();
        updatePackingLineColor();
        updatePackingLineWidth();
        updateMinRadius();
        updateMaxRadius();
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
        model.getShapesParams().get(0).setShapeType(view.getBoundaryShapeType().getSelectedItem().toLowerCase());
    }

    private void updateBoundaryFillColor() {
        model.getShapesParams().get(0).setFillColour(view.getColorFromButton(view.getBoundaryFillColourButton()));
    }

    private void updateBoundaryLineColor() {
        model.getShapesParams().get(0).setFillColour(view.getColorFromButton(view.getBoundaryLineColourButton()));
    }

    private void updateBoundaryLineWidth() {
        model.getShapesParams().get(0).setLineWidth(Integer.parseInt(view.getBoundaryLineWidthTextField().getText()));
    }

    private void updateBoundaryRadius() {
        model.getPackingParams().setPolygonSize(Integer.parseInt(view.getBoundaryRadiusTextField().getText()));
    }

    public void updatePackingShapeType(){
        model.getShapesParams().get(1).setShapeType("circle");
    }
    private void updatePackingFillColor() {
        model.getShapesParams().get(1).setFillColour(view.getColorFromButton(view.getPackingFillColourButton()));
    }

    private void updatePackingLineColor() {
        model.getShapesParams().get(1).setLineColour(view.getColorFromButton(view.getPackingLineColourButton()));
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
    public void printModelParameters() {
        System.out.println("Circle Packing Parameters:");
        System.out.println("Start X: " + model.getPackingParams().getCentreX());
        System.out.println("Start Y: " + model.getPackingParams().getCentreY());
        System.out.println("Max Attempts: " + model.getPackingParams().getMaxAttempts());
        System.out.println("Boundary Shape Type: " + model.getShapesParams().get(0).getShapeType());
        System.out.println("Boundary Fill Color: " + model.getShapesParams().get(0).getFillColour());
        System.out.println("Boundary Line Color: " + model.getShapesParams().get(0).getLineColour());
        System.out.println("Boundary Line Width: " + model.getShapesParams().get(0).getLineWidth());
        System.out.println("Boundary Radius: " + model.getPackingParams().getPolygonSize());
        System.out.println("Packing Fill Color: " + model.getShapesParams().get(1).getFillColour());
        System.out.println("Packing Line Color: " + model.getShapesParams().get(1).getLineColour());
        System.out.println("Packing Line Width: " + model.getShapesParams().get(1).getLineWidth());
        System.out.println("Min Radius: " + model.getPackingParams().getMinRadius());
        System.out.println("Max Radius: " + model.getPackingParams().getMaxRadius());
    }
}
