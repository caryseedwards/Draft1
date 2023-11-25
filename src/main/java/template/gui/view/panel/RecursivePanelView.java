package template.gui.view.panel;

import template.gui.view.Utilities;

import java.awt.*;

/**
 * Creates the Recursive Shape algorithm view for the GUI
 * @author carysedwards
 */
public class RecursivePanelView {
    private final Panel recursivePanel;
    private final int canvasWidth;
    private final int canvasHeight;
    private TextField startXTextField;
    private TextField startYTextField;
    private TextField recursiveDepthTextField;
    private TextField initialRadiusTextField;
    private TextField numShapeTextField;
    private Choice largeShapeType;
    private Button largeShapeColourButton;
    private Button largeLineColourButton;
    private TextField largeLineWidthTextField;
    private Choice smallShapeType;
    private Button smallShapeColourButton;
    private Button smallLineColourButton;
    private TextField smallLineWidthTextField;

    /**
     * Creates the recursive shape algorithm panel
     * @param canvasWidth - the starting canvas width
     * @param canvasHeight - the starting canvas height
     */
    public RecursivePanelView(int canvasWidth, int canvasHeight) {
        recursivePanel = new Panel(new GridBagLayout());
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.startXTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
        this.startYTextField = new TextField(String.valueOf(canvasHeight / 2), 5);
        setupPanel();
    }

    /**
     * Initialises the panel and sets default values
     */
    private void setupPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 5);

        int gridy = 0;

        startXTextField = new TextField("250", 5);
        startYTextField = new TextField("250", 5);
        recursiveDepthTextField = new TextField("4", 5);
        initialRadiusTextField = new TextField("100", 5);
        numShapeTextField = new TextField("6", 5);
        largeShapeType = new Choice();
        largeShapeColourButton = new Button("Choose Colour");
        largeLineColourButton = new Button("Choose Colour");
        largeLineWidthTextField = new TextField("1", 5);
        smallShapeType = new Choice();
        smallShapeColourButton = new Button("Choose Colour");
        smallLineColourButton = new Button("Choose Colour");
        smallLineWidthTextField = new TextField("1", 5);

        addLabelAndField(gbc, "Initial 'x' co-ordinate:", startXTextField, gridy++);
        addLabelAndField(gbc, "Initial 'y' co-ordinate:", startYTextField, gridy++);
        addLabelAndField(gbc, "Depth/Iterations:", recursiveDepthTextField, gridy++);
        addLabelAndField(gbc, "Initial radius length:", initialRadiusTextField, gridy++);
        addLabelAndField(gbc, "Number of shapes:", numShapeTextField, gridy++);

        String[] shapeTypes = {"Circle", "Square", "Triangle", "Hexagon"};
        addLabelAndChoice(gbc, "Large Shape Type:", largeShapeType, shapeTypes, gridy++);
        addColorChooserButton(gbc, "Large Shape Fill Color:", largeShapeColourButton, gridy++);
        addColorChooserButton(gbc, "Large Shape Line Color:", largeLineColourButton, gridy++);
        addLabelAndField(gbc, "Large Shape Line Width:", largeLineWidthTextField, gridy++);

        addLabelAndChoice(gbc, "Small Shape Type:", smallShapeType, shapeTypes, gridy++);
        addColorChooserButton(gbc, "Small Shape Fill Color:", smallShapeColourButton, gridy++);
        addColorChooserButton(gbc, "Small Shape Line Color:", smallLineColourButton, gridy++);
        addLabelAndField(gbc, "Small Shape Line Width:", smallLineWidthTextField, gridy);

        Utilities.configureColourPicker(largeShapeColourButton);
        Utilities.configureColourPicker(largeLineColourButton);
        Utilities.configureColourPicker(smallShapeColourButton);
        Utilities.configureColourPicker(smallLineColourButton);
    }

    /**
     * Helper method for creating a label and field
     * @param gbc - the Grid layout constraints
     * @param labelText - the string for the label
     * @param textField - the string for the text
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
     * Helper method for creating a choice dropdown and label
     * @param gbc - the Grid layout constraints
     * @param choice - The choice dropdown to add
     * @param items - the items to go inside the choice dropdown
     * @param gridy - the grid y value (column)
     */
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
        recursivePanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        recursivePanel.add(button, gbc);
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
     * Gets the recursive depth text field
     * @return recursiveDepthTextField
     */
    public TextField getRecursiveDepthTextField() {
        return recursiveDepthTextField;
    }

    /**
     * Gets the initial radius text field
     * @return initialRadiusTextField
     */
    public TextField getInitialRadiusTextField() {
        return initialRadiusTextField;
    }

    /**
     * Gets the number of shapes text field
     * @return numShapeTextField
     */
    public TextField getNumShapeTextField() {
        return numShapeTextField;
    }

    /**
     * Gets the large shape type
     * @return largeShapeType
     */
    public Choice getLargeShapeType() {
        return largeShapeType;
    }

    /**
     * Gets the large shape colour button
     * @return largeShapeColourButton
     */
    public Button getLargeShapeColourButton() {
        return largeShapeColourButton;
    }

    /**
     * Gets the large line colour button
     * @return largeLineColourButton
     */
    public Button getLargeLineColourButton() {
        return largeLineColourButton;
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
     * Gets the small shape colour button
     * @return smallShapeColourButton
     */
    public Button getSmallShapeColourButton() {
        return smallShapeColourButton;
    }

    /**
     * Gets the small line colour button
     * @return smallLineColourButton
     */
    public Button getSmallLineColourButton() {
        return smallLineColourButton;
    }

    /**
     * Gets the small line width text
     * @return smallLineWidthTextField
     */
    public TextField getSmallLineWidthTextField() {
        return smallLineWidthTextField;
    }

    /**
     * Gets the panel
     * @return recursivePanel
     */
    public Panel getPanel() {
        return recursivePanel;
    }
}

