package gui;

import parameters.SierpinskiShapeParameters;
import patterns.CirclePacking;
import patterns.RecursiveShape;

import java.awt.*;
import java.awt.event.*;
import parameters.CirclePackingParameters;
import parameters.RecursiveShapeParameters;
import patterns.SierpinskiShape;

public class SimpleGUI {
    public static RecursiveShape recursiveShape = null;
    public static CirclePacking circlePacking = null;
    public static SierpinskiShape sierpinskiShape = null;

    public static void main(String[] args) {
        Frame frame = new Frame("Generative Art API");
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 800);

        // Left Panel
        Panel leftPanel = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 4, 4); // Consistent padding
        gbc.gridx = 0;
        gbc.gridy = 0;

        Label algorithmLabel = new Label("Please select an algorithm:");
        leftPanel.add(algorithmLabel, gbc);

        gbc.gridx++; // Move the x position over for the dropdown
        Choice algorithmDropdown = new Choice();
        algorithmDropdown.add("");
        algorithmDropdown.add("Circle Packing");
        algorithmDropdown.add("Recursive Shape");
        algorithmDropdown.add("Sierpinski Shape");
        leftPanel.add(algorithmDropdown, gbc);

        gbc.gridx = 0;

        gbc.gridy++;
        // Recursive Panel Layout
        RecursivePanel recursiveParameterPanel = new RecursivePanel(frame.getWidth(), frame.getHeight());
        Panel recursivePanel = recursiveParameterPanel.getRecursivePanel();
        recursivePanel.setVisible(false); // initially hidden
        leftPanel.add(recursivePanel, gbc);

        CirclePackingPanel circlePackingParameterPanel = new CirclePackingPanel(frame.getWidth(), frame.getHeight());
        Panel circlePackingPanel = circlePackingParameterPanel.getCirclePackingPanel();
        circlePackingPanel.setVisible(false); // initially hidden
        leftPanel.add(circlePackingPanel, gbc);

        SierpinskiPanel sierpinskiParameterPanel = new SierpinskiPanel(frame.getWidth(), frame.getHeight());
        Panel sierpinskiPanel = sierpinskiParameterPanel.getSierpinskiPanel();
        sierpinskiPanel.setVisible(false); // initially hidden
        leftPanel.add(sierpinskiPanel, gbc);

        // Update the visibility based on dropdown selection
        algorithmDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                recursivePanel.setVisible(algorithmDropdown.getSelectedItem().equals("Recursive Shape"));
                circlePackingPanel.setVisible(algorithmDropdown.getSelectedItem().equals("Circle Packing"));
                sierpinskiPanel.setVisible(algorithmDropdown.getSelectedItem().equals("Sierpinski Shape"));
                frame.validate(); // Adjust the frame layout after changes
            }
        });

        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // This makes the component take up the rest of the row
        gbc.anchor = GridBagConstraints.CENTER; // This will center the button
        gbc.insets = new Insets(20, 0, 20, 0); // Top and bottom padding

        Button generateBtn = new Button("Generate Artwork");
        leftPanel.add(generateBtn, gbc);

        // Reset gbc settings if adding more components after this
        gbc.gridwidth = 1; // Reset gridwidth
        gbc.anchor = GridBagConstraints.NORTHWEST; // Reset anchor
        gbc.insets = new Insets(0, 0, 0, 0); // Reset insets

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
                circlePackingPanel.setVisible("Circle Packing".equals(selected));
                sierpinskiPanel.setVisible("Sierpinski Shape".equals(selected));

                frame.invalidate();
                frame.validate();
            }
        });

        generateBtn.addActionListener(e -> {
            String selected = algorithmDropdown.getSelectedItem();
            if ("Recursive Shape".equals(selected)) {
                RecursiveShapeParameters params = new RecursiveShapeParameters();
                params.setCenterX(Integer.parseInt(recursiveParameterPanel.getStartXTextField().getText()));
                params.setCenterY(Integer.parseInt(recursiveParameterPanel.getStartYTextField().getText()));
                params.setDepth(Integer.parseInt(recursiveParameterPanel.getRecursiveDepthTextField().getText()));
                params.setInitialRadius(Integer.parseInt(recursiveParameterPanel.getInitialRadiusTextField().getText()));
                params.setNumShapes(Integer.parseInt(recursiveParameterPanel.getNumShapeTextField().getText()));
                params.setLargeShapeType(recursiveParameterPanel.getLargeShapeType().getSelectedItem().toLowerCase());
                params.setLargeShapeFillColor(recursiveParameterPanel.getLargeFillColour());
                params.setLargeShapeLineColor(recursiveParameterPanel.getLargeLineColour());
                params.setLargeShapeLineWidth(Float.parseFloat(recursiveParameterPanel.getLargeLineWidthTextField().getText()));
                params.setSmallShapeType(recursiveParameterPanel.getSmallShapeType().getSelectedItem().toLowerCase());
                params.setSmallShapeFillColor(recursiveParameterPanel.getSmallFillColour());
                params.setSmallShapeFillColor(recursiveParameterPanel.getSmallLineColour());
                params.setSmallShapeLineWidth(Float.parseFloat(recursiveParameterPanel.getSmallLineWidthTextField().getText()));

                recursiveShape = new RecursiveShape(params);

                Graphics g = canvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                recursiveShape.paintComponent(g2d);
            }

            else if ("Circle Packing".equals(selected)) {
                CirclePackingParameters params = new CirclePackingParameters();
                params.setCentreX(Integer.parseInt(circlePackingParameterPanel.getStartXTextField().getText()));
                params.setCentreY(Integer.parseInt(circlePackingParameterPanel.getStartYTextField().getText()));
                params.setMaxAttempts(Integer.parseInt(circlePackingParameterPanel.getMaxAttemptsTextField().getText()));
                params.setBoundaryType(circlePackingParameterPanel.getBoundaryShapeType().getSelectedItem().toLowerCase());
                params.setPolygonSize(Integer.parseInt(circlePackingParameterPanel.getBoundaryRadiusTextField().getText()));

                params.setBoundaryFillColour(circlePackingParameterPanel.getBoundaryFillColor());
                params.setBoundaryLineColour(circlePackingParameterPanel.getBoundaryLineColor());

                params.setBoundaryLineWidth(Float.parseFloat(circlePackingParameterPanel.getBoundaryLineWidthTextField().getText()));

                params.setCircleFillColour(circlePackingParameterPanel.getPackingFillColor());
                params.setCircleLineColour(circlePackingParameterPanel.getPackingLineColor());

                params.setCircleLineWidth(Float.parseFloat(circlePackingParameterPanel.getPackingLineWidthTextField().getText()));
                params.setMaxRadius(Integer.parseInt(circlePackingParameterPanel.getMaxRadiusCircleTextField().getText()));
                params.setMinRadius(Integer.parseInt(circlePackingParameterPanel.getMinRadiusCircleTextField().getText()));

                circlePacking = new CirclePacking(params);
                Graphics g = canvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                circlePacking.paintComponent(g2d);
            }


            else if ("Sierpinski Shape".equals(selected)) {
                SierpinskiShapeParameters params = new SierpinskiShapeParameters();
                params.setCentreX(Integer.parseInt(sierpinskiParameterPanel.getStartXTextField().getText()));
                params.setCentreY(Integer.parseInt(sierpinskiParameterPanel.getStartYTextField().getText()));
                params.setDepth(Integer.parseInt(sierpinskiParameterPanel.getDepthTextField().getText()));
                params.setShapeType(sierpinskiParameterPanel.getShapeTypeChoice().getSelectedItem().toLowerCase());
                params.setPolygonSize(Integer.parseInt(sierpinskiParameterPanel.getSizeTextField().getText()));
                params.setShapeFillColour(sierpinskiParameterPanel.getFillColour());
                params.setShapeLineColour(sierpinskiParameterPanel.getLineColour());
                params.setShapeLineWidth(Float.parseFloat(sierpinskiParameterPanel.getLineWidthTextField().getText()));

                sierpinskiShape = new SierpinskiShape(params);
                Graphics g = canvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                sierpinskiShape.paintComponent(g2d);
            }

            else
            {
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

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
