package unit_test.withgof.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import withoutgof.gui.controller.ArtworkGUIController;
import withoutgof.gui.controller.RecursiveShapeController;
import withoutgof.gui.model.ParametersModel;
import withoutgof.gui.view.ArtworkGUIView;
import withoutgof.gui.view.panel.RecursivePanelView;
import withoutgof.parameters.CanvasParameters;
import withoutgof.parameters.RecursiveShapeAlgorithmParameters;
import withoutgof.parameters.ShapeParameters;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RecursiveControllerTest {
    private ParametersModel model  = new ParametersModel();
    private ArtworkGUIView v = new ArtworkGUIView();
    private ArtworkGUIController c = new ArtworkGUIController(v, model);
    private RecursiveShapeController controller;
    private RecursivePanelView view;

    @Before
    public void setUpRecursiveEnvironment() {
        view = v.getRecursivePanelView();
        controller = c.getRecursiveController();

        // Create default instances for model fields
        CanvasParameters canvasParams = new CanvasParameters(500, 500, Color.WHITE);
        RecursiveShapeAlgorithmParameters rapParams = new RecursiveShapeAlgorithmParameters(250, 250, 100, 5, 6);
        ArrayList<ShapeParameters> shapeParamsList = new ArrayList<>();
        shapeParamsList.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.WHITE));
        shapeParamsList.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.WHITE));

        model.setRecursiveParams(rapParams);
        model.setShapesParams(shapeParamsList);
        model.setCanvasParams(canvasParams);
        c.updateAlgorithmPanelVisibility("Recursive Shape");
    }
    @Test
    public void testUpdateStartX() {
        view.getStartXTextField().setText("300");
        controller.updateStartX();
        assertEquals(300, model.getRecursiveParams().getCenterX());
    }
    @Test
    public void testUpdateStartY() {
        view.getStartYTextField().setText("350");
        controller.updateStartY();
        assertEquals(350, model.getRecursiveParams().getCenterY());
    }
    @Test
    public void testUpdateRecursiveDepth() {
        view.getRecursiveDepthTextField().setText("5");
        controller.updateRecursiveDepth();
        assertEquals(5, model.getRecursiveParams().getDepth());
    }
    @Test
    public void testUpdateInitialRadius() {
        view.getInitialRadiusTextField().setText("50");
        controller.updateInitialRadius();
        assertEquals(50, model.getRecursiveParams().getInitialSize());
    }
    @Test
    public void testUpdateNumShapes() {
        view.getNumShapeTextField().setText("10");
        controller.updateNumShapes();
        assertEquals(10, model.getRecursiveParams().getNumShapes());
    }
    @Test
    public void testUpdateLargeShapeType() {
        view.getLargeShapeType().select("Square");
        controller.updateLargeShapeType();
        assertEquals("square", model.getShapesParams().get(0).getShapeType());
    }
    @Test
    public void testUpdateLargeShapeFillColour() {
        Button colourButton = view.getLargeShapeColourButton();
        colourButton.setBackground(Color.RED);
        controller.updateLargeShapeFillColour();
        assertEquals(Color.RED, model.getShapesParams().get(0).getFillColour());
    }
    @Test
    public void testUpdateLargeShapeLineColour() {
        Button colourButton = view.getLargeLineColourButton();
        colourButton.setBackground(Color.GREEN);
        controller.updateLargeShapeLineColour();
        assertEquals(Color.GREEN, model.getShapesParams().get(0).getLineColour());
    }
    @Test
    public void testUpdateLargeLineWidth() {
        view.getLargeLineWidthTextField().setText("3");
        controller.updateLargeLineWidth();
        assertEquals(3, model.getShapesParams().get(0).getLineWidth(),0);
    }
    @Test
    public void testUpdateSmallShapeType() {
        view.getSmallShapeType().select("Circle");
        controller.updateSmallShapeType();
        assertEquals("circle", model.getShapesParams().get(1).getShapeType());
    }
    @Test
    public void testUpdateSmallShapeFillColour() {
        Button colourButton = view.getSmallShapeColourButton();
        colourButton.setBackground(Color.BLUE);
        controller.updateSmallShapeFillColour();
        assertEquals(Color.BLUE, model.getShapesParams().get(1).getFillColour());
    }

    @Test
    public void testUpdateSmallShapeLineColour() {
        Button colourButton = view.getSmallLineColourButton();
        colourButton.setBackground(Color.YELLOW);
        controller.updateSmallShapeLineColour();
        assertEquals(Color.YELLOW, model.getShapesParams().get(1).getLineColour());
    }
    @Test
    public void testUpdateSmallLineWidth() {
        view.getSmallLineWidthTextField().setText("2");
        controller.updateSmallLineWidth();
        assertEquals(2, model.getShapesParams().get(1).getLineWidth(),0);
    }
}
