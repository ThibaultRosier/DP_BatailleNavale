package Controller;

import Vue.DialogNewSave;
import Vue.VueFenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVueSave implements ActionListener {

    private String ope;
    private JPanel jp;

    public ControllerVueSave(String ope, JPanel jp){
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
            case "save":

                break;

            case "retour":
                frame.changerPanel("vueMenuPrincipal");
                break;

            case "newSave":
                new DialogNewSave();
                break;

            default:
        }


    }
}