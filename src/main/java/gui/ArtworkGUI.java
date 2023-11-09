package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import parameters.*;
import patterns.*;
import validation.Validate;

public class ArtworkGUI {

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final int CANVAS_WIDTH = 1280;
    private static final int CANVAS_HEIGHT = 720;
    private static final RecursivePanel rp = new RecursivePanel(CANVAS_WIDTH, CANVAS_HEIGHT);
    private static final CirclePackingPanel cpp = new CirclePackingPanel(CANVAS_WIDTH, CANVAS_HEIGHT);
    private static final SierpinskiPanel sp = new SierpinskiPanel(CANVAS_WIDTH, CANVAS_HEIGHT);
    private static final JLabel errorLabel = new JLabel("");

    private static RecursiveShape recursiveShape;
    private static CirclePacking circlePacking;
    private static SierpinskiShape sierpinskiShape;
    private static Timer animationTimer;
    private static Frame frame;
    private static JPanel canvas;
    private static Choice algorithmDropdown;
    private static Panel recursivePanel, circlePackingPanel, sierpinskiPanel;

    private static void setupFrame() {
        frame = new Frame("Generative Art API");
        frame.setLayout(new BorderLayout());
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private static void setupLeftPanel() {
        Panel leftPanel = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridx = gbc.gridy = 0;

        leftPanel.add(new Label("Please select an algorithm:"), gbc);

        gbc.gridx++;
        setupAlgorithmDropdown();
        leftPanel.add(algorithmDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        setupAlgorithmPanels(gbc, leftPanel);

        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0); // top padding for button

        Button generateBtn = new Button("Generate Artwork");
        generateBtn.addActionListener(e -> generateArtwork());
        leftPanel.add(generateBtn, gbc);

        // Setup error label
        gbc.gridy++; // Move to the next grid row
        gbc.insets = new Insets(10, 0, 0, 0); // top padding for error label
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        errorLabel.setForeground(Color.RED); // Set the text color to red for visibility
        leftPanel.add(errorLabel, gbc);

        frame.add(leftPanel, BorderLayout.WEST);
    }

    private static void setupAlgorithmDropdown() {
        algorithmDropdown = new Choice();
        algorithmDropdown.add("-");
        algorithmDropdown.add("Circle Packing");
        algorithmDropdown.add("Recursive Shape");
        algorithmDropdown.add("Sierpinski Shape");
        algorithmDropdown.addItemListener(e -> updateAlgorithmPanelVisibility());
    }

    private static void setupAlgorithmPanels(GridBagConstraints gbc, Panel leftPanel) {
        recursivePanel = rp.getPanel();
        circlePackingPanel = cpp.getPanel();
        sierpinskiPanel = sp.getPanel();

        recursivePanel.setVisible(false);
        circlePackingPanel.setVisible(false);
        sierpinskiPanel.setVisible(false);

        leftPanel.add(recursivePanel, gbc);
        leftPanel.add(circlePackingPanel, gbc);
        leftPanel.add(sierpinskiPanel, gbc);
    }

    private static void setupCanvas() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                if (circlePacking != null) {
                    circlePacking.paintComponent(g);
                }
            }
        };
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        canvas.setBackground(Color.WHITE);

        Panel centerPanel = new Panel(new BorderLayout());
        centerPanel.add(canvas, BorderLayout.CENTER);

        centerPanel.add(new Panel() {{
            setPreferredSize(new Dimension(0, 30));
        }}, BorderLayout.NORTH);

        centerPanel.add(new Panel() {{
            setPreferredSize(new Dimension(30, 0));
        }}, BorderLayout.EAST);

        frame.add(centerPanel, BorderLayout.CENTER);
    }

    private static void setupBottomPanel() {
        int bottomPanelHeight = 50;
        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, bottomPanelHeight));

        Button saveBtn = new Button("Save Image");
        saveBtn.addActionListener(e -> saveImage());
        Button resetBtn = new Button("Reset");
        resetBtn.addActionListener(e -> resetCanvas());

        bottomPanel.add(saveBtn);
        bottomPanel.add(resetBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    private static void updateAlgorithmPanelVisibility() {
        String selected = algorithmDropdown.getSelectedItem();
        int newCanvasWidth = canvas.getWidth();
        int newCanvasHeight = canvas.getHeight();

        resetCanvas();
        recalcCanvasCenter(newCanvasWidth, newCanvasHeight);
        recursivePanel.setVisible("Recursive Shape".equals(selected));
        circlePackingPanel.setVisible("Circle Packing".equals(selected));
        sierpinskiPanel.setVisible("Sierpinski Shape".equals(selected));

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    private static void recalcCanvasCenter(int width, int height) {
        rp.getStartXTextField().setText(String.valueOf(width / 2));
        rp.getStartYTextField().setText(String.valueOf(height / 2));
        cpp.getStartXTextField().setText(String.valueOf(width / 2));
        cpp.getStartYTextField().setText(String.valueOf(height / 2));
        sp.getStartXTextField().setText(String.valueOf(width / 2));
        sp.getStartYTextField().setText(String.valueOf(height / 2));
    }

    private static void setErrorLabel(String message) {
        if (message == null || message.isEmpty()) {
            errorLabel.setText("");
            errorLabel.setVisible(false);
        } else {
            errorLabel.setText(message);
            errorLabel.setVisible(true);
        }
    }

    private static void generateArtwork() {
        String selected = algorithmDropdown.getSelectedItem();
        Graphics2D g2d = (Graphics2D) canvas.getGraphics();
        String validationError;

        switch (selected) {
            case "Recursive Shape":
                validationError = Validate.validateRecursiveParams(rp);
                if (validationError.isEmpty()) {
                    recursiveShape = new RecursiveShape(getRecursiveShapeParameters());
                    recursiveShape.paintComponent(g2d);
                } else {
                    setErrorLabel(validationError);
                }
                break;
            case "Circle Packing":
                validationError = Validate.validateCirclePackingParams(cpp);
                if (validationError.isEmpty()) {
                    circlePacking = new CirclePacking(getCirclePackingParameters());
                    if (animationTimer != null) {
                        animationTimer.stop();
                    }
                    animationTimer = new Timer(100, e -> {
                        if (circlePacking != null) {
                            circlePacking.addCircle();
                            canvas.repaint();
                        }
                    });
                    animationTimer.start();
                } else {
                    setErrorLabel(validationError);
                }
                break;
            case "Sierpinski Shape":
                validationError = Validate.validateSierpinskiParams(sp);
                if (validationError.isEmpty()) {
                    SierpinskiShapeParameters sierpinskiParams = getSierpinskiShapeParameters();
                    sierpinskiShape = new SierpinskiShape(sierpinskiParams);
                    sierpinskiShape.paintComponent(g2d);
                } else {
                    setErrorLabel(validationError);
                }
                break;
        }
    }

    private static RecursiveShapeParameters getRecursiveShapeParameters() {
        RecursiveShapeParameters params = new RecursiveShapeParameters();
        params.setCenterX(Integer.parseInt(rp.getStartXTextField().getText()));
        params.setCenterY(Integer.parseInt(rp.getStartYTextField().getText()));
        params.setDepth(Integer.parseInt(rp.getRecursiveDepthTextField().getText()));
        params.setInitialRadius(Integer.parseInt(rp.getInitialRadiusTextField().getText()));
        params.setNumShapes(Integer.parseInt(rp.getNumShapeTextField().getText()));
        params.setLargeShapeType(rp.getLargeShapeType().getSelectedItem().toLowerCase());
        params.setLargeShapeFillColor(rp.getLargeFillColour());
        params.setLargeShapeLineColor(rp.getLargeLineColour());
        params.setLargeShapeLineWidth(Integer.parseInt(rp.getLargeLineWidthTextField().getText()));
        params.setSmallShapeType(rp.getSmallShapeType().getSelectedItem().toLowerCase());
        params.setSmallShapeFillColor(rp.getSmallFillColour());
        params.setSmallShapeLineColor(rp.getSmallLineColour());
        params.setSmallShapeLineWidth(Integer.parseInt(rp.getSmallLineWidthTextField().getText()));
        return params;
    }

    private static CirclePackingParameters getCirclePackingParameters() {
        CirclePackingParameters params = new CirclePackingParameters();
        params.setCentreX(Integer.parseInt(cpp.getStartXTextField().getText()));
        params.setCentreY(Integer.parseInt(cpp.getStartYTextField().getText()));
        params.setMaxAttempts(Integer.parseInt(cpp.getMaxAttemptsTextField().getText()));
        params.setBoundaryType(cpp.getBoundaryShapeType().getSelectedItem().toLowerCase());
        params.setPolygonSize(Integer.parseInt(cpp.getBoundaryRadiusTextField().getText()));
        params.setBoundaryFillColour(cpp.getBoundaryFillColor());
        params.setBoundaryLineColour(cpp.getBoundaryLineColor());
        params.setBoundaryLineWidth(Integer.parseInt(cpp.getBoundaryLineWidthTextField().getText()));
        params.setCircleFillColour(cpp.getPackingFillColor());
        params.setCircleLineColour(cpp.getPackingLineColor());
        params.setCircleLineWidth(Integer.parseInt(cpp.getPackingLineWidthTextField().getText()));
        params.setMaxRadius(Integer.parseInt(cpp.getMaxRadiusCircleTextField().getText()));
        params.setMinRadius(Integer.parseInt(cpp.getMinRadiusCircleTextField().getText()));
        return params;
    }

    private static SierpinskiShapeParameters getSierpinskiShapeParameters() {
        SierpinskiShapeParameters params = new SierpinskiShapeParameters();
        params.setCentreX(Integer.parseInt(sp.getStartXTextField().getText()));
        params.setCentreY(Integer.parseInt(sp.getStartYTextField().getText()));
        params.setDepth(Integer.parseInt(sp.getDepthTextField().getText()));
        params.setShapeType(sp.getShapeTypeChoice().getSelectedItem().toLowerCase());
        params.setPolygonSize(Integer.parseInt(sp.getSizeTextField().getText()));
        params.setShapeFillColour(sp.getFillColour());
        params.setShapeLineColour(sp.getLineColour());
        params.setShapeLineWidth(Integer.parseInt(sp.getLineWidthTextField().getText()));
        return params;
    }

    private static void saveImage() {
        Dimension size = canvas.getSize();
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(canvas.getBackground());
        g2d.fillRect(0, 0, size.width, size.height);
        if (recursiveShape != null) {
            recursiveShape.paintComponent(g2d);
        } else if (circlePacking != null) {
            circlePacking.paintComponent(g2d);
        } else if (sierpinskiShape != null) {
            sierpinskiShape.paintComponent(g2d);
        }
        g2d.dispose();

        FileDialog fd = new FileDialog(frame, "Save Image", FileDialog.SAVE);
        fd.setVisible(true);
        String filename = fd.getFile();
        if (filename != null) {
            try {
                if (!filename.contains(".")) filename += ".png";
                File file = new File(fd.getDirectory() + filename);
                ImageIO.write(image, "PNG", file);
                JOptionPane.showMessageDialog(frame, "Image saved!", "Image Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error saving image: " + ex.getMessage(), "Image Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void resetCanvas() {
        Graphics g = canvas.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setColor(Color.black);
        g.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1);
        recursiveShape = null;
        circlePacking = null;
        sierpinskiShape = null;
    }

    public static void main(String[] args) {
        setupFrame();
        setupLeftPanel();
        setupCanvas();
        setupBottomPanel();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
