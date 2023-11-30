package version3.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates the Sierpinski Shape algorithm panel for the GUI
 * @author carysedwards
 */
public class SierpinskiPanel {
    private final TextField startXTextField;
    private final TextField startYTextField;
    private final TextField sizeTextField = new TextField("300", 5);
    private final TextField depthTextField = new TextField("5", 5);
    private final Choice shapeTypeChoice = new Choice();
    private final TextField lineWidthTextField = new TextField("1", 5);
    private final Panel sierpinskiPanel = new Panel(new GridBagLayout());
    private Color fillColour = new Color(255, 255, 255, 255);
    private Color lineColour = new Color(0, 0, 0, 255);

    /**
     * Creates the sierpinski algorithm panel
     * @param width - the starting canvas width
     * @param height - the starting canvas height
     */
    public SierpinskiPanel(int width, int height) {
        this.startXTextField = new TextField(String.valueOf(width / 2), 5);
        this.startYTextField = new TextField(String.valueOf(1050), 5);
        setupPanel();
    }

    /**
     * Initialises the panel and sets default values
     */
    private void setupPanel() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc);

        int gridy = 1;
        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Size:", sizeTextField, gridy++);
        addLabelAndField(gbc, "Depth:", depthTextField, gridy++);

        addLabelAndChoice(gbc, shapeTypeChoice, new String[]{"Hexagon", "Square", "Circle", "Triangle"}, gridy++);
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
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        sierpinskiPanel.add(textField, gbc);
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
        sierpinskiPanel.add(new Label("Shape Type:"), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        sierpinskiPanel.add(choice, gbc);
    }

    /**
     * Helper method for creating a section label
     * @param gbc - the Grid layout constraints
     */
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

    /**
     * Helper method for creating a colour chooser and label
     * @param gbc - the Grid layout constraints
     * @param action - the action listener
     * @param initialColor - the initial colour of the chooser
     * @param gridy - the grid y value (column)
     */
    private void addColorChooserButton(GridBagConstraints gbc, int gridy, Color initialColor, ActionListener action) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        sierpinskiPanel.add(new Label("Fill Colour:"), gbc);

        Button colorButton = new Button("Choose Colour");
        colorButton.addActionListener(action);

        gbc.gridx = 1;
        sierpinskiPanel.add(colorButton, gbc);
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
     * Gets the size text
     * @return sizeTextField
     */
    public TextField getSizeTextField() {
        return sizeTextField;
    }

    /**
     * Gets the recursive depth field
     * @return depthTextField
     */
    public TextField getDepthTextField() {
        return depthTextField;
    }

    /**
     * Gets the shape type
     * @return shapeTypeChoice
     */
    public Choice getShapeTypeChoice() {
        return shapeTypeChoice;
    }

    /**
     * Gets the fill colour
     * @return fillColour
     */
    public Color getFillColour() {
        return fillColour;
    }

    /**
     * Gets the line colour
     * @retur lineColour
     */
    public Color getLineColour() {
        return lineColour;
    }

    /**
     * Gets the line width text
     * @return lineWidthTextField
     */
    public TextField getLineWidthTextField() {
        return lineWidthTextField;
    }

    /**
     * Gets the panel
     * @return sierpinskiPanel
     */
    public Panel getPanel() {
        return sierpinskiPanel;
    }

}
