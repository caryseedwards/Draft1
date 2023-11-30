package unit_test.version1.mvc.controller;

import version1.gui.controller.ArtworkGUIController;
import version1.gui.controller.SierpinskiController;
import version1.gui.model.ParametersModel;
import version1.gui.view.ArtworkGUIView;
import version1.gui.view.panel.SierpinskiPanelView;
import org.junit.Before;
import org.junit.Test;
import version1.parameters.CanvasParameters;
import version1.parameters.ShapeParameters;
import version1.parameters.SierpinskiShapeAlgorithmParameters;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SierpinskiControllerTest {
    private ParametersModel model  = new ParametersModel();
    private ArtworkGUIView v = new ArtworkGUIView();
    private ArtworkGUIController c = new ArtworkGUIController(v, model);
    private SierpinskiController controller;
    private SierpinskiPanelView view;

    @Before
    public void setUpSierpinskiEnvironment() {
        view = v.getSierpinskiPanelView();
        controller = c.getSierpinskiPanelController();

        CanvasParameters canvasParams = new CanvasParameters(500, 500, Color.WHITE);
        SierpinskiShapeAlgorithmParameters sapParams = new SierpinskiShapeAlgorithmParameters(250, 250, 100, 5);
        ArrayList<ShapeParameters> shapeParamsList = new ArrayList<>();
        shapeParamsList.add(new ShapeParameters("hexagon", 1, Color.BLACK, Color.WHITE));

        model.setSierpinskiParams(sapParams);
        model.setShapesParams(shapeParamsList);
        model.setCanvasParams(canvasParams);
        c.updateAlgorithmPanelVisibility("Sierpinski Shapes");
    }
    @Test
    public void testUpdateStartX() {
        view.getStartXTextField().setText("250");
        controller.updateStartX();
        assertEquals(250, model.getSierpinskiParams().getCentreX());
    }
    @Test
    public void testUpdateStartY() {
        view.getStartYTextField().setText("200");
        controller.updateStartY();
        assertEquals(200, model.getSierpinskiParams().getCentreY());
    }
    @Test
    public void testUpdateSize() {
        view.getSizeTextField().setText("300");
        controller.updateSize();
        assertEquals(300, model.getSierpinskiParams().getPolygonSize());
    }
    @Test
    public void testUpdateDepth() {
        view.getDepthTextField().setText("4");
        controller.updateDepth();
        assertEquals(4, model.getSierpinskiParams().getDepth());
    }
    @Test
    public void testUpdateShapeType() {
        view.getShapeTypeChoice().select("Triangle");
        controller.updateShapeType();
        assertEquals("triangle", model.getShapesParams().get(0).getShapeType());
    }
    @Test
    public void testUpdateFillColour() {
        Button fillColourButton = view.getFillColourButton();
        fillColourButton.setBackground(Color.GREEN);
        controller.updateFillColour();
        assertEquals(Color.GREEN, model.getShapesParams().get(0).getFillColour());
    }
    @Test
    public void testUpdateLineColour() {
        Button lineColourButton = view.getLineColourButton();
        lineColourButton.setBackground(Color.RED);
        controller.updateLineColour();
        assertEquals(Color.RED, model.getShapesParams().get(0).getLineColour());
    }
    @Test
    public void testUpdateLineWidth() {
        view.getLineWidthTextField().setText("2");
        controller.updateLineWidth();
        assertEquals(2, model.getShapesParams().get(0).getLineWidth(),0);
    }

}
