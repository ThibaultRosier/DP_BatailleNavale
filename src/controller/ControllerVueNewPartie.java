package controller;

import vue.VueFenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVueNewPartie implements ActionListener {

    private String ope;
    private JPanel jp;

    public ControllerVueNewPartie(String ope, JPanel jp) {
        this.ope = ope;
        this.jp = jp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Window window = SwingUtilities.windowForComponent(jp);
        VueFenetre frame = null;
        if (window instanceof JFrame) {
            frame = (VueFenetre) window;
        }

        switch (ope) {
            case "retour":
                frame.changerPanel("vueMenuPrincipal");
                break;

            case "lancer":
                frame.changerPanel("vueJeu");
                break;
        }
    }
}