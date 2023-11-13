package withoutgof.gui.view;

import withoutgof.gui.view.panel.CirclePackingPanelView;
import withoutgof.gui.view.panel.RecursivePanelView;
import withoutgof.gui.view.panel.SierpinskiPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

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

    public ArtworkGUIView() {
        setupFrame();
        setupLeftPanel();
        setupCanvas();
        setupBottomPanel();
        artworkImage = createBufferedImage();
    }

    public void setupViewWindow() {
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public void setupFrame() {
        frame = new Frame("Generative Art API");
        frame.setLayout(new BorderLayout());
        frame.setSize(windowWidth, windowHeight);
    }

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

    public void setupAlgorithmDropdown() {
        algorithmDropdown = new Choice();
        algorithmDropdown.add("-");
        algorithmDropdown.add("Circle Packing");
        algorithmDropdown.add("Recursive Shape");
        algorithmDropdown.add("Sierpinski Shape");
        algorithmDropdown.addItemListener(e -> updateAlgorithmPanelVisibility());
    }

    public void setupAlgorithmPanels(GridBagConstraints gbc, Panel leftPanel) {
        recursivePanel.setVisible(false);
        circlePackingPanel.setVisible(false);
        sierpinskiPanel.setVisible(false);

        leftPanel.add(recursivePanel, gbc);
        leftPanel.add(circlePackingPanel, gbc);
        leftPanel.add(sierpinskiPanel, gbc);
    }

    public BufferedImage createBufferedImage() {
        return new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
    }

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

    public void setArtworkImage(BufferedImage image) {
        artworkImage = image;
    }

    public void setupBottomPanel() {
        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setPreferredSize(new Dimension(windowWidth, 50));

        saveBtn = new Button("Save Image");
        resetBtn = new Button("Reset");
        bottomPanel.add(saveBtn);
        bottomPanel.add(resetBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

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

    public synchronized void resetCanvas() {
        artworkImage = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = artworkImage.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, artworkImage.getWidth(), artworkImage.getHeight());
        g.dispose();
        canvas.repaint();
    }

    public Frame getFrame() {
        return frame;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public Choice getAlgorithmDropdown() {
        return algorithmDropdown;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String message) {
        if (message == null || message.isEmpty()) {
            errorLabel.setText("");
            errorLabel.setVisible(false);
        } else {
            errorLabel.setText(message);
            errorLabel.setVisible(true);
        }
    }

    public Panel getRecursivePanel() {
        return recursivePanel;
    }

    public Panel getCirclePackingPanel() {
        return circlePackingPanel;
    }

    public Panel getSierpinskiPanel() {
        return sierpinskiPanel;
    }

    public Button getGenerateBtn() {
        return generateBtn;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public Button getResetBtn() {
        return resetBtn;
    }

    public SierpinskiPanelView getSierpinskiPanelView() {
        return sierpinskiPanelView;
    }

    public CirclePackingPanelView getCirclePackingPanelView() {
        return circlePackingPanelView;
    }

    public RecursivePanelView getRecursivePanelView() {
        return recursivePanelView;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }
}


