package gui.view;

import gui.model.ParametersModel;
import parameters.*;

import java.awt.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class RecursivePanelView {
    private final Panel recursivePanel;
    private int canvasWidth;
    private int canvasHeight;
    private TextField startXTextField;
    private TextField startYTextField;
    private TextField recursiveDepthTextField;
    private TextField initialRadiusTextField;
    private TextField numShapeTextField;
    private Choice largeShapeType;
    private Button largeShapeColorButton;
    private Button largeLineColorButton;
    private TextField largeLineWidthTextField;
    private Choice smallShapeType;
    private Button smallShapeColorButton;
    private Button smallLineColorButton;
    private TextField smallLineWidthTextField;

    public RecursivePanelView(int canvasWidth, int canvasHeight) {
        recursivePanel = new Panel(new GridBagLayout());
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.startXTextField = new TextField(String.valueOf(canvasWidth/2), 5);
        this.startYTextField= new TextField(String.valueOf(canvasHeight/2), 5);
        setupPanel();
    }

    private void setupPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 5);

        int gridy = 0;

        startXTextField = new TextField("250",5);
        startYTextField = new TextField("250",5);
        recursiveDepthTextField = new TextField("4",5);
        initialRadiusTextField = new TextField("100",5);
        numShapeTextField = new TextField("6",5);
        largeShapeType = new Choice();
        largeShapeColorButton = new Button("Choose Colour");
        largeLineColorButton = new Button("Choose Colour");
        largeLineWidthTextField = new TextField("1",5);
        smallShapeType = new Choice();
        smallShapeColorButton = new Button("Choose Colour");
        smallLineColorButton = new Button("Choose Colour");
        smallLineWidthTextField = new TextField("1",5);

        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Depth/Iterations:", recursiveDepthTextField, gridy++);
        addLabelAndField(gbc, "Initial radius length:", initialRadiusTextField, gridy++);
        addLabelAndField(gbc, "Number of shapes:", numShapeTextField, gridy++);

        String[] shapeTypes = {"Triangle", "Square", "Circle", "Hexagon"};
        addLabelAndChoice(gbc, "Large Shape Type:", largeShapeType, shapeTypes, gridy++);
        addColorChooserButton(gbc, "Large Shape Fill Color:", largeShapeColorButton, gridy++);
        addColorChooserButton(gbc, "Large Shape Line Color:", largeLineColorButton, gridy++);
        addLabelAndField(gbc, "Large Shape Line Width:", largeLineWidthTextField, gridy++);

        addLabelAndChoice(gbc, "Small Shape Type:", smallShapeType, shapeTypes, gridy++);
        addColorChooserButton(gbc, "Small Shape Fill Color:", smallShapeColorButton, gridy++);
        addColorChooserButton(gbc, "Small Shape Line Color:", smallLineColorButton, gridy++);
        addLabelAndField(gbc, "Small Shape Line Width:", smallLineWidthTextField, gridy);

        // Configure color pickers
        configureColorPicker(largeShapeColorButton);
        configureColorPicker(largeLineColorButton);
        configureColorPicker(smallShapeColorButton);
        configureColorPicker(smallLineColorButton);
    }

    private void addLabelAndField(GridBagConstraints gbc, String labelText, TextField textField, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        recursivePanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        recursivePanel.add(textField, gbc);
    }

    private void addLabelAndChoice(GridBagConstraints gbc, String labelText, Choice choice, String[] items, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        recursivePanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        recursivePanel.add(choice, gbc);
    }

    private void addColorChooserButton(GridBagConstraints gbc, String labelText, Button button, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        recursivePanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        recursivePanel.add(button, gbc);
    }

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

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}
    // Getters for each UI component
    public TextField getStartXTextField() {
        return startXTextField;
    }

    public TextField getStartYTextField() {
        return startYTextField;
    }

    public TextField getRecursiveDepthTextField() {
        return recursiveDepthTextField;
    }

    public TextField getInitialRadiusTextField() {
        return initialRadiusTextField;
    }

    public TextField getNumShapeTextField() {
        return numShapeTextField;
    }

    public Choice getLargeShapeType() {
        return largeShapeType;
    }

    public Button getLargeShapeColorButton() {
        return largeShapeColorButton;
    }

    public Button getLargeLineColorButton() {
        return largeLineColorButton;
    }

    public TextField getLargeLineWidthTextField() {
        return largeLineWidthTextField;
    }

    public Choice getSmallShapeType() {
        return smallShapeType;
    }

    public Button getSmallShapeColorButton() {
        return smallShapeColorButton;
    }

    public Button getSmallLineColorButton() {
        return smallLineColorButton;
    }

    public TextField getSmallLineWidthTextField() {
        return smallLineWidthTextField;
    }

    public Panel getPanel() {
        return recursivePanel;
    }
}

