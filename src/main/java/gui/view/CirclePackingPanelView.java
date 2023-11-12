package gui.view;

import parameters.CirclePackingAlgorithmParameters;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CirclePackingPanelView {
    private Panel circlePackingPanel;
    private int canvasWidth;
    private int canvasHeight;
    private TextField startXTextField;
    private TextField startYTextField;
    private TextField maxAttemptsTextField;
    private Choice boundaryShapeType;
    private Button boundaryFillColourButton;
    private Button boundaryLineColourButton;
    private TextField boundaryLineWidthTextField;
    private TextField boundaryRadiusTextField;
    private Button packingFillColourButton;
    private Button packingLineColourButton;
    private TextField packingLineWidthTextField;
    private TextField minRadiusCircleTextField;
    private TextField maxRadiusCircleTextField;

    public CirclePackingPanelView(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.startXTextField = new TextField(String.valueOf(canvasWidth/2), 5);
        this.startYTextField= new TextField(String.valueOf(canvasHeight/2), 5);
        circlePackingPanel = new Panel(new GridBagLayout());
        setupPanel();
    }


    private void setupPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 5);

        int gridy = 0;
        startXTextField = new TextField(String.valueOf(canvasWidth/2),5);
        startYTextField = new TextField(String.valueOf(canvasHeight/2),5);
        maxAttemptsTextField = new TextField("100", 5);
        boundaryShapeType = new Choice();
        boundaryFillColourButton = new Button("Choose Colour");
        boundaryLineColourButton = new Button("Choose Colour");
        boundaryLineWidthTextField = new TextField("1", 5);
        boundaryRadiusTextField = new TextField("100", 5);
        packingFillColourButton = new Button("Choose Colour");
        packingLineColourButton = new Button("Choose Colour");
        packingLineWidthTextField = new TextField("1", 5);
        minRadiusCircleTextField = new TextField("5", 5);
        maxRadiusCircleTextField = new TextField("50", 5);

        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Maximum attempts:", maxAttemptsTextField, gridy++);

        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Boundary Shape Inputs:", gridy++);
        addLabelAndChoice(gbc, "Boundary Shape Type:", boundaryShapeType, new String[]{"Circle", "Square", "Triangle", "Hexagon"}, gridy++);
        addColorChooserButton(gbc, "Boundary Fill Colour:", boundaryFillColourButton, gridy++);
        addColorChooserButton(gbc, "Boundary Line Colour:", boundaryLineColourButton, gridy++);
        addLabelAndField(gbc, "Boundary Line Width:", boundaryLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Boundary Radius:", boundaryRadiusTextField, gridy++);

        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Circle Packing Shape Inputs:", gridy++);
        addColorChooserButton(gbc, "Packing Fill Colour:", packingFillColourButton, gridy++);
        addColorChooserButton(gbc, "Packing Line Colour:", packingLineColourButton, gridy++);
        addLabelAndField(gbc, "Packing Line Width:", packingLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Minimum Circle Radius:", minRadiusCircleTextField, gridy++);
        addLabelAndField(gbc, "Maximum Circle Radius:", maxRadiusCircleTextField, gridy++);
        gbc.weighty = 1;

        configureColorPicker(boundaryFillColourButton);
        configureColorPicker(boundaryLineColourButton);
        configureColorPicker(packingFillColourButton);
        configureColorPicker(packingLineColourButton);
    }

    private void addLabelAndField(GridBagConstraints gbc, String labelText, Component component, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        circlePackingPanel.add(component, gbc);
    }

    private void addSectionLabel(GridBagConstraints gbc, String labelText, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 2;
        Label sectionLabel = new Label(labelText);
        sectionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        circlePackingPanel.add(sectionLabel, gbc);
        gbc.gridwidth = 1;
    }

    private void addLabelAndChoice(GridBagConstraints gbc, String labelText, Choice choice, String[] items, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        circlePackingPanel.add(choice, gbc);
    }

    private void addColorChooserButton(GridBagConstraints gbc, String labelText, Button button, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        circlePackingPanel.add(button, gbc);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}
    public TextField getStartXTextField() {
        return startXTextField;
    }

    public TextField getStartYTextField() {
        return startYTextField;
    }

    public TextField getMaxAttemptsTextField() {
        return maxAttemptsTextField;
    }

    public Choice getBoundaryShapeType() {
        return boundaryShapeType;
    }

    public Button getBoundaryFillColourButton() {
        return boundaryFillColourButton;
    }

    public Button getBoundaryLineColourButton() {
        return boundaryLineColourButton;
    }

    public TextField getBoundaryLineWidthTextField() {
        return boundaryLineWidthTextField;
    }

    public TextField getBoundaryRadiusTextField() {
        return boundaryRadiusTextField;
    }

    public Button getPackingFillColourButton() {
        return packingFillColourButton;
    }

    public Button getPackingLineColourButton() {
        return packingLineColourButton;
    }

    public TextField getPackingLineWidthTextField() {
        return packingLineWidthTextField;
    }

    public TextField getMinRadiusCircleTextField() {
        return minRadiusCircleTextField;
    }

    public TextField getMaxRadiusCircleTextField() {
        return maxRadiusCircleTextField;
    }

    public Panel getPanel() {
        return circlePackingPanel;
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
}
