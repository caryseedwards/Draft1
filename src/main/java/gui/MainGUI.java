package gui;

import gui.controller.ArtworkGUIController;
import gui.model.ParametersModel;
import gui.view.ArtworkGUIView;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainGUI {
        public static void main (String[]args){
        ParametersModel model = new ParametersModel();
        ArtworkGUIView view = new ArtworkGUIView();
        ArtworkGUIController artworkGUIController = new ArtworkGUIController(view, model);
        view.setupViewWindow();
        view.getFrame().setVisible(true);
                 view.getFrame().addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                view.getFrame().dispose();
                        }
                });
    }
}
