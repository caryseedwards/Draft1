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
        System.out.println("Generating Artwork with "+ view.getAlgorithmDropdown().getSelectedItem());
        BufferedImage image = new BufferedImage(
                view.getCanvas().getWidth(),
                view.getCanvas().getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        switch (view.getAlgorithmDropdown().getSelectedItem()) {
            case "Recursive Shape":
                recursivePanelController.hardUpdateParams();
                RecursiveShapeAlgorithm recursive = new RecursiveShapeAlgorithm(
                        model.getCanvasParams(), model.getShapesParams(), model.getRecursiveParams());
                recursive.executeAlgorithm();
                view.getFrame().add(recursive);

                break;
            case "Circle Packing":
                circlePackingPanelController.printModelParameters();
                circlePackingPanelController.hardUpdateParams();
                circlePackingPanelController.printModelParameters();
                CirclePackingAlgorithm packing = new CirclePackingAlgorithm(model.getCanvasParams(), model.getShapesParams(), model.getPackingParams());
                packing.executeAlgorithm();
                packing.drawPattern(image.getGraphics());
                view.getFrame().add(packing);
                break;
            case "Sierpinski Shape":
                sierpinskiPanelController.printModelParameters();
                sierpinskiPanelController.hardUpdateParams();
                sierpinskiPanelController.printModelParameters();
                SierpinskiShapeAlgorithm sierpinski = new SierpinskiShapeAlgorithm(model.getCanvasParams(), model.getShapesParams(),model.getSierpinskiParams());
                sierpinski.executeAlgorithm();
                sierpinski.drawPattern(image.getGraphics());
                view.getFrame().add(sierpinski);
                break;
            default:
                view.getErrorLabel().setText("Please select a valid algorithm.");
        }
        view.setArtworkImage(image);
        view.getFrame().setVisible(true);

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

