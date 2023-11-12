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
    private final ArtworkGUIView view;
    private final ParametersModel model;
    private  RecursiveShapeController recursivePanelController;
    private  CirclePackingController circlePackingPanelController;
    private  SierpinskiController sierpinskiPanelController;

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
        view.getResetBtn().addActionListener(e -> resetCanvas());
    }


    public void handleAlgorithmSelection(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedAlgorithm = e.getItem().toString();
            updateAlgorithmPanelVisibility(selectedAlgorithm);
        }
    }

    public void updateAlgorithmPanelVisibility(String selectedAlgorithm) {
        view.getRecursivePanel().setVisible("Recursive Shape".equals(selectedAlgorithm));
        view.getCirclePackingPanel().setVisible("Circle Packing".equals(selectedAlgorithm));
        view.getSierpinskiPanel().setVisible("Sierpinski Shape".equals(selectedAlgorithm));
    }
    public void generateArtwork() {
       BufferedImage image = view.createBufferedImage();
       Graphics2D g2d = image.createGraphics();
        switch (view.getAlgorithmDropdown().getSelectedItem()) {
            case "Recursive Shape":
                RecursiveShapeAlgorithm recursive = new RecursiveShapeAlgorithm(
                        model.getCanvasParams(), model.getShapesParams(), model.getRecursiveParams());
                recursive.executeAlgorithm();
                view.getFrame().add(recursive);
                break;
            case "Circle Packing":
                CirclePackingAlgorithm packing = new CirclePackingAlgorithm(model.getCanvasParams(), model.getShapesParams(), model.getPackingParams());
                packing.executeAlgorithm();
                packing.drawPattern(image.getGraphics());
                view.getFrame().add(packing);
                break;
            case "Sierpinski Shape":
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

    public void resetCanvas() {
        Graphics g = view.getCanvas().getGraphics();
        if (g != null) {
            g.clearRect(0, 0, view.getCanvasWidth(), view.getCanvasHeight());
            view.getCanvas().repaint();
       }
        view.setArtworkImage(view.createBufferedImage());
    }

    public void setRecursiveController(RecursiveShapeController rsc){
    recursivePanelController = rsc;
    }
    public RecursiveShapeController getRecursiveController(){
        return recursivePanelController;
    }
    public void setPackingController(CirclePackingController cpc){
        circlePackingPanelController = cpc;
    }
    public CirclePackingController getPackingController(){
        return circlePackingPanelController;
    }
    public void setSierpinskiPanelController(SierpinskiController sc){
        sierpinskiPanelController = sc;
    }
    public SierpinskiController getSierpinskiPanelController(){
        return sierpinskiPanelController;
    }
}

