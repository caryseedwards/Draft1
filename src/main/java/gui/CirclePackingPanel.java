package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CirclePackingPanel {
    private final TextField startXTextField;
    private final TextField startYTextField;
    private final TextField maxAttemptsTextField = new TextField("500", 5);
    private final Choice boundaryShapeType = new Choice();
    private Color boundaryFillColor = new Color(255, 255, 255, 255); // Default white
    private Color boundaryLineColor = new Color(0, 0, 0, 255); // Default black
    private final TextField boundaryLineWidthTextField = new TextField("1.0", 5);
    private final TextField boundaryRadiusTextField = new TextField("250", 5);
    private Color packingFillColor = new Color(255, 255, 255, 255); // Default white
    private Color packingLineColor = new Color(0, 0, 0, 255); // Default black
    private final TextField packingLineWidthTextField = new TextField("1.0", 5);
    private final TextField minRadiusCircleTextField = new TextField("6", 5);
    private final TextField maxRadiusCircleTextField = new TextField("3", 5);
    private final Panel circlePackingPanel = new Panel(new GridBagLayout());

    public CirclePackingPanel(int width, int height){
        this.startXTextField = new TextField(String.valueOf(width/2), 5);
        this.startYTextField= new TextField(String.valueOf(height/2), 5);
        setupPanel();
    }


    private void setupPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        // General section
        gbc.insets = new Insets(10, 5, 0, 5); // Increase top padding for section title
        addSectionLabel(gbc, "General:", 0);

        int gridy = 1; // Start with 1 to leave space for the section label

        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Maximum attempts:", maxAttemptsTextField, gridy++);

        // Boundary Shape Inputs section
        // Space before small shape section
        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

        // Small Shape
        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Boundary Shape Inputs:", gridy++);

        // Boundary Shape Type
        addLabelAndChoice(gbc, boundaryShapeType, new String[]{"Circle", "Square", "Triangle", "Hexagon"}, gridy++);

        addColorChooserButton(gbc, "Boundary Fill Colour:", gridy++, boundaryFillColor, e -> {
            Color chosenColor = JColorChooser.showDialog(circlePackingPanel, "Choose Boundary Fill Color", boundaryFillColor);
            if (chosenColor != null) {
                boundaryFillColor = chosenColor;
            }
        });
        addColorChooserButton(gbc, "Boundary Line Colour:", gridy++, boundaryLineColor, e -> {
            Color chosenColor = JColorChooser.showDialog(circlePackingPanel, "Choose Boundary Line Color", boundaryLineColor);
            if (chosenColor != null) {
                boundaryLineColor = chosenColor;
            }
        });

        // Boundary Line Width and Radius
        addLabelAndField(gbc, "Boundary Line Width:", boundaryLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Boundary Radius:", boundaryRadiusTextField, gridy++);

        // Circle Packing Shape Inputs section
        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

        // Small Shape
        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Circle Packing Shape Inputs:", gridy++);

        addColorChooserButton(gbc, "Packing Fill Colour:", gridy++, packingFillColor, e -> {
            Color chosenColor = JColorChooser.showDialog(circlePackingPanel, "Choose Packing Fill Color", packingFillColor);
            if (chosenColor != null) {
                packingFillColor = chosenColor;
            }
        });
        addColorChooserButton(gbc, "Packing Line Colour:", gridy++, packingLineColor, e -> {
            Color chosenColor = JColorChooser.showDialog(circlePackingPanel, "Choose Packing Line Color", packingLineColor);
            if (chosenColor != null) {
                packingLineColor = chosenColor;
            }
        });

        // Packing Line Width and Radius Range
        addLabelAndField(gbc, "Packing Line Width:", packingLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Minimum Circle Radius:", minRadiusCircleTextField, gridy++);
        addLabelAndField(gbc, "Maximum Circle Radius:", maxRadiusCircleTextField, gridy++);

        // Final adjustments
        gbc.weighty = 1;
        circlePackingPanel.setVisible(true);
    }


    private void addLabelAndField(GridBagConstraints gbc, String labelText, TextField textField, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        circlePackingPanel.add(textField, gbc);
    }

    private void addSectionLabel(GridBagConstraints gbc, String labelText, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 2;
        Label sectionLabel = new Label(labelText);
        sectionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        circlePackingPanel.add(sectionLabel, gbc);
        gbc.gridwidth = 1;
        gbc.insets = new Insets(2, 5, 2, 5);
    }

    private void addLabelAndChoice(GridBagConstraints gbc, Choice choice, String[] items, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        circlePackingPanel.add(new Label("Shape Type:"), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        circlePackingPanel.add(choice, gbc);
    }

    private void addColorChooserButton(GridBagConstraints gbc, String labelText, int gridy, Color initialColor, ActionListener action) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1; // Use one column for the label
        gbc.anchor = GridBagConstraints.WEST;
        circlePackingPanel.add(new Label(labelText), gbc);

        // Button for color chooser
        Button colorButton = new Button("Choose Colour");
        colorButton.addActionListener(action);

        gbc.gridx = 1; // Place button in the second column
        circlePackingPanel.add(colorButton, gbc);
    }

    // You'll need to implement or adjust createColorPickerPanel to match this setup.
    private Panel createColorPickerPanel(String labelText, TextField[] colorFields, int[] defaultValues) {
        Panel colorPanel = new Panel();
        colorPanel.add(new Label(labelText));
        for (int i = 0; i < colorFields.length; i++) {
            colorFields[i] = new TextField(Integer.toString(defaultValues[i]), 3);
            colorPanel.add(colorFields[i]);
        }
        return colorPanel;
    }

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

    public Color getBoundaryFillColor() {
        return boundaryFillColor;
    }

    public Color getBoundaryLineColor() {
        return boundaryLineColor;
    }

    public TextField getBoundaryLineWidthTextField() {
        return boundaryLineWidthTextField;
    }

    public TextField getBoundaryRadiusTextField() {
        return boundaryRadiusTextField;
    }

    public Color getPackingFillColor() {
        return packingFillColor;
    }

    public Color getPackingLineColor() {
        return packingLineColor;
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

    public Panel getCirclePackingPanel() {
        return circlePackingPanel;
    }
}