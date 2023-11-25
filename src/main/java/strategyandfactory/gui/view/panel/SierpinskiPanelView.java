package strategyandfactory.gui.view.panel;

import strategyandfactory.gui.view.Utilities;

import java.awt.*;

/**
 * Creates the Sierpinski Shape algorithm view for the GUI
 * @author carysedwards
 */
public class SierpinskiPanelView {
    private final Panel sierpinskiPanel;
    private final int canvasWidth;
    private final int canvasHeight;
    private TextField startXTextField;
    private TextField startYTextField;
    private TextField sizeTextField;
    private TextField depthTextField;
    private Choice shapeTypeChoice;
    private Button fillColourButton;
    private Button lineColourButton;
    private TextField lineWidthTextField;

    /**
     * Creates the sierpinski shape algorithm panel
     * @param canvasWidth - the starting canvas width
     * @param canvasHeight - the starting canvas height
     */
    public SierpinskiPanelView(int canvasWidth, int canvasHeight) {
        this.startXTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
        this.startYTextField = new TextField(String.valueOf(canvasHeight / 2), 5);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        sierpinskiPanel = new Panel(new GridBagLayout());
        setupPanel();
    }

    /**
     * Initialises the panel and sets default values
     */
    private void setupPanel() {
        startXTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
        startYTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
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
        addLabelAndChoice(gbc, shapeTypeChoice, new String[]{"Circle", "Square", "Hexagon", "Triangle"}, gridy++);
        addColorChooserButton(gbc, "Fill Colour:", fillColourButton, gridy++);
        addColorChooserButton(gbc, "Line Colour:", lineColourButton, gridy++);
        addLabelAndField(gbc, "Line Width:", lineWidthTextField, gridy);

        Utilities.configureColourPicker(fillColourButton);
        Utilities.configureColourPicker(lineColourButton);
    }

    /**
     * Helper method for creating a label and field
     * @param gbc - the Grid layout constraints
     * @param labelText - the string for the label
     * @param component - the component for the text
     * @param gridy - the grid y value (column)
     */
    private void addLabelAndField(GridBagConstraints gbc, String labelText, Component component, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        sierpinskiPanel.add(component, gbc);
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
     * Helper method for creating a colour chooser and label
     * @param gbc - the Grid layout constraints
     * @param labelText - the label text
     * @param button - the button to launch the colour chooser
     * @param gridy - the grid y value (column)
     */
    private void addColorChooserButton(GridBagConstraints gbc, String labelText, Button button, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        sierpinskiPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        sierpinskiPanel.add(button, gbc);
    }

    /**
     * Gets the canvas width
     * @return canvasWidth
     */
    public int getCanvasWidth() {
        return canvasWidth;
    }

    /**
     * Gets the canvas Height
     * @return canvasHeight
     */
    public int getCanvasHeight() {
        return canvasHeight;
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
     * Gets the size text field
     * @return sizeTextField
     */
    public TextField getSizeTextField() {
        return sizeTextField;
    }

    /**
     * Gets the depth text field
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
     * Gets the fill colour button
     * @return fillColourButton
     */
    public Button getFillColourButton() {
        return fillColourButton;
    }

    /**
     * Gets the line colour button
     * @return lineColourButton
     */
    public Button getLineColourButton() {
        return lineColourButton;
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

