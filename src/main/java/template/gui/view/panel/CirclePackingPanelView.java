package template.gui.view.panel;

import template.gui.view.utilities;

import java.awt.*;

/**
 * Creates the Circle Packing algorithm view for the GUI
 * @author carysedwards
 */
public class CirclePackingPanelView {
    private final Panel circlePackingPanel;
    private final int canvasWidth;
    private final int canvasHeight;
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

    /**
     * Creates the circle packing algorithm panel
     * @param canvasWidth - the starting canvas width
     * @param canvasHeight - the starting canvas height
     */
    public CirclePackingPanelView(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.startXTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
        this.startYTextField = new TextField(String.valueOf(canvasHeight / 2), 5);
        circlePackingPanel = new Panel(new GridBagLayout());
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
        startXTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
        startYTextField = new TextField(String.valueOf(canvasHeight / 2), 5);
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
        addLabelAndChoice(gbc, boundaryShapeType, new String[]{"Circle", "Square", "Triangle", "Hexagon"}, gridy++);
        addColourChooserButton(gbc, "Boundary Fill Colour:", boundaryFillColourButton, gridy++);
        addColourChooserButton(gbc, "Boundary Line Colour:", boundaryLineColourButton, gridy++);
        addLabelAndField(gbc, "Boundary Line Width:", boundaryLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Boundary Radius:", boundaryRadiusTextField, gridy++);

        gbc.gridy = gridy++;
        circlePackingPanel.add(new Label(" "), gbc);

        gbc.insets = new Insets(10, 5, 0, 5);
        addSectionLabel(gbc, "Circle Packing Shape Inputs:", gridy++);
        addColourChooserButton(gbc, "Packing Fill Colour:", packingFillColourButton, gridy++);
        addColourChooserButton(gbc, "Packing Line Colour:", packingLineColourButton, gridy++);
        addLabelAndField(gbc, "Packing Line Width:", packingLineWidthTextField, gridy++);
        addLabelAndField(gbc, "Minimum Circle Radius:", minRadiusCircleTextField, gridy++);
        addLabelAndField(gbc, "Maximum Circle Radius:", maxRadiusCircleTextField, gridy++);
        gbc.weighty = 1;

        utilities.configureColourPicker(boundaryFillColourButton);
        utilities.configureColourPicker(boundaryLineColourButton);
        utilities.configureColourPicker(packingFillColourButton);
        utilities.configureColourPicker(packingLineColourButton);
    }

    /**
     * Helper method for creating a label and field
     * @param gbc - the Grid layout constraints
     * @param labelText - the string for the label
     * @param component - the panel component to add
     * @param gridy - the grid y value (column)
     */
    private void addLabelAndField(GridBagConstraints gbc, String labelText, Component component, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        circlePackingPanel.add(component, gbc);
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
        circlePackingPanel.add(new Label("Boundary Shape Type:"), gbc);

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
     * @param button - the button to launch the colour chooser
     * @param gridy - the grid y value (column)
     */
    private void addColourChooserButton(GridBagConstraints gbc, String labelText, Button button, int gridy) {
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        circlePackingPanel.add(new Label(labelText), gbc);

        gbc.gridx = 1;
        circlePackingPanel.add(button, gbc);
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
    public Button getBoundaryFillColourButton() {
        return boundaryFillColourButton;
    }

    /**
     * Gets the boundary line colour
     * @return boundaryLineColourButton
     */
    public Button getBoundaryLineColourButton() {
        return boundaryLineColourButton;
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
     * gets the packing fill colour button
     * @return packingFillColourButton
     */
    public Button getPackingFillColourButton() {
        return packingFillColourButton;
    }

    /**
     * Gets the packing line colour button
     * @return packingLineColourButton
     */
    public Button getPackingLineColourButton() {
        return packingLineColourButton;
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
