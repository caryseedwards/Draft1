package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RecursivePanel {
    private final TextField startXTextField;
    private final TextField startYTextField;
    private final TextField recursiveDepthTextField = new TextField("3",5);
    private final TextField initialRadiusTextField = new TextField("250",5);
    private final TextField numShapeTextField = new TextField("6",5);
    private final Choice largeShapeType = new Choice();
    private Color largeFillColour = new Color(255, 255, 255, 255); // Default white
    private Color largeLineColour = new Color(0, 0, 0, 255); // Default black
    private final TextField largeLineWidthTextField = new TextField("2", 5);
    private final Choice smallShapeType = new Choice();
    private Color smallFillColour = new Color(255, 255, 255, 255); // Default white
    private Color smallLineColour = new Color(0, 0, 0, 255); // Default black
    private final TextField smallLineWidthTextField = new TextField("2",5);
    private final Panel recursivePanel = new Panel(new GridBagLayout());


    public RecursivePanel(int width, int height) {
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
        addLabelAndField(gbc, "Depth/Iterations:", recursiveDepthTextField, gridy++);
        addLabelAndField(gbc, "Initial radius length:", initialRadiusTextField, gridy++);
        addLabelAndField(gbc, "Number of shapes:", numShapeTextField, gridy++);

        // Space before large shape section
        gbc.gridy = gridy++;
        recursivePanel.add(new Label(" "), gbc);

        // Large Shape
        gbc.insets = new Insets(10, 5, 0, 5); // Increase top padding for section label
        addSectionLabel(gbc, "Large Shape Inputs:", gridy++);

        // Reset insets and continue with fields
        gbc.insets = new Insets(2, 5, 2, 5);
        addLabelAndChoice(gbc, largeShapeType, new String[]{"Circle", "Square", "Triangle", "Hexagon"}, gridy++);
        addColorChooserButton(gbc, gridy++, largeFillColour, e -> {
            Color chosenColor = JColorChooser.showDialog(recursivePanel, "Choose Boundary Fill Color", largeFillColour);
            if (chosenColor != null) {
                largeFillColour = chosenColor;
            }
        });
        addColorChooserButton(gbc, gridy++, largeLineColour, e -> {
            Color chosenColor = JColorChooser.showDialog(recursivePanel, "Choose Line Fill Color", largeLineColour);
            if (chosenColor != null) {
                largeLineColour = chosenColor;
            }
        });
        addLabelAndField(gbc, "Line Width:", largeLineWidthTextField, gridy++);

        // Space before small shape section
        gbc.gridy = gridy++;
        recursivePanel.add(new Label(" "), gbc);

        // Small Shape
        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Small Shape Inputs:", gridy++);

        // Reset insets and continue with fields
        gbc.insets = new Insets(2, 5, 2, 5);
        addLabelAndChoice(gbc, smallShapeType, new String[]{"Circle", "Square", "Triangle", "Hexagon"}, gridy++);
        addColorChooserButton(gbc, gridy++, smallFillColour, e -> {
            Color chosenColor = JColorChooser.showDialog(recursivePanel, "Choose Boundary Fill Color", smallFillColour);
            if (chosenColor != null) {
                smallFillColour = chosenColor;
            }
        });
        addColorChooserButton(gbc, gridy++, smallLineColour, e -> {
            Color chosenColor = JColorChooser.showDialog(recursivePanel, "Choose Line Fill Color", smallLineColour);
            if (chosenColor != null) {
                smallLineColour = chosenColor;
            }
        });
        addLabelAndField(gbc, "Line Width:", smallLineWidthTextField, gridy);

        recursivePanel.setVisible(false);
    }


    private void addLabelAndField(GridBagConstraints gbc, String labelText, TextField textField, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        recursivePanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        recursivePanel.add(textField, gbc);
    }

    private void addSectionLabel(GridBagConstraints gbc, String labelText, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 2;
        Label sectionLabel = new Label(labelText);
        sectionLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        recursivePanel.add(sectionLabel, gbc);
        gbc.gridwidth = 1;
        gbc.insets = new Insets(2, 5, 2, 5);
    }

    private void addLabelAndChoice(GridBagConstraints gbc, Choice choice, String[] items, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        recursivePanel.add(new Label("Shape Type:"), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        recursivePanel.add(choice, gbc);
    }

    private void addColorChooserButton(GridBagConstraints gbc, int gridy, Color initialColor, ActionListener action) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        recursivePanel.add(new Label("Fill Colour:"), gbc);

        // Button for color chooser
        Button colorButton = new Button("Choose Colour");
        colorButton.addActionListener(action);

        gbc.gridx = 1; // Place button in the second column
        recursivePanel.add(colorButton, gbc);
    }

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

    public Color getLargeFillColour() {
        return largeFillColour;
    }

    public Color getLargeLineColour() {
        return largeLineColour;
    }

    public TextField getLargeLineWidthTextField() {
        return largeLineWidthTextField;
    }

    public Choice getSmallShapeType() {
        return smallShapeType;
    }

    public Color getSmallFillColour() {
        return smallFillColour;
    }

    public Color getSmallLineColour() {
        return smallLineColour;
    }

    public TextField getSmallLineWidthTextField() {
        return smallLineWidthTextField;
    }
    public Panel getRecursivePanel() {
        return this.recursivePanel;
    }
}
