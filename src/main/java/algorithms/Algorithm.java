package algorithms;

import parameters.CanvasParameters;
import parameters.Parameters;
import parameters.ShapeParameters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Algorithm extends JPanel {
    private CanvasParameters canvasParams = new CanvasParameters(0,0,Color.WHITE);
    private ArrayList<ShapeParameters> shapeParams = new ArrayList<>();
    private Parameters algorithmParams;
    public Graphics2D pattern;

    public Algorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, Parameters algorithmParams) {
    setAlgorithmParams(algorithmParams);
    setCanvasParameters(canvasParams);
    setShapeParameters(shapeParams);
    }
    protected abstract void initialiseAlgorithm();
    public void initialiseDefaults(){
        canvasParams.initialiseDefaultParameters();
        algorithmParams.initialiseDefaultParameters();
        shapeParams.forEach(ShapeParameters::initialiseDefaultParameters);
    }
    public boolean validateParameters(){
        return canvasParams.validateParameters() &&
                algorithmParams.validateParameters() &&
                shapeParams.stream().allMatch(ShapeParameters::validateParameters);
    }


    public abstract void executeAlgorithm();
    public abstract void drawPattern(Graphics g);
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPattern(g);
    }


    public void setCanvasParameters(CanvasParameters canvasParams){
        this.canvasParams = canvasParams;
        // validateParameters();
    }
    public CanvasParameters getCanvasParameters(){
        return this.canvasParams;
    }

    public void setShapeParameters(ArrayList<ShapeParameters> shapeParams){this.shapeParams = shapeParams;
    //validateParameters();
    }
    public ArrayList<ShapeParameters> getShapeParameters(){
        return shapeParams;
    }

    public void setAlgorithmParams(Parameters algorithmParams){
        this.algorithmParams = algorithmParams;
        //validateParameters();
    }
    public Parameters getAlgorithmParams() {
        return algorithmParams;
    }
}
