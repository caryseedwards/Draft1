package gui;

import java.awt.*;

public class util {
    public static Panel createColorPickerPanel(String title, TextField[] rgbaFields, int[] defaultValues) {
        Panel colorPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label titleLabel = new Label(title);
        colorPanel.add(titleLabel);

        String[] rgba = {"R", "G", "B", "A"};
        for (int i = 0; i < rgba.length; i++) {
            Label tempLabel = new Label(rgba[i] + ":");
            rgbaFields[i] = new TextField(3);
            rgbaFields[i].setText(Integer.toString(defaultValues[i]));  // Initialize with default value
            colorPanel.add(tempLabel);
            colorPanel.add(rgbaFields[i]);
        }
        return colorPanel;
    }
}
