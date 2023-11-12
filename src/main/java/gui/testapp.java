package gui;

import gui.controller.RecursiveShapeController;
import gui.view.RecursivePanelView;
import parameters.RecursiveShapeAlgorithmParameters;
import parameters.ShapeParameters;

import java.awt.*;
import java.util.ArrayList;

public class testapp {
    public static void main(String[] args) {
        RecursivePanelView view = new RecursivePanelView();
        ArrayList<ShapeParameters> shapeParams = new ArrayList<>();
        shapeParams.add(new ShapeParameters(null, 0, Color.WHITE, Color.WHITE));
        shapeParams.add(new ShapeParameters(null, 0, Color.WHITE, Color.WHITE));
        RecursiveShapeAlgorithmParameters algorithmParams = new RecursiveShapeAlgorithmParameters(0,0,0,0,0);
        RecursiveShapeController controller = new RecursiveShapeController(view, algorithmParams, shapeParams);

        // Add the view panel to your application's frame or window
        Frame frame = new Frame("Artwork Application");
        frame.add(view.getPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
