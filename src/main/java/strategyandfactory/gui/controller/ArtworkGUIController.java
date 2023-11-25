package strategyandfactory.gui.controller;

import strategyandfactory.algorithms.AlgorithmContext;
import strategyandfactory.algorithms.CirclePackingAlgorithm;
import strategyandfactory.algorithms.RecursiveShapeAlgorithm;
import strategyandfactory.algorithms.SierpinskiShapeAlgorithm;
import strategyandfactory.gui.model.ParametersModel;
import strategyandfactory.gui.view.ArtworkGUIView;
import strategyandfactory.validate.Validate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static strategyandfactory.algorithms.AlgorithmContext.getAlgorithmContext;

/**
 * The controller for the Artwork GUI
 * Part of the MVC pattern
 * @author carysedwards
 */
public class ArtworkGUIController {
    private final ArtworkGUIView view;
    private final ParametersModel model;
    private final AlgorithmContext context = getAlgorithmContext();
    private RecursiveShapeController recursivePanelController;
    private CirclePackingController circlePackingPanelController;
    private SierpinskiController sierpinskiPanelController;
    private Timer animationTimer;

    /**
     * Creates an artwork gui controller
     * @param view - the view for the controller
     * @param model - the model for the controller
     */
    public ArtworkGUIController(ArtworkGUIView view, ParametersModel model) {
        this.view = view;
        this.model = model;
        initialiseControllers();
    }

    /**
     * Initialises the necessary components of the controller
     * Sets up child controllers for the algorithm pannels
     */
    private void initialiseControllers() {
        recursivePanelController = new RecursiveShapeController(model, view.getRecursivePanelView());
        circlePackingPanelController = new CirclePackingController(model, view.getCirclePackingPanelView());
        sierpinskiPanelController = new SierpinskiController(model, view.getSierpinskiPanelView());
        view.getAlgorithmDropdown().addItemListener(this::handleAlgorithmSelection);
        view.getGenerateBtn().addActionListener(e -> generateArtwork());
        view.getSaveBtn().addActionListener(e -> saveImage());
        view.getResetBtn().addActionListener(e -> view.resetCanvas());
    }

    /**
     * When an algorithm is selected change the panel
     * @param e - algorithm selection event
     */
    public void handleAlgorithmSelection(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedAlgorithm = e.getItem().toString();
            updateAlgorithmPanelVisibility(selectedAlgorithm);
        }
    }

    /**
     * Updates the visibility of the algorithm panel
     * @param selectedAlgorithm - the algorithm selected
     */
    public void updateAlgorithmPanelVisibility(String selectedAlgorithm) {
        if (animationTimer != null) {
            animationTimer.stop();
        }
        view.getCanvas().removeAll();

        view.getRecursivePanel().setVisible("Recursive Shape".equals(selectedAlgorithm));
        view.getCirclePackingPanel().setVisible("Circle Packing".equals(selectedAlgorithm));
        view.getSierpinskiPanel().setVisible("Sierpinski Shape".equals(selectedAlgorithm));

        view.getFrame().add(view.getCanvas(), BorderLayout.CENTER);
        view.resetCanvas();
        view.getFrame().invalidate();
        view.getFrame().validate();
        view.getFrame().repaint();
    }

    /**
     * Generates the artwork by executing the algorithm selected
     * with the given parameters
     */
    public void generateArtwork() {
        BufferedImage image = view.createBufferedImage();
        Graphics2D g2d = image.createGraphics();
        applyRenderingHints(g2d);

        String validationError = "";
        view.setErrorLabel("");

        switch (view.getAlgorithmDropdown().getSelectedItem()) {
            case "Recursive Shape":
                validationError = Validate.validateRecursivePanelView(view.getRecursivePanelView());
                if (validationError.isEmpty()) {
                    recursivePanelController.updateModelWithPanelSettings();
                    context.setStrategy(new RecursiveShapeAlgorithm(
                            model.getCanvasParams(), model.getShapesParams(), model.getRecursiveParams()));
                } else {
                    view.setErrorLabel(validationError);
                }
                break;
            case "Circle Packing":
                validationError = Validate.validateCirclePackingPanelView(view.getCirclePackingPanelView());
                if (validationError.isEmpty()) {
                    circlePackingPanelController.updateModelWithPanelSettings();
                    context.setStrategy(new CirclePackingAlgorithm(
                            model.getCanvasParams(), model.getShapesParams(), model.getPackingParams()));
                } else {
                    view.setErrorLabel(validationError);
                }
                break;
            case "Sierpinski Shape":
                validationError = Validate.validateSierpinskiPanelView(view.getSierpinskiPanelView());
                if (validationError.isEmpty()) {
                    sierpinskiPanelController.updateModelWithPanelSettings();
                    context.setStrategy(new SierpinskiShapeAlgorithm(
                            model.getCanvasParams(), model.getShapesParams(), model.getSierpinskiParams()));
                } else {
                    view.setErrorLabel(validationError);
                }
                break;
            default:
                view.setErrorLabel("Please select an algorithm.");
        }

        if ((!view.getAlgorithmDropdown().getSelectedItem().equals("-")) && validationError.isEmpty()) {
            context.executeAlgorithm();
            context.drawPattern(g2d);
            if (context.getStrategy() instanceof CirclePackingAlgorithm) {
                startCirclePackingAnimation((CirclePackingAlgorithm) this.context.getStrategy());
            }
            g2d.dispose();
            view.setArtworkImage(image);
            view.getCanvas().repaint();
        }
    }

    /**
     * Helper method for the Circle Packing algorithm to start the animation
     * @param cpa - the Circle Packing Algorithm to execute
     */
    private void startCirclePackingAnimation(CirclePackingAlgorithm cpa) {
        if (animationTimer != null) {
            animationTimer.stop();
        }

        animationTimer = new Timer(cpa.getAlgorithmParameters().animationSpeed, e -> {
            cpa.addCircles();
            BufferedImage image1 = view.createBufferedImage();
            Graphics2D g2d1 = image1.createGraphics();
            applyRenderingHints(g2d1);
            cpa.drawPattern(g2d1);
            g2d1.dispose();
            view.setArtworkImage(image1);
            view.getCanvas().repaint();
        });
        animationTimer.start();
    }

    /**
     * Helper method to improve the quality of the drawings
     * @param g2d - the graphics object to improve quality of
     */
    private void applyRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    }

    /**
     * Saves the current state of the canvas to a specified location in PNG format
     */
    public void saveImage() {
        BufferedImage image = new BufferedImage(view.getCanvasWidth(), view.getCanvasHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        view.getCanvas().paint(g2d);

        try {
            FileDialog fd = new FileDialog(view.getFrame(), "Save Image", FileDialog.SAVE);
            fd.setVisible(true);
            String filename = fd.getFile();
            if (filename != null) {
                File file = new File(fd.getDirectory(), filename);
                ImageIO.write(image, "PNG", file);
            }
        } catch (IOException ex) {
            view.getErrorLabel().setText("Error saving image: " + ex.getMessage());
        } finally {
            g2d.dispose();
        }
    }

    /**
     * Gets the recursive algorithm panel controller
     * @return recursivePanelController
     */
    public RecursiveShapeController getRecursiveController() {
        return recursivePanelController;
    }

    /**
     * Sets the recursive algorithm panel controller
     */
    public void setRecursiveController(RecursiveShapeController rsc) {
        recursivePanelController = rsc;
    }

    /**
     * Gets the circle packing algorithm panel controller
     * @return circlePackingPanelController
     */
    public CirclePackingController getPackingController() {
        return circlePackingPanelController;
    }

    /**
     * Sets the circle packing algorithm panel controller
     */
    public void setPackingController(CirclePackingController cpc) {
        circlePackingPanelController = cpc;
    }

    /**
     * Gets the sierpinski algorithm panel controller
     * @return sierpinskiPanelController
     */
    public SierpinskiController getSierpinskiPanelController() {
        return sierpinskiPanelController;
    }

    /**
     * Sets the sierpinski algorithm panel controller
     */
    public void setSierpinskiPanelController(SierpinskiController sc) {
        sierpinskiPanelController = sc;
    }
}
