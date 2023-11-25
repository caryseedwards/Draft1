package strategyandfactory.gui.view;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class for the colour picker
 * @author carysedwards
 */
public class Utilities {
    /**
     * Configures the colour picker button to launch the colour picker and set the colour
     * @param colourButton
     */
    public static void configureColourPicker(Button colourButton) {
        colourButton.addActionListener(e -> {
            Color newColor = chooseColour(colourButton);
            updateButtonBackground(colourButton, newColor);
        });
    }

    /**
     * Creates the dialog to attach to the colour picker button
     * @param colourButton - the button to attach the dialog to
     * @return the colour selected
     */
    static Color chooseColour(Button colourButton) {
        Color initialColor = colourButton.getBackground();
        return JColorChooser.showDialog(null, "Choose Colour", initialColor);
    }

    /**
     * Updates the background of the colour picker button to the colour selected
     * @param button - the button used to select the colour
     * @param newColor - the background colour to set the button
     */
    public static void updateButtonBackground(Button button, Color newColor) {
        if (newColor != null) {
            button.setBackground(newColor);
        }
    }

    /**
     * Gets the colour selected by the button
     * @param button - the button used to get the colour
     * @return the colour selected
     */
    public static Color getColourFromButton(Button button) {
        return button.getBackground();
    }
}
