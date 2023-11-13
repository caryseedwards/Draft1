package withgof.algorithms;

import javax.swing.*;
import java.awt.*;

public class AlgorithmContext extends JPanel {
    private AlgorithmStrategy strategy;

    public AlgorithmContext() {
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

//    public static void main(String[] args) {
//        AlgorithmStrategy strategy = null;
//        JFrame frame = new JFrame();
//       // String example = Arrays.toString(args);
//        String example = "packing";
//        switch(example){
//            case "recursive":
//                frame.setTitle("Recursive Shape Example");
//                strategy = recursiveShapeStrategy();
//            case "packing":
//                frame.setTitle("Circle Packing in Shapes Example");
//                strategy = circlePackingStrategy();
//            case "sierpinski":
//                frame.setTitle("Sierpinski Shape Example");
//                strategy = sierpinskiShapeStrategy();
//            default:
//                System.out.println("Unauthorised input: "+example+ "\"");
//                System.exit(1);
//        }
//        AlgorithmContext context = new AlgorithmContext(strategy);
//        context.executeAlgorithm();
//        frame.add(context);
//        frame.setSize(500, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        //        Timer timer = new Timer(packing.params.animationSpeed, e -> {
//        //            packing.addCircles();
//        //            packing.repaint();
//        //        });
//        //        timer.start();
//    }
//    //helpers for the main methods:
//    public static AlgorithmStrategy recursiveShapeStrategy(){
//        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
//        ArrayList<ShapeParameters> shapes = new ArrayList<>();
//        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.BLACK));
//        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.YELLOW));
//        RecursiveShapeAlgorithmParameters algorithm = new RecursiveShapeAlgorithmParameters(250, 250, 100, 4, 6);
//        return new RecursiveShapeAlgorithm(canvas, shapes, algorithm);
//    }
//    public static AlgorithmStrategy circlePackingStrategy(){
//        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
//        ArrayList<ShapeParameters> shapes = new ArrayList<>();
//        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
//        shapes.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
//        CirclePackingAlgorithmParameters algorithm = new CirclePackingAlgorithmParameters(250, 250, 200, 5, 50, 100, 1);
//        return new CirclePackingAlgorithm(canvas, shapes, algorithm);
//    }
//    public static AlgorithmStrategy sierpinskiShapeStrategy(){
//        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
//        ArrayList<ShapeParameters> shapes = new ArrayList<>();
//        shapes.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
//        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);
//        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
//    }
}
