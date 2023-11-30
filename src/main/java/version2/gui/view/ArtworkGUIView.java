package version2.gui.view;

import version2.gui.view.panel.CirclePackingPanelView;
import version2.gui.view.panel.RecursivePanelView;
import version2.gui.view.panel.SierpinskiPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * The main GUI View class for the application
 * @author carysedwards
 */
public class ArtworkGUIView {
    public static int windowWidth = 1280;
    public static int windowHeight = 720;
    public static int canvasWidth = 1280;
    public static int canvasHeight = 720;

    private static final RecursivePanelView recursivePanelView = new RecursivePanelView(canvasWidth, canvasHeight);
    private static final Panel recursivePanel = recursivePanelView.getPanel();
    private static final CirclePackingPanelView circlePackingPanelView = new CirclePackingPanelView(canvasWidth, canvasHeight);
    private static final Panel circlePackingPanel = circlePackingPanelView.getPanel();
    private static final SierpinskiPanelView sierpinskiPanelView = new SierpinskiPanelView(canvasWidth, canvasHeight);
    private static final Panel sierpinskiPanel = sierpinskiPanelView.getPanel();
    private static Frame frame;
    private static JPanel canvas;
    private static Choice algorithmDropdown;
    private static JLabel errorLabel;
    private static Button generateBtn, saveBtn, resetBtn;
    private static BufferedImage artworkImage;

    /**
     * Creates an Artwork GUI Object
     */
    public ArtworkGUIView() {
        setupFrame();
        setupLeftPanel();
        setupCanvas();
        setupBottomPanel();
        artworkImage = createBufferedImage();
    }

    /**
     * Sets up and initialises the GUI View
     */
    public void setupViewWindow() {
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    /**
     * Sets up the parent frame to house all components
     */
    public void setupFrame() {
        frame = new Frame("Generative Art API");
        frame.setLayout(new BorderLayout());
        frame.setSize(windowWidth, windowHeight);
    }

    /**
     * Sets up the left panel for controlling parameters and widgets
     */
    public void setupLeftPanel() {
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
        gbc.insets = new Insets(20, 0, 0, 0);

        generateBtn = new Button("Generate Artwork");
        leftPanel.add(generateBtn, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 0, 0);
        errorLabel = new JLabel("");
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        errorLabel.setForeground(Color.RED);
        leftPanel.add(errorLabel, gbc);

        frame.add(leftPanel, BorderLayout.WEST);
    }

    /**
     * Sets up the algorithm dropdown widget
     */
    public void setupAlgorithmDropdown() {
        algorithmDropdown = new Choice();
        algorithmDropdown.add("-");
        algorithmDropdown.add("Circle Packing");
        algorithmDropdown.add("Recursive Shape");
        algorithmDropdown.add("Sierpinski Shape");
        algorithmDropdown.addItemListener(e -> updateAlgorithmPanelVisibility());
    }

    /**
     * Creates and organises the algorithm panels
     * @param gbc - the Grid layout contrasts
     * @param leftPanel - the parent panel
     */
    public void setupAlgorithmPanels(GridBagConstraints gbc, Panel leftPanel) {
        recursivePanel.setVisible(false);
        circlePackingPanel.setVisible(false);
        sierpinskiPanel.setVisible(false);

        leftPanel.add(recursivePanel, gbc);
        leftPanel.add(circlePackingPanel, gbc);
        leftPanel.add(sierpinskiPanel, gbc);
    }

    /**
     * Creates a buffered image used for drawing the algorithm
     * @return Buffered Image for the algorithm
     */
    public BufferedImage createBufferedImage() {
        return new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Sets up the canvas used by the algorithms to draw the artwork
     */
    public void setupCanvas() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                synchronized (this) {
                    if (artworkImage != null) {
                        g.drawImage(artworkImage, 0, 0, this);
                    }
                }
            }
        };
        canvas.setDoubleBuffered(true);
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        canvas.setBackground(Color.WHITE);
        frame.add(canvas, BorderLayout.CENTER);
    }

    /**
     * Sets the artwork image
     * @param image - the image created by the algorithms
     */
    public void setArtworkImage(BufferedImage image) {
        artworkImage = image;
    }

    /**
     * Sets up and initialises the bottom panel
     */
    public void setupBottomPanel() {
        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setPreferredSize(new Dimension(windowWidth, 50));

        saveBtn = new Button("Save Image");
        resetBtn = new Button("Reset");
        bottomPanel.add(saveBtn);
        bottomPanel.add(resetBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Used to control which panel is shown when an algorithm is selected
     */
    public void updateAlgorithmPanelVisibility() {
        String selected = algorithmDropdown.getSelectedItem();
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        resetCanvas();
        recursivePanel.setVisible("Recursive Shape".equals(selected));
        circlePackingPanel.setVisible("Circle Packing".equals(selected));
        sierpinskiPanel.setVisible("Sierpinski Shape".equals(selected));

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    /**
     * Clears the canvas of any artwork drawn
     */
    public synchronized void resetCanvas() {
        artworkImage = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = artworkImage.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, artworkImage.getWidth(), artworkImage.getHeight());
        g.dispose();
        canvas.repaint();
    }

    /**
     * Gets the frame
     * @return frame
     */
    public Frame getFrame() {
        return frame;
    }

    /**
     * Gets the canvas which holds the artwork
     * @return canvas
     */
    public JPanel getCanvas() {
        return canvas;
    }

    /**
     * Gets the algorithm dropdown box
     * @return algorithmDropdown
     */
    public Choice getAlgorithmDropdown() {
        return algorithmDropdown;
    }

    /**
     * Gets the error label
     * @return errorLabel
     */
    public JLabel getErrorLabel() {
        return errorLabel;
    }

    /**
     * Sets the error label to given string, used for validation
     * @param message - the error message
     */
    public void setErrorLabel(String message) {
        if (message == null || message.isEmpty()) {
            errorLabel.setText("");
            errorLabel.setVisible(false);
        } else {
            errorLabel.setText(message);
            errorLabel.setVisible(true);
        }
    }

    /**
     * Gets the recursive panel
     * @return recursivePanel
     */
    public Panel getRecursivePanel() {
        return recursivePanel;
    }

    /**
     * Gets the circle packing panel
     * @return circlePackingPanel
     */
    public Panel getCirclePackingPanel() {
        return circlePackingPanel;
    }

    /**
     * Gets the sierpinski panel
     * @return sierpinskiPanel
     */
    public Panel getSierpinskiPanel() {
        return sierpinskiPanel;
    }

    /**
     * Gets the generate artwork button
     * @return generateBtn
     */
    public Button getGenerateBtn() {
        return generateBtn;
    }

    /**
     * Gets the save button used to export the artwork
     * @return saveBtn
     */
    public Button getSaveBtn() {
        return saveBtn;
    }

    /**
     * Gets the reset button
     * @return resetBtn
     */
    public Button getResetBtn() {
        return resetBtn;
    }

    /**
     * Gets the panel view associated with the Sierpinski panel
     * @return sierpinskiPanelView
     */
    public SierpinskiPanelView getSierpinskiPanelView() {
        return sierpinskiPanelView;
    }

    /**
     * Gets the panel view associated with the circle packing panel
     * @return circlePackingPanelView
     */
    public CirclePackingPanelView getCirclePackingPanelView() {
        return circlePackingPanelView;
    }

    /**
     * Gets the panel view associated with the recursive shape panel
     * @return recursivePanelView
     */
    public RecursivePanelView getRecursivePanelView() {
        return recursivePanelView;
    }

    /**
     * Gets the canvas width
     * @return canvasWidth
     */
    public int getCanvasWidth() {
        return canvasWidth;
    }

    /**
     * Gets the canvas  height
     * @return canvasHeight
     */
    public int getCanvasHeight() {
        return canvasHeight;
    }
}


