package version3.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates the Recursive Shape algorithm panel for the GUI
 * @author carysedwards
 */
public class RecursivePanel {
    private final TextField startXTextField;
    private final TextField startYTextField;
    private final TextField recursiveDepthTextField = new TextField("4", 5);
    private final TextField initialRadiusTextField = new TextField("150", 5);
    private final TextField numShapeTextField = new TextField("6", 5);
    private final Choice largeShapeType = new Choice();
    private final TextField largeLineWidthTextField = new TextField("1", 5);
    private final Choice smallShapeType = new Choice();
    private final TextField smallLineWidthTextField = new TextField("1", 5);
    private final Panel recursivePanel = new Panel(new GridBagLayout());
    private Color largeFillColour = new Color(0, 0, 0, 0);
    private Color largeLineColour = Color.BLACK;
    private Color smallFillColour = new Color(0, 0, 0, 0);
    private Color smallLineColour = Color.BLACK;


    /**
     * Creates the recursive algorithm panel
     * @param width - the starting canvas width
     * @param height - the starting canvas height
     */
    public RecursivePanel(int width, int height) {
        this.startXTextField = new TextField(String.valueOf(width / 2), 5);
        this.startYTextField = new TextField(String.valueOf(height / 2), 5);
        setupPanel();
    }

    /**
     * Initialises the panel and sets default values
     */
    private void setupPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "General:", 0);

        int gridy = 1;
        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Depth/Iterations:", recursiveDepthTextField, gridy++);
        addLabelAndField(gbc, "Initial radius length:", initialRadiusTextField, gridy++);
        addLabelAndField(gbc, "Number of shapes:", numShapeTextField, gridy++);

        gbc.gridy = gridy++;
        recursivePanel.add(new Label(" "), gbc);

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Large Shape Inputs:", gridy++);

        gbc.insets = new Insets(2, 5, 2, 5);
        addLabelAndChoice(gbc, largeShapeType, new String[]{"Triangle", "Square", "Circle", "Hexagon"}, gridy++);
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

        gbc.gridy = gridy++;
        recursivePanel.add(new Label(" "), gbc);

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Small Shape Inputs:", gridy++);

        gbc.insets = new Insets(2, 5, 2, 5);
        addLabelAndChoice(gbc, smallShapeType, new String[]{"Triangle", "Square", "Circle", "Hexagon"}, gridy++);
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
        recursivePanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        recursivePanel.add(textField, gbc);
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
        recursivePanel.add(sectionLabel, gbc);
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
        recursivePanel.add(new Label("Shape Type:"), gbc);

        gbc.gridx = 1;
        for (String item : items) {
            choice.add(item);
        }
        recursivePanel.add(choice, gbc);
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
        recursivePanel.add(new Label("Fill Colour:"), gbc);

        Button colorButton = new Button("Choose Colour");
        colorButton.addActionListener(action);

        gbc.gridx = 1;
        recursivePanel.add(colorButton, gbc);
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
     * Gets the recursive depth  text
     * @return recursiveDepthTextField
     */
    public TextField getRecursiveDepthTextField() {
        return recursiveDepthTextField;
    }

    /**
     * Gets the initial radius text
     * @return initialRadiusTextField
     */
    public TextField getInitialRadiusTextField() {
        return initialRadiusTextField;
    }

    /**
     * Gets the number of shapes text
     * @return numShapeTextField
     */
    public TextField getNumShapeTextField() {
        return numShapeTextField;
    }

    /**
     * Gets the large shape type text
     * @return largeShapeType
     */
    public Choice getLargeShapeType() {
        return largeShapeType;
    }


    /**
     * Gets the large fill colour
     * @return largeFillColour
     */
    public Color getLargeFillColour() {
        return largeFillColour;
    }

    /**
     * Gets the large line colour
     * @return largeLineColour
     */
    public Color getLargeLineColour() {
        return largeLineColour;
    }

    /**
     * Gets the large line width text
     * @return largeLineWidthTextField
     */
    public TextField getLargeLineWidthTextField() {
        return largeLineWidthTextField;
    }

    /**
     * Gets the small shape type
     * @return smallShapeType
     */
    public Choice getSmallShapeType() {
        return smallShapeType;
    }

    /**
     * Gets the small fill colour
     * @return largeFillColour
     */
    public Color getSmallFillColour() {
        return smallFillColour;
    }

    /**
     * Gets the large line colour
     * @return largeLineColour
     */
    public Color getSmallLineColour() {
        return smallLineColour;
    }

    /**
     * Gets the large line width text
     * @return largeLineWidthTextField
     */
    public TextField getSmallLineWidthTextField() {
        return smallLineWidthTextField;
    }

    /**
     * Gets the panel
     * @return recursivePanel
     */
    public Panel getPanel() {
        return this.recursivePanel;
    }
}
