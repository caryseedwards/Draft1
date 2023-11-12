package gui.model;

import algorithms.Algorithm;
import gui.view.CirclePackingPanelView;
import gui.view.RecursivePanelView;
import gui.view.SierpinskiPanelView;
import parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ParametersModel {
    public static final JLabel errorLabel = new JLabel("");

    private  CanvasParameters canvas;
    private  ArrayList<ShapeParameters> shapes;
    private  RecursiveShapeAlgorithmParameters rap;
    private  CirclePackingAlgorithmParameters cap;
    private  SierpinskiShapeAlgorithmParameters sap;


    private Algorithm pattern;

    public ParametersModel(){
        setCanvasParams( new CanvasParameters(0,0, Color.WHITE));
        ArrayList<ShapeParameters> shapesDefault = new ArrayList<>();
        shapesDefault.add(new ShapeParameters("circle",0,Color.BLACK, Color.WHITE));
        shapesDefault.add(new ShapeParameters("circle",0,Color.BLACK, Color.WHITE));
        setShapesParams(shapesDefault);
        setRecursiveParams(new RecursiveShapeAlgorithmParameters(0,0,0,0,0));
        setPackingParams(new CirclePackingAlgorithmParameters(0,0,0,0,0,0,0));
        setSierpinskiParams(new SierpinskiShapeAlgorithmParameters(0,0,0,0));
    }


    public CanvasParameters getCanvasParams() {
        return canvas;
    }
    public void setCanvasParams(CanvasParameters canvas) {
        this.canvas = canvas;
    }

    public ArrayList<ShapeParameters> getShapesParams() {
        return shapes;
    }
    public void setShapesParams(ArrayList<ShapeParameters> shapes) {
        this.shapes = shapes;
    }

    public RecursiveShapeAlgorithmParameters getRecursiveParams() {
        return rap;
    }
    public void setRecursiveParams(RecursiveShapeAlgorithmParameters rap) {
        this.rap = rap;
    }

    public CirclePackingAlgorithmParameters getPackingParams() {
        return cap;
    }
    public void setPackingParams(CirclePackingAlgorithmParameters cap) {
        this.cap = cap;
    }

    public SierpinskiShapeAlgorithmParameters getSierpinskiParams() {
        return sap;
    }
    public void setSierpinskiParams(SierpinskiShapeAlgorithmParameters ssp) {
        this.sap = ssp;
    }


}
