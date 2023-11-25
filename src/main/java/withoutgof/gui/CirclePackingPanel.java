package withoutgof.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates the Circle Packing algorithm panel for the GUI
 * @author carysedwards
 */
public class CirclePackingPanel {
    private final TextField startXTextField;
    private final TextField startYTextField;
    private final TextField maxAttemptsTextField = new TextField("500", 5);
    private final Choice boundaryShapeType = new Choice();
    private final TextField boundaryLineWidthTextField = new TextField("1", 5);
    private final TextField boundaryRadiusTextField = new TextField("250", 5);
    private final TextField packingLineWidthTextField = new TextField("1", 5);
    private final TextField minRadiusCircleTextField = new TextField("6", 5);
    private final TextField maxRadiusCircleTextField = new TextField("3", 5);
    private final Panel circlePackingPanel = new Panel(new GridBagLayout());
    private Color boundaryFillColor = new Color(255, 255, 255, 255);
    private Color boundaryLineColor = new Color(0, 0, 0, 255);
    private Color packingFillColor = new Color(255, 255, 255, 255);
    private Color packingLineColor = new Color(0, 0, 0, 255);

    /**
     * Creates a new circle packing algorithm
     * @param width - width of the panel
     * @param height - height of the panel
     */
    public CirclePackingPanel(int width, int height) {
        this.startXTextField = new TextField(String.valueOf(width / 2), 5);
        this.startYTextField = new TextField(String.valueOf(height / 2), 5);
        setupPanel();
    }

    /**
     * Sets up and initialises the circle packing panel
     */
    private void setupPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "General:", 0);

        int gridy = 1;
        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Maximum attempts:", maxAttemptsTextField, gridy++);

        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Boundary Shape Inputs:", gridy++);

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

        addLabelAndField(gbc, "Boundary Line Width:", boundaryLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Boundary Radius:", boundaryRadiusTextField, gridy++);

        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

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

        addLabelAndField(gbc, "Packing Line Width:", packingLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Minimum Circle Radius:", minRadiusCircleTextField, gridy++);
        addLabelAndField(gbc, "Maximum Circle Radius:", maxRadiusCircleTextField, gridy++);
        gbc.weighty = 1;
        circlePackingPanel.setVisible(true);
    }

    /**
     * Helper method for creating a label and field
     * @param gbc - the Grid layout constraints
     * @param labelText - the string for the label
     * @param textField - the text field to add
     * @param gridy - the grid y value (column)
     */
    private void addLabelAndField(GridBagConstraints gbc, String labelText, TextField textField, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        circlePackingPanel.add(textField, gbc);
    }

    /**
     * Helper method for creating a section label
     * @param gbc - the Grid layout constraints
     * @param labelText - the text for the label
     * @param gridy - the grid y value (column)
     */
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

    /**
     * Helper method for creating a choice dropdown and label
     * @param gbc - the Grid layout constraints
     * @param choice - The choice dropdown to add
     * @param items - the items to go inside the choice dropdown
     * @param gridy - the grid y value (column)
     */
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

    /**
     * Helper method for creating a colour chooser and label
     * @param gbc - the Grid layout constraints
     * @param labelText - the label text
     * @param initialColor - the initial colour of the chooser
     * @param gridy - the grid y value (column)
     */
    private void addColorChooserButton(GridBagConstraints gbc, String labelText, int gridy, Color initialColor, ActionListener action) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        circlePackingPanel.add(new Label(labelText), gbc);

        Button colorButton = new Button("Choose Colour");
        colorButton.addActionListener(action);

        gbc.gridx = 1;
        circlePackingPanel.add(colorButton, gbc);
    }

    /**
     * Gets the startx text field
     * @return startXTextField
     */
    public TextField getStartXTextField() {
        return startXTextField;
    }

    /**
     * Gets the starty text field
     * @return startYTextField
     */
    public TextField getStartYTextField() {
        return startYTextField;
    }

    /**
     * Gets the max attempts text field
     * @return maxAttemptsTextField
     */
    public TextField getMaxAttemptsTextField() {
        return maxAttemptsTextField;
    }

    /**
     * Gets the boundary shape type
     * @return boundaryShapeType
     */
    public Choice getBoundaryShapeType() {
        return boundaryShapeType;
    }

    /**
     * Gets the boundary fill colour
     * @return boundaryFillColourButton
     */
    public Color getBoundaryFillColor() {
        return boundaryFillColor;
    }

    /**
     * Gets the boundary line colour
     * @return boundaryLineColourButton
     */
    public Color getBoundaryLineColor() {
        return boundaryLineColor;
    }

    /**
     * Gets the boundary line width text
     * @return boundaryLineWidthTextField
     */
    public TextField getBoundaryLineWidthTextField() {
        return boundaryLineWidthTextField;
    }

    /**
     * Gets the boundary radius text
     * @return boundaryRadiusTextField
     */
    public TextField getBoundaryRadiusTextField() {
        return boundaryRadiusTextField;
    }

    /**
     * gets the packing fill colour
     * @return packingFillColor
     */
    public Color getPackingFillColor() {
        return packingFillColor;
    }

    /**
     * Gets the packing line colour
     * @return packingLineColour
     */
    public Color getPackingLineColor() {
        return packingLineColor;
    }

    /**
     * Gets the packing line width text
     * @return packingLineWidthTextField
     */
    public TextField getPackingLineWidthTextField() {
        return packingLineWidthTextField;
    }

    /**
     * Gets the minimum radius circle text
     * @return minRadiusCircleTextField
     */
    public TextField getMinRadiusCircleTextField() {
        return minRadiusCircleTextField;
    }

    /**
     * Gets the max radius circle text
     * @return maxRadiusCircleTextField
     */
    public TextField getMaxRadiusCircleTextField() {
        return maxRadiusCircleTextField;
    }

    /**
     * Gets the panel
     * @return circlePackingPanel
     */
    public Panel getPanel() {
        return circlePackingPanel;
    }
}
