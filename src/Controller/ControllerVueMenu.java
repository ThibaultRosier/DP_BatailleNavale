package Controller;

import Vue.VueFenetre;
import Vue.VueNewPartie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControllerVueMenu implements ActionListener {

    private String ope;
    private JPanel jp;

    public ControllerVueMenu(String ope, JPanel jp){
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

        switch(ope){
            case "newPartie":
                frame.changerPanel("vueNewPartie");
                break;

            case "load":
                frame.changerPanel("vueLoad");
                break;

            case "quit":
                frame.dispose();
                break;

            default:
        }


    }
}
