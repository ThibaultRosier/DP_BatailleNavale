package controller;

import model.server.Sauvegarde;
import vue.DialogNewSave;
import vue.VueFenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

public class ControllerVueSave implements ActionListener {

    private String ope;
    private JPanel jp;
    private JList liste;

    public ControllerVueSave(String ope, JPanel jp, JList liste){
        this.ope = ope;
        this.jp = jp;
        this.liste = liste;
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
                if(!liste.isSelectionEmpty()){
                    Sauvegarde s = new Sauvegarde((Sauvegarde) liste.getSelectedValue());
                    try {
                        s.serialize(((Sauvegarde)liste.getSelectedValue()).getNom());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Aucune sauvegarde selectionnée");
                }

                break;

            case "retour":
                try {
                    frame.changerPanel("vueOption");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
                break;

            case "newSave":
                new DialogNewSave();
                break;

            default:
        }


    }
}