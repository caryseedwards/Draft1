package unit_test.version3.gui;

import version3.gui.ArtworkGUI;
import org.junit.BeforeClass;
import org.junit.Test;
import java.awt.*;

import static org.junit.Assert.*;


public class ArtworkGUITest {

    @BeforeClass
    public static void setUpClass() {
        ArtworkGUI.setupFrame();
        ArtworkGUI.setupLeftPanel();
        ArtworkGUI.setupCanvas();
        ArtworkGUI.setupBottomPanel();
    }

    @Test
    public void testAlgorithmDropdownSetup() {
        assertNotNull(ArtworkGUI.algorithmDropdown);
        assertTrue(ArtworkGUI.algorithmDropdown.getItemCount() > 0);
    }

    @Test
    public void testCanvasSetup() {
        assertNotNull(ArtworkGUI.canvas);
        assertEquals(new Dimension(ArtworkGUI.CANVAS_WIDTH, ArtworkGUI.CANVAS_HEIGHT),
                ArtworkGUI.canvas.getPreferredSize());
    }

    @Test
    public void testPanelsVisibility() {
        assertFalse(ArtworkGUI.recursivePanel.isVisible());
        assertFalse(ArtworkGUI.circlePackingPanel.isVisible());
        assertFalse(ArtworkGUI.sierpinskiPanel.isVisible());
    }

    @Test
    public void testErrorLabelSetup() {
        assertEquals("", ArtworkGUI.errorLabel.getText());
        assertTrue(ArtworkGUI.errorLabel.isVisible());
    }

    @Test
    public void testDropdownSelectionChange() {
        assertTrue(ArtworkGUI.algorithmDropdown.getItemCount() > 1);
        assertEquals("Circle Packing", ArtworkGUI.algorithmDropdown.getItem(1));

        ArtworkGUI.algorithmDropdown.select("Circle Packing");
        assertEquals("Circle Packing", ArtworkGUI.algorithmDropdown.getSelectedItem());
    }
}