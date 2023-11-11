package unit_test.gui;

import gui.ArtworkGUI;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ArtworkGUITest {

    @Test
    public void testInitialCanvasSetup() {
        Dimension expectedDimension = new Dimension(ArtworkGUI.CANVAS_WIDTH, ArtworkGUI.CANVAS_HEIGHT);
        assertEquals(expectedDimension, ArtworkGUI.canvas.getPreferredSize());
    }

    @Test
    public void testAlgorithmDropdownSetup() {
        Choice algorithmDropdown = ArtworkGUI.algorithmDropdown;
        assertNotNull(algorithmDropdown);
        assertEquals(4, algorithmDropdown.getItemCount());
        assertEquals("-", algorithmDropdown.getItem(0));
        assertEquals("Circle Packing", algorithmDropdown.getItem(1));
        assertEquals("Recursive Shape", algorithmDropdown.getItem(2));
        assertEquals("Sierpinski Shape", algorithmDropdown.getItem(3));
    }

    @Test
    public void testInitialPanelVisibility() {
        assertFalse(ArtworkGUI.recursivePanel.isVisible());
        assertFalse(ArtworkGUI.circlePackingPanel.isVisible());
        assertFalse(ArtworkGUI.sierpinskiPanel.isVisible());
    }

    @Test
    public void testErrorLabelInitialSetup() {
        assertEquals("", ArtworkGUI.errorLabel.getText());
        assertFalse(ArtworkGUI.errorLabel.isVisible());
    }

}
