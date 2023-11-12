package gui.view;

import javax.swing.*;
import java.awt.*;

public class utilities {
    // Methods to open colour picker and update button background
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

    // Method to retrieve colour from colour picker
    public static Color getColourFromButton(Button button) {
        return button.getBackground();
    }
}
