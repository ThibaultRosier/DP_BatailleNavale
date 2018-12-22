package vue;

import javax.swing.*;

public class VueCase extends JButton{

    private int ligne,colonne;


    public VueCase(int ligne, int colonne, ImageIcon i) {
        super();
        super.setIcon(i);
        this.ligne = ligne;
        this.colonne = colonne;
    }
}
