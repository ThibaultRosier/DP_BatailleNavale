package Controller;

import model.server.Partie;
import vue.VueFenetre;
import vue.VueJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

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
                try {
                    frame.changerPanel("vueOption");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                break;

            default:
        }
    }
}