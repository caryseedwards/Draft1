package withoutgof.gui.view.panel;

import withoutgof.gui.view.utilities;

import java.awt.*;

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

    public RecursivePanelView(int canvasWidth, int canvasHeight) {
        recursivePanel = new Panel(new GridBagLayout());
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.startXTextField = new TextField(String.valueOf(canvasWidth / 2), 5);
        this.startYTextField = new TextField(String.valueOf(canvasHeight / 2), 5);
        setupPanel();
    }

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

        String[] shapeTypes = {"Triangle", "Square", "Circle", "Hexagon"};
        addLabelAndChoice(gbc, "Large Shape Type:", largeShapeType, shapeTypes, gridy++);
        addColorChooserButton(gbc, "Large Shape Fill Color:", largeShapeColourButton, gridy++);
        addColorChooserButton(gbc, "Large Shape Line Color:", largeLineColourButton, gridy++);
        addLabelAndField(gbc, "Large Shape Line Width:", largeLineWidthTextField, gridy++);

        addLabelAndChoice(gbc, "Small Shape Type:", smallShapeType, shapeTypes, gridy++);
        addColorChooserButton(gbc, "Small Shape Fill Color:", smallShapeColourButton, gridy++);
        addColorChooserButton(gbc, "Small Shape Line Color:", smallLineColourButton, gridy++);
        addLabelAndField(gbc, "Small Shape Line Width:", smallLineWidthTextField, gridy);

        // Configure color pickers
        utilities.configureColourPicker(largeShapeColourButton);
        utilities.configureColourPicker(largeLineColourButton);
        utilities.configureColourPicker(smallShapeColourButton);
        utilities.configureColourPicker(smallLineColourButton);
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

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

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

    public Button getLargeShapeColourButton() {
        return largeShapeColourButton;
    }

    public Button getLargeLineColourButton() {
        return largeLineColourButton;
    }

    public TextField getLargeLineWidthTextField() {
        return largeLineWidthTextField;
    }

    public Choice getSmallShapeType() {
        return smallShapeType;
    }

    public Button getSmallShapeColourButton() {
        return smallShapeColourButton;
    }

    public Button getSmallLineColourButton() {
        return smallLineColourButton;
    }

    public TextField getSmallLineWidthTextField() {
        return smallLineWidthTextField;
    }

    public Panel getPanel() {
        return recursivePanel;
    }
}

