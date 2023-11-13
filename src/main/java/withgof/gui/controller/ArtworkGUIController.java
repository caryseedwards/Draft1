package withgof.gui.controller;

import withgof.algorithms.CirclePackingAlgorithm;
import withgof.algorithms.RecursiveShapeAlgorithm;
import withgof.algorithms.SierpinskiShapeAlgorithm;
import withgof.gui.model.ParametersModel;
import withgof.gui.view.ArtworkGUIView;
import withgof.validate.Validate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArtworkGUIController {
    private final ArtworkGUIView view;
    private final ParametersModel model;
    private RecursiveShapeController recursivePanelController;
    private CirclePackingController circlePackingPanelController;
    private SierpinskiController sierpinskiPanelController;
    private Timer animationTimer;

    public ArtworkGUIController(ArtworkGUIView view, ParametersModel model) {
        this.view = view;
        this.model = model;
        initialiseControllers();
    }

    private void initialiseControllers() {
        recursivePanelController = new RecursiveShapeController(model, view.getRecursivePanelView());
        circlePackingPanelController = new CirclePackingController(model, view.getCirclePackingPanelView());
        sierpinskiPanelController = new SierpinskiController(model, view.getSierpinskiPanelView());
        view.getAlgorithmDropdown().addItemListener(this::handleAlgorithmSelection);
        view.getGenerateBtn().addActionListener(e -> generateArtwork());
        view.getSaveBtn().addActionListener(e -> saveImage());
        view.getResetBtn().addActionListener(e -> view.resetCanvas());
    }

    public void handleAlgorithmSelection(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedAlgorithm = e.getItem().toString();
            updateAlgorithmPanelVisibility(selectedAlgorithm);
        }
    }

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


    public void generateArtwork() {
        BufferedImage image = view.createBufferedImage();
        Graphics2D g2d = image.createGraphics();
        applyRenderingHints(g2d);

        String validationError;
        view.setErrorLabel("");

        switch (view.getAlgorithmDropdown().getSelectedItem()) {
            case "Recursive Shape":
                validationError = Validate.validateRecursivePanelView(view.getRecursivePanelView());
                if (validationError.isEmpty()) {
                    RecursiveShapeAlgorithm recursive = new RecursiveShapeAlgorithm(
                            model.getCanvasParams(), model.getShapesParams(), model.getRecursiveParams());
                    recursive.executeAlgorithm();
                    recursive.drawPattern(g2d);
                } else {
                    view.setErrorLabel(validationError);
                }
                break;
            case "Circle Packing":
                validationError = Validate.validateCirclePackingPanelView(view.getCirclePackingPanelView());
                if (validationError.isEmpty()) {
                    CirclePackingAlgorithm packing = new CirclePackingAlgorithm(
                            model.getCanvasParams(), model.getShapesParams(), model.getPackingParams());
                    packing.executeAlgorithm();

                    if (animationTimer != null) {
                        animationTimer.stop();
                    }

                    animationTimer = new Timer(packing.params.animationSpeed, e -> {
                        packing.addCircles();
                        BufferedImage image1 = view.createBufferedImage();
                        Graphics2D g2d1 = image1.createGraphics();
                        applyRenderingHints(g2d1);
                        packing.drawPattern(g2d1);
                        g2d1.dispose();
                        view.setArtworkImage(image1);
                        view.getCanvas().repaint();
                    });

                    animationTimer.start();
                } else {
                    view.setErrorLabel(validationError);
                }
                break;
            case "Sierpinski Shape":
                validationError = Validate.validateSierpinskiPanelView(view.getSierpinskiPanelView());
                if (validationError.isEmpty()) {
                    SierpinskiShapeAlgorithm sierpinski = new SierpinskiShapeAlgorithm(
                            model.getCanvasParams(), model.getShapesParams(), model.getSierpinskiParams());
                    sierpinski.executeAlgorithm();
                    sierpinski.drawPattern(g2d);
                } else {
                    view.setErrorLabel(validationError);
                }
                break;
            default:
                view.getErrorLabel().setText("Please select a valid algorithm.");
        }

        g2d.dispose();
        view.setArtworkImage(image);
        view.getCanvas().repaint();
    }

    private void applyRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    }


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
            ex.printStackTrace();
            view.getErrorLabel().setText("Error saving image: " + ex.getMessage());
        } finally {
            g2d.dispose();
        }
    }

    public RecursiveShapeController getRecursiveController() {
        return recursivePanelController;
    }

    public void setRecursiveController(RecursiveShapeController rsc) {
        recursivePanelController = rsc;
    }

    public CirclePackingController getPackingController() {
        return circlePackingPanelController;
    }

    public void setPackingController(CirclePackingController cpc) {
        circlePackingPanelController = cpc;
    }

    public SierpinskiController getSierpinskiPanelController() {
        return sierpinskiPanelController;
    }

    public void setSierpinskiPanelController(SierpinskiController sc) {
        sierpinskiPanelController = sc;
    }
}

