package algorithms;

import parameters.AlgorithmParameters;
import parameters.CanvasParameters;
import parameters.ShapeParameters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Algorithm extends JPanel {
    private CanvasParameters canvasParams;
    private ArrayList<ShapeParameters> shapeParams;
    private AlgorithmParameters algorithmParams;
    public Graphics2D pattern;

    public Algorithm(CanvasParameters canvasParams, ArrayList<ShapeParameters> shapeParams, AlgorithmParameters algorithmParams) {
    setAlgorithmParams(algorithmParams);
    setCanvasParameters(canvasParams);
    setShapeParameters(shapeParams);
    }
    protected abstract void initialiseAlgorithm();
    public void initialiseDefaults(){
        this.canvasParams.initialiseDefaultParameters();
        this.algorithmParams.initialiseDefaultParameters();
        this.shapeParams.forEach(ShapeParameters::initialiseDefaultParameters);
    }
    public boolean validateParameters(){
        return this.canvasParams.validateParameters() &&
                this.algorithmParams.validateParameters() &&
                this.shapeParams.stream().allMatch(ShapeParameters::validateParameters);
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
    }
    public CanvasParameters getCanvasParameters(){
        return this.canvasParams;
    }

    public void setShapeParameters(ArrayList<ShapeParameters> shapeParams){this.shapeParams = shapeParams;}
    public ArrayList<ShapeParameters> getShapeParameters(){
        return this.shapeParams;
    }

    public void setAlgorithmParams(AlgorithmParameters algorithmParams){
        this.algorithmParams = algorithmParams;
    }
    public AlgorithmParameters getAlgorithmParams() {
        return this.algorithmParams;
    }
}
