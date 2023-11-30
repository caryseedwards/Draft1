package unit_test.version2.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import version2.gui.controller.ArtworkGUIController;
import version2.gui.controller.CirclePackingController;
import version2.gui.model.ParametersModel;
import version2.gui.view.ArtworkGUIView;
import version2.gui.view.panel.CirclePackingPanelView;
import version2.parameters.CanvasParameters;
import version2.parameters.CirclePackingAlgorithmParameters;
import version2.parameters.ShapeParameters;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CirclePackingControllerTest {
    private ParametersModel model  = new ParametersModel();
    private ArtworkGUIView view = new ArtworkGUIView();
    private ArtworkGUIController controller = new ArtworkGUIController(view, model);
    private CirclePackingController cpc;
    private CirclePackingPanelView viewPanel;

    @Before
    public void setUpCirclePackingEnvironment() {
        viewPanel = view.getCirclePackingPanelView();
        cpc = controller.getPackingController();

        CanvasParameters canvasParams = new CanvasParameters(500, 500, Color.WHITE);
        CirclePackingAlgorithmParameters capParams = new CirclePackingAlgorithmParameters(250, 250, 100, 5, 50, 1000, 2);
        ArrayList<ShapeParameters> shapeParamsList = new ArrayList<>();
        shapeParamsList.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));
        shapeParamsList.add(new ShapeParameters("circle", 1, Color.BLACK, Color.WHITE));

        model.setPackingParams(capParams);
        model.setShapesParams(shapeParamsList);
        model.setCanvasParams(canvasParams);
        controller.updateAlgorithmPanelVisibility("Circle Packing");
    }

    @Test
    public void testUpdateStartX() {
        viewPanel.getStartXTextField().setText("500");
        cpc.updateStartX();
        assertEquals(500, model.getPackingParams().getCentreX());
    }

    @Test
    public void testUpdateStartY() {
        viewPanel.getStartYTextField().setText("250");
        cpc.updateStartY();
        assertEquals(250, model.getPackingParams().getCentreY());
    }
    @Test
    public void testUpdateMaxAttempts() {
        viewPanel.getMaxAttemptsTextField().setText("10");
        cpc.updateMaxAttempts();
        assertEquals(10, model.getPackingParams().getMaxAttempts());
    }

    @Test
    public void testUpdateBoundaryShapeType() {
        viewPanel.getBoundaryShapeType().select("Triangle");
        cpc.updateBoundaryShapeType();
        assertEquals("triangle", model.getShapesParams().get(0).getShapeType());
    }

    @Test
    public void testUpdateBoundaryFillColour() {
        viewPanel.getBoundaryFillColourButton().setBackground(Color.BLUE);
        cpc.updateBoundaryFillColour();
        assertEquals(Color.BLUE, model.getShapesParams().get(0).getFillColour());

    }
    @Test
    public void testUpdateBoundaryLineColour(){
        viewPanel.getBoundaryLineColourButton().setBackground(Color.BLUE);
        cpc.updateBoundaryLineColour();
        assertEquals(Color.BLUE, model.getShapesParams().get(0).getLineColour());
    }

    @Test
    public void testUpdateBoundaryLineWidth() {
        viewPanel.getBoundaryLineWidthTextField().setText("12");
        cpc.updateBoundaryLineWidth();
        assertEquals(12, model.getShapesParams().get(0).getLineWidth(),0);
    }

    @Test
    public void testUpdateBoundaryRadius() {
        viewPanel.getBoundaryRadiusTextField().setText("300");
        cpc.updateBoundaryRadius();
        assertEquals(300, model.getPackingParams().getPolygonSize());
    }
    @Test
    public void testUpdatePackingFillColour() {
        Button fillColourButton = viewPanel.getPackingFillColourButton();
        fillColourButton.setBackground(Color.GREEN);
        cpc.updatePackingFillColour();
        assertEquals(Color.GREEN, model.getShapesParams().get(1).getFillColour());
    }
    @Test
    public void testUpdatePackingLineColour() {
        Button lineColourButton = viewPanel.getPackingLineColourButton();
        lineColourButton.setBackground(Color.RED);
        cpc.updatePackingLineColour();
        assertEquals(Color.RED, model.getShapesParams().get(1).getLineColour());
    }
    @Test
    public void testUpdatePackingLineWidth() {
        viewPanel.getPackingLineWidthTextField().setText("3");
        cpc.updatePackingLineWidth();
        assertEquals(3, model.getShapesParams().get(1).getLineWidth(), 0);
    }
    @Test
    public void testUpdateMinRadiusCircle() {
        viewPanel.getMinRadiusCircleTextField().setText("5");
        cpc.updateMinRadius();
        assertEquals(5, model.getPackingParams().getMinRadius());
    }
    @Test
    public void testUpdateMaxRadiusCircle() {
        viewPanel.getMaxRadiusCircleTextField().setText("50");
        cpc.updateMaxRadius();
        assertEquals(50, model.getPackingParams().getMaxRadius());
    }

}
