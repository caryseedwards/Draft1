package gui;

import gui.controller.ArtworkGUIController;
import gui.model.ParametersModel;
import gui.view.ArtworkGUIView;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class mainGUI {
        public static void main (String[]args){
        System.out.println("Hihihihi"); // Debug message
        ParametersModel model = new ParametersModel();
        ArtworkGUIView view = new ArtworkGUIView();
        ArtworkGUIController artworkGUIController = new ArtworkGUIController(view, model);
        System.out.println("main mvc's initialised"); // Debug message
        // Setup the view Window
        view.setupViewWindow();

        // Display the main frame
        view.getFrame().setVisible(true);
        System.out.println("end reached"); // Debug message
                 view.getFrame().addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                view.getFrame().dispose();
                        }
                });
    }
}
