package unit_test.version3.gui;

import version3.gui.SierpinskiPanel;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import static org.junit.Assert.*;

public class SierpinskiPanelTest {

    private SierpinskiPanel panel;

    @Before
    public void setUp() {
        panel = new SierpinskiPanel(500, 500);

    }

    @Test
    public void testTextFieldInitializations() {
        assertEquals("250", panel.getStartXTextField().getText());
        assertEquals("1050", panel.getStartYTextField().getText());
        assertEquals("300", panel.getSizeTextField().getText());
        assertEquals("5", panel.getDepthTextField().getText());
        assertEquals("1", panel.getLineWidthTextField().getText());
    }

    @Test
    public void testShapeTypeChoicesInitialization() {
        Choice shapeChoice = panel.getShapeTypeChoice();
        assertTrue(shapeChoice.getItemCount() > 0);
        assertEquals("Hexagon", shapeChoice.getItem(0));
        assertEquals("Square", shapeChoice.getItem(1));
        assertEquals("Circle", shapeChoice.getItem(2));
        assertEquals("Triangle", shapeChoice.getItem(3));
    }

    @Test
    public void testColorInitializations() {
        assertEquals(new Color(255, 255, 255, 255), panel.getFillColour());
        assertEquals(new Color(0, 0, 0, 255), panel.getLineColour());
    }

    @Test
    public void testPanelSetup() {
        assertFalse(panel.getPanel().isVisible());
    }

    @Test
    public void testDefaultLineWidth() {
        assertEquals("1", panel.getLineWidthTextField().getText());
    }

    @Test
    public void testShapeTypeChoiceDefaultSelection() {
        assertEquals("Hexagon", panel.getShapeTypeChoice().getSelectedItem());
    }

    @Test
    public void testInitialTextFieldConfigurations() {
        assertNotNull(panel.getStartXTextField());
        assertNotNull(panel.getStartYTextField());
        assertNotNull(panel.getSizeTextField());
        assertNotNull(panel.getDepthTextField());
        assertNotNull(panel.getLineWidthTextField());
    }

    @Test
    public void testUpdateStartXTextField() {
        panel.getStartXTextField().setText("300");
        assertEquals("300", panel.getStartXTextField().getText());
    }
    @Test
    public void testShapeTypeChoiceSelection() {
        panel.getShapeTypeChoice().select("Circle");
        assertEquals("Circle", panel.getShapeTypeChoice().getSelectedItem());
    }

    @Test
    public void testTogglePanelVisibility() {
        panel.getPanel().setVisible(true);
        assertTrue(panel.getPanel().isVisible());

        panel.getPanel().setVisible(false);
        assertFalse(panel.getPanel().isVisible());
    }

    @Test
    public void testComponentLayoutOrder() {
        Component[] components = panel.getPanel().getComponents();
        assertTrue(components[0] instanceof Label);
    }
}
