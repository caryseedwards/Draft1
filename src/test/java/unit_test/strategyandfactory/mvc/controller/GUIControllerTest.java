package unit_test.strategyandfactory.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import strategyandfactory.gui.controller.ArtworkGUIController;
import strategyandfactory.gui.controller.CirclePackingController;
import strategyandfactory.gui.controller.RecursiveShapeController;
import strategyandfactory.gui.controller.SierpinskiController;
import strategyandfactory.gui.model.ParametersModel;
import strategyandfactory.gui.view.ArtworkGUIView;

import static org.junit.Assert.*;

public class GUIControllerTest {

    private ArtworkGUIController controller;
    private ArtworkGUIView view;
    private ParametersModel model;

    @Before
    public void setUp() {
        view = new ArtworkGUIView();
        model = new ParametersModel();
        controller = new ArtworkGUIController(view, model);
    }

    @Test
    public void testUpdateAlgorithmPanelVisibility() {
        controller.updateAlgorithmPanelVisibility("Recursive Shape");
        assertTrue(view.getRecursivePanel().isVisible());
        assertFalse(view.getCirclePackingPanel().isVisible());
        assertFalse(view.getSierpinskiPanel().isVisible());

        controller.updateAlgorithmPanelVisibility("Circle Packing");
        assertFalse(view.getRecursivePanel().isVisible());
        assertTrue(view.getCirclePackingPanel().isVisible());
        assertFalse(view.getSierpinskiPanel().isVisible());

        controller.updateAlgorithmPanelVisibility("Sierpinski Shape");
        assertFalse(view.getRecursivePanel().isVisible());
        assertFalse(view.getCirclePackingPanel().isVisible());
        assertTrue(view.getSierpinskiPanel().isVisible());

        controller.updateAlgorithmPanelVisibility("Invalid Algorithm");
        assertFalse(view.getRecursivePanel().isVisible());
        assertFalse(view.getCirclePackingPanel().isVisible());
        assertFalse(view.getSierpinskiPanel().isVisible());
    }
    @Test
    public void testControllerSettersAndGetters() {
        RecursiveShapeController rsc = new RecursiveShapeController(model, view.getRecursivePanelView());
        controller.setRecursiveController(rsc);
        assertEquals(rsc, controller.getRecursiveController());

        CirclePackingController cpc = new CirclePackingController(model, view.getCirclePackingPanelView());
        controller.setPackingController(cpc);
        assertEquals(cpc, controller.getPackingController());

        SierpinskiController sc = new SierpinskiController(model, view.getSierpinskiPanelView());
        controller.setSierpinskiPanelController(sc);
        assertEquals(sc, controller.getSierpinskiPanelController());
    }
}