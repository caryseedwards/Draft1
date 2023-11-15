package withgof.gui.view;

import javax.swing.*;
import java.awt.*;

public class utilities {
    public static void configureColourPicker(Button colourButton) {
        colourButton.addActionListener(e -> {
            Color newColor = chooseColour(colourButton);
            updateButtonBackground(colourButton, newColor);
        });
    }

    static Color chooseColour(Button colourButton) {
        Color initialColor = colourButton.getBackground();
        return JColorChooser.showDialog(null, "Choose Colour", initialColor);
    }

    public static void updateButtonBackground(Button button, Color newColor) {
        if (newColor != null) {
            button.setBackground(newColor);
        }
    }

    public static Color getColourFromButton(Button button) {
        return button.getBackground();
    }
}
