package vue;

import javax.swing.*;

public class Case extends JButton{

    private int ligne,colonne;


    public Case(int ligne, int colonne, ImageIcon i) {
        super();
        super.setIcon(i);
        this.ligne = ligne;
        this.colonne = colonne;
    }
}
