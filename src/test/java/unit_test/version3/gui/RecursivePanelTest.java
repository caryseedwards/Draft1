package unit_test.version3.gui;

import version3.gui.RecursivePanel;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import static org.junit.Assert.*;

public class RecursivePanelTest {

    private RecursivePanel panel;

    @Before
    public void setUp() {
        panel = new RecursivePanel(500, 500);

    }

    @Test
    public void testTextFieldInitializations() {
        assertEquals("250", panel.getStartXTextField().getText());
        assertEquals("250", panel.getStartYTextField().getText());
        assertEquals("4", panel.getRecursiveDepthTextField().getText());
        assertEquals("150", panel.getInitialRadiusTextField().getText());
        assertEquals("6", panel.getNumShapeTextField().getText());
    }


    @Test
    public void testShapeTypeChoicesInitialization() {
        Choice largeShape = panel.getLargeShapeType();
        assertTrue(largeShape.getItemCount() > 0);
        assertEquals("Triangle", largeShape.getItem(0));
        assertEquals("Square", largeShape.getItem(1));
        assertEquals("Circle", largeShape.getItem(2));
        assertEquals("Hexagon", largeShape.getItem(3));


        Choice smallShape = panel.getSmallShapeType();
        assertTrue(smallShape.getItemCount() > 0);
        assertEquals("Triangle", smallShape.getItem(0));
        assertEquals("Square", smallShape.getItem(1));
        assertEquals("Circle", smallShape.getItem(2));
        assertEquals("Hexagon", smallShape.getItem(3));
    }

    @Test
    public void testLineWidthTextFieldInitializations() {
        assertEquals("1", panel.getLargeLineWidthTextField().getText());
        assertEquals("1", panel.getSmallLineWidthTextField().getText());
    }

    @Test
    public void testPanelSetup() {
        assertFalse(panel.getPanel().isVisible());
    }

    @Test
    public void testColorInitializations() {
        assertEquals(new Color(0, 0, 0, 0), panel.getLargeFillColour());
        assertEquals(Color.BLACK, panel.getLargeLineColour());
        assertEquals(new Color(0, 0, 0, 0), panel.getSmallFillColour());
        assertEquals(Color.BLACK, panel.getSmallLineColour());
    }

    @Test
    public void testChangeStartXTextField() {
        panel.getStartXTextField().setText("300");
        assertEquals("300", panel.getStartXTextField().getText());
    }

    @Test
    public void testChangeLargeShapeType() {
        panel.getLargeShapeType().select("Circle");
        assertEquals("Circle", panel.getLargeShapeType().getSelectedItem());
    }

    @Test
    public void testChangeSmallShapeType() {
        panel.getSmallShapeType().select("Square");
        assertEquals("Square", panel.getSmallShapeType().getSelectedItem());
    }

    @Test
    public void testToggleVisibility() {
        panel.getPanel().setVisible(true);
        assertTrue(panel.getPanel().isVisible());

        panel.getPanel().setVisible(false);
        assertFalse(panel.getPanel().isVisible());
    }

    @Test
    public void testUpdateRecursiveDepthTextField() {
        panel.getRecursiveDepthTextField().setText("5");
        assertEquals("5", panel.getRecursiveDepthTextField().getText());
    }

    @Test
    public void testUpdateInitialRadiusTextField() {
        panel.getInitialRadiusTextField().setText("200");
        assertEquals("200", panel.getInitialRadiusTextField().getText());
    }

    @Test
    public void testUpdateNumShapeTextField() {
        panel.getNumShapeTextField().setText("8");
        assertEquals("8", panel.getNumShapeTextField().getText());
    }

    @Test
    public void testUpdateLargeLineWidthTextField() {
        panel.getLargeLineWidthTextField().setText("2");
        assertEquals("2", panel.getLargeLineWidthTextField().getText());
    }

    @Test
    public void testUpdateSmallLineWidthTextField() {
        panel.getSmallLineWidthTextField().setText("3");
        assertEquals("3", panel.getSmallLineWidthTextField().getText());
    }

    @Test
    public void testLargeShapeTypeItemCount() {
        int expectedCount = 4;
        assertEquals(expectedCount, panel.getLargeShapeType().getItemCount());
    }

    @Test
    public void testSmallShapeTypeItemCount() {
        int expectedCount = 4;
        assertEquals(expectedCount, panel.getSmallShapeType().getItemCount());
    }



}
