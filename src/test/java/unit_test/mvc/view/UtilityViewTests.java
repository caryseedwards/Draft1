package unit_test.mvc.view;

import withoutgof.gui.view.utilities;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class UtilityViewTests {


    @Test
    public void testUpdateButtonBackgroundWithNewColor() {
        Button colourButton = new Button();
        colourButton.setBackground(Color.RED);
        Color newColor = Color.GREEN;
        utilities.updateButtonBackground(colourButton, newColor);
        assertEquals(newColor, colourButton.getBackground());
    }

    @Test
    public void testUpdateButtonBackgroundWithNullColor() {
        Button colourButton = new Button();
        Color initialColor = Color.RED;
        colourButton.setBackground(initialColor);

        utilities.updateButtonBackground(colourButton, null);

        assertEquals(initialColor, colourButton.getBackground());
    }

    @Test
    public void testRetrieveExistingColour() {
        Button colourButton = new Button();
        Color expectedColor = Color.YELLOW;
        colourButton.setBackground(expectedColor);

        Color actualColor = utilities.getColourFromButton(colourButton);

        assertEquals(expectedColor, actualColor);
    }
    @Test
    public void testRetrieveDefaultColour() {
        Button colourButton = new Button();
        Color defaultColor = colourButton.getBackground();

        Color actualColor = utilities.getColourFromButton(colourButton);

        assertEquals(defaultColor, actualColor);
    }

}
