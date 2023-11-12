package gui.view;

import parameters.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JColorChooser;

public class SierpinskiPanelView {
    private Panel sierpinskiPanel;
    private int canvasWidth;
    private int canvasHeight;
    private TextField startXTextField;
    private TextField startYTextField;
    private TextField sizeTextField;
    private TextField depthTextField;
    private Choice shapeTypeChoice;
    private Button fillColourButton;
    private Button lineColourButton;
    private TextField lineWidthTextField;

    public SierpinskiPanelView(int canvasWidth, int canvasHeight) {
        this.startXTextField = new TextField(String.valueOf(canvasWidth/2), 5);
        this.startYTextField= new TextField(String.valueOf(canvasHeight/2), 5);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        sierpinskiPanel = new Panel(new GridBagLayout());
        setupPanel();
    }

    private void setupPanel() {
        startXTextField = new TextField(String.valueOf(canvasWidth/2), 5);
        startYTextField = new TextField(String.valueOf(canvasWidth/2),5);
        sizeTextField = new TextField("100", 5);
        depthTextField = new TextField("4", 5);
        shapeTypeChoice = new Choice();
        fillColourButton = new Button("Choose Colour");
        lineColourButton = new Button("Choose Colour");
        lineWidthTextField = new TextField("1", 5);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 0, 5);

        int gridy = 1;
        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Size:", sizeTextField, gridy++);
        addLabelAndField(gbc, "Depth:", depthTextField, gridy++);
        addLabelAndChoice(gbc, "Shape Type:", shapeTypeChoice, new String[]{"Hexagon", "Square", "Circle", "Triangle"}, gridy++);
        addColorChooserButton(gbc, "Fill Colour:", fillColourButton, gridy++);
        addColorChooserButton(gbc, "Line Colour:", lineColourButton, gridy++);
        addLabelAndField(gbc, "Line Width:", lineWidthTextField, gridy++);

        configureColorPicker(fillColourButton);
        configureColorPicker(lineColourButton);
    }

    private void addLabelAndField(GridBagConstraints gbc, String labelText, Component component, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        sierpinskiPanel.add(component, gbc);
    }

    private void addLabelAndChoice(GridBagConstraints gbc, String labelText, Choice choice, String[] items, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        sierpinskiPanel.add(choice, gbc);
    }

    private void addColorChooserButton(GridBagConstraints gbc, String labelText, Button button, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        button.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(sierpinskiPanel, "Choose Color", button.getBackground());
            if (chosenColor != null) {
                button.setBackground(chosenColor);
            }
        });
        sierpinskiPanel.add(button, gbc);
    }

    // Getters for UI components
    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}
    public TextField getStartXTextField() { return startXTextField; }
    public TextField getStartYTextField() { return startYTextField; }
    public TextField getSizeTextField() { return sizeTextField; }
    public TextField getDepthTextField() { return depthTextField; }
    public Choice getShapeTypeChoice() { return shapeTypeChoice; }
    public Button getFillColourButton() { return fillColourButton; }
    public Button getLineColourButton() { return lineColourButton; }
    public TextField getLineWidthTextField() { return lineWidthTextField; }
    public Panel getPanel() { return sierpinskiPanel; }
    // Method to open color picker and update button background
    public void configureColorPicker(Button colorButton) {
        colorButton.addActionListener(e -> {
            Color initialColor = colorButton.getBackground();
            Color newColor = JColorChooser.showDialog(null, "Choose Color", initialColor);
            if (newColor != null) {
                colorButton.setBackground(newColor);
            }
        });
    }

    public Color getColorFromButton(Button button) {
        return button.getBackground();
    }
}

