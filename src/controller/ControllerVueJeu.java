package controller;

import vue.VueFenetre;
import vue.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVueJeu implements ActionListener {

    private JPanel vueJeu;
    private String ope;

    public ControllerVueJeu(String ope, VueJeu vueJeu) {
        this.vueJeu = vueJeu;
        this.ope = ope;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window window = SwingUtilities.windowForComponent(vueJeu);
        VueFenetre frame = null;
        if (window instanceof JFrame) {
            frame = (VueFenetre) window;
        }
        switch(ope){
            case "tirer":

                break;

            case "option":
                frame.changerPanel("vueOption");
                break;

            default:
        }

    }
}
