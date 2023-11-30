package unit_test.version1.mvc.view;

import version1.gui.view.Utilities;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class UtilityViewTests {


    @Test
    public void testUpdateButtonBackgroundWithNewColor() {
        Button colourButton = new Button();
        colourButton.setBackground(Color.RED);
        Color newColor = Color.GREEN;
        Utilities.updateButtonBackground(colourButton, newColor);
        assertEquals(newColor, colourButton.getBackground());
    }

    @Test
    public void testUpdateButtonBackgroundWithNullColor() {
        Button colourButton = new Button();
        Color initialColor = Color.RED;
        colourButton.setBackground(initialColor);

        Utilities.updateButtonBackground(colourButton, null);

        assertEquals(initialColor, colourButton.getBackground());
    }

    @Test
    public void testRetrieveExistingColour() {
        Button colourButton = new Button();
        Color expectedColor = Color.YELLOW;
        colourButton.setBackground(expectedColor);

        Color actualColor = Utilities.getColourFromButton(colourButton);

        assertEquals(expectedColor, actualColor);
    }
    @Test
    public void testRetrieveDefaultColour() {
        Button colourButton = new Button();
        Color defaultColor = colourButton.getBackground();

        Color actualColor = Utilities.getColourFromButton(colourButton);

        assertEquals(defaultColor, actualColor);
    }

}
