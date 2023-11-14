package withgof.algorithms;

import withgof.parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlgorithmContext extends JPanel {
    private static AlgorithmContext context;
    private AlgorithmStrategy strategy;

    private AlgorithmContext() {
    }

    public static AlgorithmContext getAlgorithmContext() {
        if (context == null) {
            context = new AlgorithmContext();
        }
        return context;
    }

    public void executeAlgorithm() {
        strategy.executeAlgorithm();
    }

    public void drawPattern(Graphics g) {
        strategy.drawPattern(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPattern(g);
    }

    public AlgorithmStrategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(AlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        AlgorithmStrategy strategy = null;
        JFrame frame = new JFrame();
       // String example = Arrays.toString(args);
        String example = "sierpinski";
        switch(example){
            case "recursive":
                frame.setTitle("Recursive Shape Example");
                strategy = recursiveShapeStrategy();
                break;
            case "packing":
                frame.setTitle("Circle Packing in Shapes Example");
                strategy = circlePackingStrategy();
                break;
            case "sierpinski":
                frame.setTitle("Sierpinski Shape Example");
                strategy = sierpinskiShapeStrategy();
                break;
            default:
                System.out.println("Unauthorised input: "+example+ "\"");
                System.exit(1);
        }
        AlgorithmContext context = new AlgorithmContext();
        context.setStrategy(strategy);
        context.executeAlgorithm();
        frame.add(context);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //        Timer timer = new Timer(packing.params.animationSpeed, e -> {
        //            packing.addCircles();
        //            packing.repaint();
        //        });
        //        timer.start();
    }
    //helpers for the main methods:
    public static AlgorithmStrategy recursiveShapeStrategy(){
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("triangle", 1, Color.BLACK, Color.BLACK));
        shapes.add(new ShapeParameters("square", 1, Color.BLACK, Color.YELLOW));
        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);
        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
    }
    public static AlgorithmStrategy circlePackingStrategy(){
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.WHITE));
        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        CirclePackingAlgorithmParameters algorithm = new CirclePackingAlgorithmParameters(250, 250, 200, 5, 50, 100, 1);
        return new CirclePackingAlgorithm(canvas, shapes, algorithm);
    }
    public static AlgorithmStrategy sierpinskiShapeStrategy(){
        CanvasParameters canvas = new CanvasParameters(1200, 1200, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("circle", 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 400, 100, 4);
        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }
}
