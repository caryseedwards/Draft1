package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SierpinskiPanel {
    private final TextField startXTextField;
    private final TextField startYTextField;
    private final TextField sizeTextField = new TextField("300", 5);
    private final TextField depthTextField = new TextField("5", 5);
    private final Choice shapeTypeChoice = new Choice();
    private Color fillColour = new Color(255, 255, 255, 255);
    private Color lineColour = new Color(0, 0, 0, 255);
    private final TextField lineWidthTextField = new TextField("1", 5);
    private final Panel sierpinskiPanel = new Panel(new GridBagLayout());

    public SierpinskiPanel(int width, int height) {
        this.startXTextField = new TextField(String.valueOf(width/2), 5);
        this.startYTextField= new TextField(String.valueOf(1050), 5);
        setupPanel();
    }

    private void setupPanel() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        // General section
        gbc.insets = new Insets(10, 5, 0, 5); // Increase top padding for section title
        addSectionLabel(gbc);

        int gridy = 1; // Start with 1 to leave space for the section label


        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Size:", sizeTextField, gridy++);
        addLabelAndField(gbc, "Depth:", depthTextField, gridy++);

        addLabelAndChoice(gbc, shapeTypeChoice, new String[]{"Triangle", "Square", "Circle", "Hexagon"}, gridy++);
        addColorChooserButton(gbc, gridy++, fillColour, e -> {
            Color chosenColor = JColorChooser.showDialog(sierpinskiPanel, "Choose Boundary Fill Color", fillColour);
            if (chosenColor != null) {
                fillColour = chosenColor;
            }
        });
        addColorChooserButton(gbc, gridy++, lineColour, e -> {
            Color chosenColor = JColorChooser.showDialog(sierpinskiPanel, "Choose Line Fill Color", lineColour);
            if (chosenColor != null) {
                lineColour = chosenColor;
            }
        });
        addLabelAndField(gbc, "Line Width:", lineWidthTextField, gridy++);

        sierpinskiPanel.setVisible(false);
    }

    private void addLabelAndField(GridBagConstraints gbc, String labelText, TextField textField, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        sierpinskiPanel.add(textField, gbc);
    }

    private void addLabelAndChoice(GridBagConstraints gbc, Choice choice, String[] items, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        sierpinskiPanel.add(new Label("Shape Type:"), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        sierpinskiPanel.add(choice, gbc);
    }

    private void addSectionLabel(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        Label sectionLabel = new Label("General:");
        sectionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        sierpinskiPanel.add(sectionLabel, gbc);
        gbc.gridwidth = 1;
        gbc.insets = new Insets(2, 5, 2, 5);
    }


    private void addColorChooserButton(GridBagConstraints gbc, int gridy, Color initialColor, ActionListener action) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        sierpinskiPanel.add(new Label("Fill Colour:"), gbc);

        // Button for color chooser
        Button colorButton = new Button("Choose Colour");
        colorButton.addActionListener(action);

        gbc.gridx = 1; // Place button in the second column
        sierpinskiPanel.add(colorButton, gbc);
    }

    public TextField getStartXTextField() {
        return startXTextField;
    }

    public TextField getStartYTextField() {
        return startYTextField;
    }

    public TextField getSizeTextField() {
        return sizeTextField;
    }

    public TextField getDepthTextField() {
        return depthTextField;
    }

    public Choice getShapeTypeChoice() {
        return shapeTypeChoice;
    }

    public Color getFillColour() {
        return fillColour;
    }

    public Color getLineColour() {
        return lineColour;
    }

    public TextField getLineWidthTextField() {
        return lineWidthTextField;
    }

    public Panel getSierpinskiPanel() {
        return sierpinskiPanel;
    }

}
