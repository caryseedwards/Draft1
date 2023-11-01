package gui;

import patterns.RecursiveShape;

import java.awt.*;
import java.awt.event.*;
import patterns.RecursiveShape;
import parameters.RecursiveShapeParameters;

public class SimpleGUI {
    public static RecursiveShape recursiveShape = null;

    public static Panel createColorPickerPanel(String title, TextField[] rgbaFields, int[] defaultValues) {
        Panel colorPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label titleLabel = new Label(title);
        colorPanel.add(titleLabel);

        String[] rgba = {"R", "G", "B", "A"};
        for (int i = 0; i < rgba.length; i++) {
            Label tempLabel = new Label(rgba[i] + ":");
            rgbaFields[i] = new TextField(3);
            rgbaFields[i].setText(Integer.toString(defaultValues[i]));  // Initialize with default value
            colorPanel.add(tempLabel);
            colorPanel.add(rgbaFields[i]);
        }
        return colorPanel;
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Generative Art API");
        frame.setLayout(new BorderLayout());

        // Left Panel
        Panel leftPanel = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
      //  gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        Label algorithmLabel = new Label("Please select an algorithm:");
        leftPanel.add(algorithmLabel, gbc);

        Choice algorithmDropdown = new Choice();
        algorithmDropdown.add("Circle Packing");
        algorithmDropdown.add("Recursive Shape");
        algorithmDropdown.add("Sierpinski Shape");
        gbc.gridx = 1;
        leftPanel.add(algorithmDropdown, gbc);
        gbc.gridx = 0;
        // Recursive Panel Layout
        gbc.gridy++;
        Panel recursivePanel = new Panel(new GridBagLayout());
        leftPanel.add(recursivePanel, gbc);


    // Algorithm Parameters
        GridBagConstraints recursiveGbc = new GridBagConstraints();
        recursiveGbc.gridx = 0;
        recursiveGbc.gridy = 0;
        recursiveGbc.anchor = GridBagConstraints.NORTHWEST;

        Label startXLabel = new Label("Initial 'x' co-ordinate:");
        recursivePanel.add(startXLabel, recursiveGbc);
        TextField startXTextField = new TextField(5); // 5 is the column width of the TextField
        startXTextField.setText("500");
        recursiveGbc.gridx = 1; // place text field in the second column
        recursivePanel.add(startXTextField, recursiveGbc);
        recursiveGbc.gridy++;

        Label startYLabel = new Label("Initial 'y' co-ordinate:");
        recursiveGbc.gridx = 0; // place label in the first column
        recursivePanel.add(startYLabel, recursiveGbc);
        TextField startYTextField = new TextField(5); // 5 is the column width of the TextField
        startYTextField.setText("500");
        recursiveGbc.gridx = 1; // place text field in the second column
        recursivePanel.add(startYTextField, recursiveGbc);

        recursiveGbc.gridy++;
        Label recursiveDepthLabel = new Label("Depth/Iterations:");
        recursiveGbc.gridx = 0; // place label in the first column
        recursivePanel.add(recursiveDepthLabel, recursiveGbc);
        TextField recursiveDepthTextField = new TextField(5); // 5 is the column width of the TextField
        recursiveDepthTextField.setText("3");
        recursiveGbc.gridx = 1; // place text field in the second column
        recursivePanel.add(recursiveDepthTextField, recursiveGbc);

        recursiveGbc.gridy++;
        Label initialRadiusSizeLabel = new Label("Initial radius length:");
        recursiveGbc.gridx = 0;
        recursivePanel.add(initialRadiusSizeLabel, recursiveGbc);
        recursiveGbc.gridx = 1;
        TextField initialRadiusTextField = new TextField(5);
        initialRadiusTextField.setText("250");
        recursivePanel.add(initialRadiusTextField, recursiveGbc);

        recursiveGbc.gridy++;
        Label numShapesLabel = new Label("Number of shapes:");
        recursiveGbc.gridx = 0;
        recursivePanel.add(numShapesLabel, recursiveGbc);
        recursiveGbc.gridx = 1;
        TextField numShapeTextField = new TextField(5);
        numShapeTextField.setText("6");
        recursivePanel.add(numShapeTextField, recursiveGbc);

        recursiveGbc.gridy++;
        Label emptyLabel = new Label(" ");
        recursivePanel.add(emptyLabel, recursiveGbc);
        recursiveGbc.gridy++;
        recursivePanel.add(emptyLabel, recursiveGbc);



    // Shape Parameters:

        // Large Shape
        recursiveGbc.gridy++;
        Label largeShapeInputsLabel = new Label("Large Shape Inputs:");
        recursiveGbc.gridx = 0;
        recursivePanel.add(largeShapeInputsLabel, recursiveGbc);
        recursiveGbc.gridy++;
        Label largeShapeLabel = new Label("Shape Type:");
        recursivePanel.add(largeShapeLabel, recursiveGbc);
        recursiveGbc.gridx = 1;
        Choice largeShapeType = new Choice();
        largeShapeType.add("Circle");
        largeShapeType.add("Square");
        largeShapeType.add("Triangle");
        largeShapeType.add("Hexagon");
        recursivePanel.add(largeShapeType, recursiveGbc);


        // Large Shape Additional Choices
        recursiveGbc.gridy++;
        recursiveGbc.gridx = 0;
        recursiveGbc.gridwidth = 8; // span across multiple columns if needed

        int[] defaultColourValues = {0, 0, 0, 255};
        TextField[] largeFillColourFields = new TextField[4];
        Panel largeFillColour = createColorPickerPanel("Fill Colour:", largeFillColourFields, defaultColourValues);
        recursivePanel.add(largeFillColour, recursiveGbc);

        recursiveGbc.gridy++;

        TextField[] largeLineColourFields = new TextField[4];
        Panel largeLineColour = createColorPickerPanel("Line Colour:", largeLineColourFields, defaultColourValues);
        recursivePanel.add(largeLineColour, recursiveGbc);


        recursiveGbc.gridy++;
        Label largeLineWidthLabel = new Label ("Line Width:");
        recursiveGbc.gridx = 0;
        recursivePanel.add(largeLineWidthLabel, recursiveGbc);
        recursiveGbc.gridx = 1;
        TextField largeLineWidthTextField = new TextField(5);
        largeLineWidthTextField.setText("1.0");
        recursivePanel.add(largeLineWidthTextField, recursiveGbc);
        recursiveGbc.gridy++;

        recursiveGbc.gridy++;
        recursivePanel.add(emptyLabel, recursiveGbc);

        // Small Shape
        recursiveGbc.gridx = 0;
        recursiveGbc.gridy++;
        Label smallShapeInputLabel = new Label("Small Shape Inputs:");
        recursivePanel.add(smallShapeInputLabel, recursiveGbc);
        recursiveGbc.gridy++;
        Label smallShapeLabel = new Label("Shape Type:");
        recursivePanel.add(smallShapeLabel, recursiveGbc);

        Choice smallShapeType = new Choice();
        smallShapeType.add("Circle");
        smallShapeType.add("Square");
        smallShapeType.add("Triangle");
        smallShapeType.add("Hexagon");
        recursiveGbc.gridx = 1;
        recursivePanel.add(smallShapeType, recursiveGbc);


        recursiveGbc.gridy++;
        recursiveGbc.gridx = 0;
        recursiveGbc.gridwidth = 8; // span across multiple columns if needed


        TextField[] smallFillColourFields = new TextField[4];
        Panel smallFillColour = createColorPickerPanel("Fill Colour:", smallFillColourFields, defaultColourValues);
        recursivePanel.add(smallFillColour, recursiveGbc);

        recursiveGbc.gridy++;

        TextField[] smallLineColourFields = new TextField[4];
        Panel smallLineColour = createColorPickerPanel("Line Colour:", smallLineColourFields, defaultColourValues);
        recursivePanel.add(smallLineColour, recursiveGbc);


        recursiveGbc.gridy++;
        Label smallLineWidthLabel = new Label ("Line Width:");
        recursiveGbc.gridx = 0;
        recursivePanel.add(smallLineWidthLabel, recursiveGbc);
        recursiveGbc.gridx = 1;
        TextField smallLineWidthTextField = new TextField(5);
        smallLineWidthTextField.setText("1.0");
        recursivePanel.add(smallLineWidthTextField, recursiveGbc);
        recursivePanel.setVisible(false);

        gbc.gridy++;
        Panel circlePanel = new Panel();
        TextField circleTextField = new TextField("Circle Packing Param");
        circlePanel.add(circleTextField);
        leftPanel.add(circlePanel, gbc);
        circlePanel.setVisible(false);

        gbc.gridy++;
        Panel sierpinskiPanel = new Panel();
        Checkbox sierpinskiCheckbox = new Checkbox("Enable Sierpinski Options");
        sierpinskiPanel.add(sierpinskiCheckbox);
        leftPanel.add(sierpinskiPanel, gbc);
        sierpinskiPanel.setVisible(false);

        gbc.gridy++;
        Button generateBtn = new Button("Generate Artwork");
        leftPanel.add(generateBtn, gbc);

        frame.add(leftPanel, BorderLayout.WEST);

        // Canvas
        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                g.setColor(Color.black);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        };
        canvas.setBackground(Color.white);

        // Main Center Panel with Padding
        Panel centerPanel = new Panel(new BorderLayout());
        centerPanel.add(canvas, BorderLayout.CENTER);

        Panel topPadding = new Panel();
        topPadding.setPreferredSize(new Dimension(0, 30));
        centerPanel.add(topPadding, BorderLayout.NORTH);

        Panel rightPadding = new Panel();
        rightPadding.setPreferredSize(new Dimension(30, 0));
        centerPanel.add(rightPadding, BorderLayout.EAST);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom Buttons Centered to Canvas
        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button refreshBtn = new Button("Refresh");
        Button resetBtn = new Button("Reset");
        bottomPanel.add(refreshBtn);
        bottomPanel.add(resetBtn);

        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Event Listener for Algorithm Dropdown
        algorithmDropdown.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selected = algorithmDropdown.getSelectedItem();
                recursivePanel.setVisible("Recursive Shape".equals(selected));
                circlePanel.setVisible("Circle Packing".equals(selected));
                sierpinskiPanel.setVisible("Sierpinski Shape".equals(selected));

                frame.invalidate();
                frame.validate();
            }
        });

        generateBtn.addActionListener(e -> {
            String selected = algorithmDropdown.getSelectedItem();
            if ("Recursive Shape".equals(selected)) {
                RecursiveShapeParameters params = new RecursiveShapeParameters();
                params.setCenterX(Integer.parseInt(startXTextField.getText()));
                params.setCenterY(Integer.parseInt(startYTextField.getText()));
                params.setDepth(Integer.parseInt(recursiveDepthTextField.getText()));
                params.setInitialRadius(Integer.parseInt(initialRadiusTextField.getText()));
                params.setNumShapes(Integer.parseInt(numShapeTextField.getText()));
                params.setLargeShapeType(largeShapeType.getSelectedItem().toLowerCase());
                params.setLargeShapeFillColor(new Color(Integer.parseInt(largeFillColourFields[0].getText()), Integer.parseInt(largeFillColourFields[1].getText()), Integer.parseInt(largeFillColourFields[2].getText()), Integer.parseInt(largeFillColourFields[3].getText())));
                params.setLargeShapeLineColor(new Color(Integer.parseInt(largeLineColourFields[0].getText()), Integer.parseInt(largeLineColourFields[1].getText()),Integer.parseInt(largeLineColourFields[2].getText()),Integer.parseInt(largeLineColourFields[3].getText())));
                params.setLargeShapeLineWidth(Float.parseFloat(largeLineWidthTextField.getText()));
                params.setSmallShapeType(smallShapeType.getSelectedItem().toLowerCase());
                params.setSmallShapeFillColor(new Color(Integer.parseInt(smallFillColourFields[0].getText()), Integer.parseInt(smallFillColourFields[1].getText()), Integer.parseInt(smallFillColourFields[2].getText()), Integer.parseInt(smallFillColourFields[3].getText())));
                params.setSmallShapeLineColor(new Color(Integer.parseInt(smallLineColourFields[0].getText()), Integer.parseInt(smallLineColourFields[1].getText()), Integer.parseInt(smallLineColourFields[2].getText()), Integer.parseInt(smallLineColourFields[3].getText()) ));
                params.setSmallShapeLineWidth(Float.parseFloat(smallLineWidthTextField.getText()));

                recursiveShape = new RecursiveShape(params);

                Graphics g = canvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                recursiveShape.paintComponent(g2d);
            } else {
                // Handle other algorithms here
                Graphics g = canvas.getGraphics();
                g.setColor(Color.red);
                g.fillRect(50, 50, 80, 80);
            }
        });


        // Event handlers for Generate Artwork button

        refreshBtn.addActionListener(e -> canvas.repaint());

        resetBtn.addActionListener(e -> {
            Graphics g = canvas.getGraphics();
            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas.repaint();
        });

        frame.setSize(800, 600);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
