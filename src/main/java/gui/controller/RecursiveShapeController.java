package gui.controller;

import gui.model.ParametersModel;
import gui.view.RecursivePanelView;
import parameters.RecursiveShapeAlgorithmParameters;
import parameters.ShapeParameters;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

public class RecursiveShapeController {
    ParametersModel model;
    private final RecursivePanelView view;

    public RecursiveShapeController(ParametersModel model, RecursivePanelView view) {
        this.view = view;
        this.model = model;
        hardUpdateParams();
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
        view.getLargeShapeColorButton().addActionListener(e -> updateLargeShapeFillColor());
        view.getLargeLineColorButton().addActionListener(e -> updateLargeShapeLineColor());
        view.getLargeLineWidthTextField().addActionListener(e -> updateLargeLineWidth());
        view.getSmallShapeType().addItemListener(e -> updateSmallShapeType());
        view.getSmallShapeColorButton().addActionListener(e -> updateSmallShapeFillColor());
        view.getSmallLineColorButton().addActionListener(e -> updateSmallShapeLineColor());
        view.getSmallLineWidthTextField().addActionListener(e -> updateSmallLineWidth());
    }
    public void hardUpdateParams(){
        updateStartX();
        updateStartY();
        updateRecursiveDepth();
        updateInitialRadius();
        updateNumShapes();
        updateLargeShapeType();
        updateLargeShapeFillColor();
        updateLargeShapeLineColor();
        updateLargeLineWidth();
        updateSmallShapeType();
        updateSmallShapeFillColor();
        updateSmallShapeLineColor();
        updateSmallLineWidth();
    }
    private void updateStartX() {
        model.getRecursiveParams().setCenterX(Integer.parseInt(view.getStartXTextField().getText()));
    }

    private void updateStartY() {
        model.getRecursiveParams().setCenterY(Integer.parseInt(view.getStartYTextField().getText()));
    }

    private void updateRecursiveDepth() {
        model.getRecursiveParams().setDepth(Integer.parseInt(view.getRecursiveDepthTextField().getText()));
    }

    private void updateInitialRadius() {
        model.getRecursiveParams().setInitialSize(Integer.parseInt(view.getInitialRadiusTextField().getText()));
    }

    private void updateNumShapes() {
        model.getRecursiveParams().setNumShapes(Integer.parseInt(view.getNumShapeTextField().getText()));
    }

    private void updateLargeShapeType() {
        model.getShapesParams().get(0).setShapeType(view.getLargeShapeType().getSelectedItem().toLowerCase());
    }

    private void updateLargeShapeFillColor() {
        Color color = view.getColorFromButton(view.getLargeShapeColorButton());
        model.getShapesParams().get(0).setFillColour(color);
    }

    private void updateLargeShapeLineColor() {
        Color color = view.getColorFromButton(view.getLargeLineColorButton());
        model.getShapesParams().get(0).setLineColour(color);
    }

    private void updateLargeLineWidth() {
        model.getShapesParams().get(0).setLineWidth(Integer.parseInt(view.getLargeLineWidthTextField().getText()));
    }

    private void updateSmallShapeType() {
        model.getShapesParams().get(1).setShapeType(view.getSmallShapeType().getSelectedItem().toLowerCase());
    }

    private void updateSmallShapeFillColor() {
        Color color = view.getColorFromButton(view.getSmallShapeColorButton());
        model.getShapesParams().get(1).setFillColour(color);
    }

    private void updateSmallShapeLineColor() {
        Color color = view.getColorFromButton(view.getSmallLineColorButton());
        model.getShapesParams().get(1).setLineColour(color);
    }

    private void updateSmallLineWidth() {
        model.getShapesParams().get(1).setLineWidth(Integer.parseInt(view.getSmallLineWidthTextField().getText()));
    }


    public void printModelParameters() {
        System.out.println("Canvas Parameters:");
        System.out.println("Width: " + model.getCanvasParams().getWidth());
        System.out.println("Height: " + model.getCanvasParams().getHeight());
        System.out.println("BackgroundColour: " + model.getCanvasParams().getBackgroundColour());
        System.out.println("Recursive Shape Parameters:");
        System.out.println("Center X: " + model.getRecursiveParams().getCenterX());
        System.out.println("Center Y: " + model.getRecursiveParams().getCenterY());
        System.out.println("Depth: " + model.getRecursiveParams().getDepth());
        System.out.println("Initial Size: " + model.getRecursiveParams().getInitialSize());
        System.out.println("Number of Shapes: " + model.getRecursiveParams().getNumShapes());

        System.out.println("Large Shape Parameters:");
        System.out.println("Type: " + model.getShapesParams().get(0).getShapeType());
        System.out.println("Fill Color: " + model.getShapesParams().get(0).getFillColour());
        System.out.println("Line Color: " + model.getShapesParams().get(0).getLineColour());
        System.out.println("Line Width: " + model.getShapesParams().get(0).getLineWidth());

        System.out.println("Small Shape Parameters:");
        System.out.println("Type: " + model.getShapesParams().get(1).getShapeType());
        System.out.println("Fill Color: " + model.getShapesParams().get(1).getFillColour());
        System.out.println("Line Color: " + model.getShapesParams().get(1).getLineColour());
        System.out.println("Line Width: " + model.getShapesParams().get(1).getLineWidth());
    }
}
