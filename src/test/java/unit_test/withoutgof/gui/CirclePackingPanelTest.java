package unit_test.withoutgof.gui;

import withoutgof.gui.CirclePackingPanel;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CirclePackingPanelTest {

    private CirclePackingPanel panel;

    @Before
    public void setUp() {
        panel = new CirclePackingPanel(500, 500);
    }

    @Test
    public void testTextFieldInitializations() {
        assertEquals("250", panel.getStartXTextField().getText());
        assertEquals("250", panel.getStartYTextField().getText());
        assertEquals("500", panel.getMaxAttemptsTextField().getText());
        assertEquals("250", panel.getBoundaryRadiusTextField().getText());
        assertEquals("1", panel.getBoundaryLineWidthTextField().getText());
        assertEquals("6", panel.getMinRadiusCircleTextField().getText());
        assertEquals("3", panel.getMaxRadiusCircleTextField().getText());
        assertEquals("1", panel.getPackingLineWidthTextField().getText());
    }

    @Test
    public void testBoundaryShapeTypeChoicesInitialization() {
        Choice boundaryShape = panel.getBoundaryShapeType();
        assertTrue(boundaryShape.getItemCount() > 0);
        assertEquals("Circle", boundaryShape.getItem(0));
        assertEquals("Square", boundaryShape.getItem(1));
        assertEquals("Triangle", boundaryShape.getItem(2));
        assertEquals("Hexagon", boundaryShape.getItem(3));
    }

    @Test
    public void testColorInitializations() {
        assertEquals(new Color(255, 255, 255, 255), panel.getBoundaryFillColor());
        assertEquals(new Color(0, 0, 0, 255), panel.getBoundaryLineColor());
        assertEquals(new Color(255, 255, 255, 255), panel.getPackingFillColor());
        assertEquals(new Color(0, 0, 0, 255), panel.getPackingLineColor());
    }

    @Test
    public void testPanelVisibility() {
        assertTrue(panel.getPanel().isVisible());
    }

    @Test
    public void testUpdateMaxAttemptsTextField() {
        panel.getMaxAttemptsTextField().setText("600");
        assertEquals("600", panel.getMaxAttemptsTextField().getText());
    }

    @Test
    public void testUpdateBoundaryRadiusTextField() {
        panel.getBoundaryRadiusTextField().setText("300");
        assertEquals("300", panel.getBoundaryRadiusTextField().getText());
    }

    @Test
    public void testUpdateBoundaryLineWidthTextField() {
        panel.getBoundaryLineWidthTextField().setText("2");
        assertEquals("2", panel.getBoundaryLineWidthTextField().getText());
    }

    @Test
    public void testUpdateMinRadiusCircleTextField() {
        panel.getMinRadiusCircleTextField().setText("5");
        assertEquals("5", panel.getMinRadiusCircleTextField().getText());
    }

    @Test
    public void testUpdateMaxRadiusCircleTextField() {
        panel.getMaxRadiusCircleTextField().setText("4");
        assertEquals("4", panel.getMaxRadiusCircleTextField().getText());
    }

    @Test
    public void testUpdatePackingLineWidthTextField() {
        panel.getPackingLineWidthTextField().setText("2");
        assertEquals("2", panel.getPackingLineWidthTextField().getText());
    }

    @Test
    public void testBoundaryShapeTypeChange() {
        panel.getBoundaryShapeType().select("Square");
        assertEquals("Square", panel.getBoundaryShapeType().getSelectedItem());
    }

    @Test
    public void testBoundaryShapeSelectionChange() {
        panel.getBoundaryShapeType().select("Hexagon");
        assertEquals("Hexagon", panel.getBoundaryShapeType().getSelectedItem());
    }
}
