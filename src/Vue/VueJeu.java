package vue;

import Controller.ControllerVueJeu;

import javax.swing.*;
import java.awt.*;

public class VueJeu extends JPanel {

    private JLabel[][] tabPlateauDroite;
    private JLabel[][] tabPlateauGauche;

    public VueJeu(){

        this.setLayout(new BorderLayout());

        tabPlateauDroite = new JLabel[11][11];
        tabPlateauGauche = new JLabel[11][11];

        JPanel plateauDroite = new JPanel();
        JPanel plateauGauche = new JPanel();

        JPanel nord = new JPanel();
        JPanel sud = new JPanel();

        JButton option = new JButton("Option");
        option.addActionListener(new ControllerVueJeu("option",this));
        nord.add(option);

        JLabel labelDroite = new JLabel("Vos Batiments :");
        labelDroite.setHorizontalAlignment(JLabel.CENTER);
        JLabel labelGauche = new JLabel("Vos Tirs :");
        labelGauche.setHorizontalAlignment(JLabel.CENTER);

        JPanel JPdroite = new JPanel();
        JPdroite.setLayout(new BorderLayout());
        JPdroite.add(labelDroite,BorderLayout.NORTH);
        JPdroite.add(plateauGauche,BorderLayout.CENTER);

        JPanel JPgauche = new JPanel();
        JPgauche.setLayout(new BorderLayout());
        JPgauche.add(labelGauche,BorderLayout.NORTH);
        JPgauche.add(plateauDroite,BorderLayout.CENTER);

        JButton tirer = new JButton("Tirer");
        option.addActionListener(new ControllerVueJeu("tirer",this));
        sud.add(tirer);

        plateauDroite.setLayout(null);
        plateauDroite.setPreferredSize(new Dimension(11*50,11*50));

        plateauGauche.setLayout(null);
        plateauGauche.setPreferredSize(new Dimension(11*50,11*50));


        creerPlateau(plateauDroite,tabPlateauDroite);
        creerPlateau(plateauGauche,tabPlateauGauche);


        JSplitPane js = new JSplitPane(SwingConstants.VERTICAL, JPgauche, JPdroite);
        js.setEnabled(false);
        this.add(js, BorderLayout.CENTER);
        this.add(nord,BorderLayout.NORTH);
        this.add(sud,BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void creerPlateau(JPanel jp, JLabel[][] tab){

        tab[0][0] = new JLabel();
        tab[0][0].setBorder(BorderFactory.createLineBorder(Color.black));
        tab[0][0].setBounds(0,0,50,50);
        jp.add(tab[0][0]);

        for(int j =1; j<11; j++){
            tab[0][j] = new JLabel(j+"");
            tab[0][j].setHorizontalAlignment(JLabel.CENTER);
            tab[0][j].setBorder(BorderFactory.createLineBorder(Color.black));
            tab[0][j].setBounds(0,j*50,50,50);
            jp.add(tab[0][j]);
        }

        for(int i =1; i<11; i++){
            tab[i][0] = new JLabel(Character.toString ((char)(64+i)));
            tab[i][0].setHorizontalAlignment(JLabel.CENTER);
            tab[i][0].setBorder(BorderFactory.createLineBorder(Color.black));
            tab[i][0].setBounds(i*50,0,50,50);
            jp.add(tab[i][0]);
        }

        for(int i =1; i<11; i++){
            for(int j =1; j<11; j++){
                tab[i][j] = new Case(i,j,null);
                tab[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                tab[i][j].setBounds(i*50,j*50,50,50);
                jp.add(tab[i][j]);
            }
        }
    }
}
