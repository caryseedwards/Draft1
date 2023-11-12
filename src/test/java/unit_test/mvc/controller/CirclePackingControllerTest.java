package unit_test.mvc.controller;

import gui.controller.ArtworkGUIController;
import gui.controller.CirclePackingController;
import gui.model.ParametersModel;
import gui.view.ArtworkGUIView;
import gui.view.CirclePackingPanelView;
import org.junit.Before;
import org.junit.Test;
import parameters.CanvasParameters;
import parameters.CirclePackingAlgorithmParameters;
import parameters.ShapeParameters;

import static org.junit.Assert.*;

import java.awt.*;
import java.util.ArrayList;

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

        // Create default instances for model fields
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
    public void testUpdateBoundaryFillColourAndLineColour() {
        viewPanel.getBoundaryFillColourButton().setBackground(Color.BLUE);
        cpc.updateBoundaryFillColour();
        assertEquals(Color.BLUE, model.getShapesParams().get(0).getFillColour());

    }
//    @Test
//    public void testUpdateBoundaryLineColour(){
//        viewPanel.getBoundaryLineColourButton().setBackground(Color.BLUE);
//        cpc.updateBoundaryLineColour();
//        assertEquals(Color.BLUE, model.getShapesParams().get(0).getLineColour());
//    }

    @Test
    public void testUpdateBoundaryLineWidth() {
        viewPanel.getBoundaryLineWidthTextField().setText("12");
        cpc.updateBoundaryLineWidth();
        assertEquals(12, model.getShapesParams().get(0).getLineWidth());
    }

//        @Test
//        public void testUpdateBoundaryRadius() {
//            String testRadius = "300";
//            when(view.getBoundaryRadiusTextField().getText()).thenReturn(testRadius);
//            controller.updateBoundaryRadius();
//            assertEquals(Integer.parseInt(testRadius), model.getPackingParams().getPolygonSize());
//        }
//        controller.updateBoundaryLineColor();
//        assertEquals(testColor, model.getShapesParams().get(0).getLineColour());
//    }
//    @Test
//    public void testUpdateBoundaryLineWidth() {
//        String testLineWidth = "2";
//        when(view.getBoundaryLineWidthTextField().getText()).thenReturn(testLineWidth);
//        controller.updateBoundaryLineWidth();
//        assertEquals(Integer.parseInt(testLineWidth), model.getShapesParams().get(0).getLineWidth());
//    }
//    @Test
//    public void testUpdateBoundaryRadius() {
//        String testRadius = "300";
//        when(view.getBoundaryRadiusTextField().getText()).thenReturn(testRadius);
//        controller.updateBoundaryRadius();
//        assertEquals(Integer.parseInt(testRadius), model.getPackingParams().getPolygonSize());
//    }

}
