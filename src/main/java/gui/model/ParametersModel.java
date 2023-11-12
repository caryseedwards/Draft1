package gui.model;

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

    public ParametersModel(){
        setCanvasParams( new CanvasParameters(500,500, Color.WHITE));
        ArrayList<ShapeParameters> shapesDefault = new ArrayList<>();
        shapesDefault.add(new ShapeParameters("circle",1,Color.BLACK, Color.WHITE));
        shapesDefault.add(new ShapeParameters("circle",1,Color.BLACK, Color.WHITE));
        setShapesParams(shapesDefault);
        setRecursiveParams(new RecursiveShapeAlgorithmParameters(250,250,100,4,6));
        setPackingParams(new CirclePackingAlgorithmParameters(250,250,100,5,50,1000,2));
        setSierpinskiParams(new SierpinskiShapeAlgorithmParameters(250,250,100,4));
    }


    public CanvasParameters getCanvasParams() {
        return this.canvas;
    }
    public void setCanvasParams(CanvasParameters canvas) {
        canvas.validateParameters();
        this.canvas = canvas;
    }

    public ArrayList<ShapeParameters> getShapesParams() {
        return this.shapes;
    }
    public void setShapesParams(ArrayList<ShapeParameters> shapes) {
        for (ShapeParameters shapeParameters : shapes ){
            shapeParameters.validateParameters();
        }
        this.shapes = shapes;
    }

    public RecursiveShapeAlgorithmParameters getRecursiveParams() {return this.rap;
    }
    public void setRecursiveParams(RecursiveShapeAlgorithmParameters rap) {
        if (rap.validateParameters()){
            this.rap = rap;
        }
    }

    public CirclePackingAlgorithmParameters getPackingParams() {
        return this.cap;
    }
    public void setPackingParams(CirclePackingAlgorithmParameters cap) {
        if(cap.validateParameters()) {
            this.cap = cap;
        }
    }
    public SierpinskiShapeAlgorithmParameters getSierpinskiParams() {
        return this.sap;
    }
    public void setSierpinskiParams(SierpinskiShapeAlgorithmParameters ssp) {
        if(ssp.validateParameters()) {
            this.sap = ssp;
        }
    }


}
