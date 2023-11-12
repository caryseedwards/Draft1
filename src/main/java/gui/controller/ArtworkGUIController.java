package gui.controller;

import algorithms.*;
import gui.model.ParametersModel;
import gui.view.ArtworkGUIView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArtworkGUIController {
    private static ArtworkGUIView view;
    private static ParametersModel model; // This model should be the one holding the parameters for each algorithm
    private static RecursiveShapeController recursivePanelController;
    private static CirclePackingController circlePackingPanelController;
    private static SierpinskiController sierpinskiPanelController;

    public ArtworkGUIController(ArtworkGUIView view, ParametersModel model) {
        ArtworkGUIController.view = view;
        ArtworkGUIController.model = model;
        initController();
    }

    private void initController() {
        recursivePanelController = new RecursiveShapeController(model, view.getRecursivePanelView());
        circlePackingPanelController = new CirclePackingController(model, view.getCirclePackingPanelView());
        sierpinskiPanelController = new SierpinskiController(model, view.getSierpinskiPanelView());
        view.getAlgorithmDropdown().addItemListener(this::handleAlgorithmSelection);
        view.getGenerateBtn().addActionListener(e -> generateArtwork());
        view.getSaveBtn().addActionListener(e -> saveImage());
      //  view.getResetBtn().addActionListener(e -> resetCanvas());
    }


    private void handleAlgorithmSelection(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedAlgorithm = e.getItem().toString();
            updateAlgorithmPanelVisibility(selectedAlgorithm);
        }
    }

    private void updateAlgorithmPanelVisibility(String selectedAlgorithm) {
        // Update visibility of panels based on the selected algorithm
        view.getRecursivePanel().setVisible("Recursive Shape".equals(selectedAlgorithm));
        view.getCirclePackingPanel().setVisible("Circle Packing".equals(selectedAlgorithm));
        view.getSierpinskiPanel().setVisible("Sierpinski Shape".equals(selectedAlgorithm));
    }
    private void generateArtwork() {
        System.out.println("Generating Artwork"); // Debug message
        String selectedAlgorithm = view.getAlgorithmDropdown().getSelectedItem();
        System.out.println("Selected " +selectedAlgorithm +" Shape Artwork"); // Debug message
        switch (selectedAlgorithm) {
            case "Recursive Shape":
                // Assuming RecursiveShapeAlgorithm correctly draws the pattern on a BufferedImage
                recursivePanelController.printModelParameters();
                recursivePanelController.hardUpdateParams();
                recursivePanelController.printModelParameters();
                RecursiveShapeAlgorithm recursiveShape = new RecursiveShapeAlgorithm(
                        model.getCanvasParams(), model.getShapesParams(), model.getRecursiveParams());

                recursiveShape.executeAlgorithm();
                BufferedImage image = new BufferedImage(
                        view.getCanvas().getWidth(),
                        view.getCanvas().getHeight(),
                        BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = image.createGraphics();
                System.out.println("Graphics2d initialised Recursive Shape Artwork"); // Debug message

                view.getFrame().add(recursiveShape);
                view.getFrame().setVisible(true);
                System.out.println("Add  Recursive Shape Pattern to Frame"); // Debug message
                //g2d.dispose();
                //System.out.println("Dispose? Recursive Shape Artwork"); // Debug message
                view.setArtworkImage(image);
                System.out.println("View Image Recursive Shape Artwork"); // Debug message
                break;
            case "Circle Packing":
                // Similar logic for CirclePackingAlgorithm
                break;
            case "Sierpinski Shape":
                // Similar logic for SierpinskiShapeAlgorithm
                break;
            default:
                view.getErrorLabel().setText("Please select a valid algorithm.");
        }
       // view.getCanvas().repaint();
    }

    private void saveImage() {
        BufferedImage image = new BufferedImage(view.getCanvas().getWidth(), view.getCanvas().getHeight(), BufferedImage.TYPE_INT_ARGB);
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

//    private void resetCanvas() {
//        Graphics g = view.getCanvas().getGraphics(); // Again, be cautious with getGraphics
//        if (g != null) {
//            g.clearRect(0, 0, view.getCanvas().getWidth(), view.getCanvas().getHeight());
//            view.getCanvas().repaint();
//        }
//    }

    private void setRecursiveController(RecursiveShapeController rsc){
    recursivePanelController = rsc;
    }
    private RecursiveShapeController getRecursiveController(){
        return recursivePanelController;
    }
    private void setPackingController(CirclePackingController cpc){
        circlePackingPanelController = cpc;
    }
    private CirclePackingController getPackingController(){
        return circlePackingPanelController;
    }
    private void setSierpinskiPanelController(SierpinskiController sc){
        sierpinskiPanelController = sc;
    }
    private SierpinskiController getSierpinskiPanelController(){
        return sierpinskiPanelController;
    }
}

