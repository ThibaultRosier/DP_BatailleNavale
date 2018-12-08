package Controller;

import Model.Sauvegarde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

public class ControllerDialogNewSave implements ActionListener {

    private JTextField jt;

    public ControllerDialogNewSave(JTextField jt) {
        this.jt = jt;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(!jt.getText().equals("")){
            Sauvegarde s = new Sauvegarde(jt.getText(),"xx","classic");
            try {
                s.serialize(jt.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Window window = SwingUtilities.windowForComponent((Component)e.getSource());
            window.dispose();
        }
        else{
            JOptionPane.showMessageDialog(jt.getParent(), "saisissez un nom");
        }
    }
}
