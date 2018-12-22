package vue;

import controller.ControllerVueJeu;
import model.server.Camp;
import model.server.Partie;
import model.server.batiment.GrandBatiment;
import model.server.batiment.MoyenBatiment;
import model.server.batiment.PetitBatiment;
import model.service.Case;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class VueJeu extends JPanel {

    private JButton[][] tabPlateauDroite;
    private JButton[][] tabPlateauGauche;
    private Partie partie;
    private Case[][] plateauBateaux;
    private Case[][] plateauTires;

    public VueJeu() throws RemoteException {

        this.setLayout(new BorderLayout());

        partie = Partie.getPartieEnCour();

        Camp c = partie.getCampJoueur1();
        plateauBateaux = c.getCamp();

        Camp c2 = partie.getCampJoueur2();
        plateauTires = c2.getCamp();

        tabPlateauDroite = new JButton[11][11];
        tabPlateauGauche = new JButton[11][11];

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

    public void creerPlateau(JPanel jp, JButton[][] tab){

        tab[0][0] = new JButton();
        tab[0][0].setBorder(BorderFactory.createLineBorder(Color.black));
        tab[0][0].setBounds(0,0,50,50);
        tab[0][0].setEnabled(false);
        jp.add(tab[0][0]);

        for(int j =1; j<11; j++){
            tab[0][j] = new JButton(j+"");
            tab[0][j].setHorizontalAlignment(JLabel.CENTER);
            tab[0][j].setBorder(BorderFactory.createLineBorder(Color.black));
            tab[0][j].setBounds(0,j*50,50,50);
            tab[0][j].setEnabled(false);
            jp.add(tab[0][j]);
        }

        for(int i =1; i<11; i++){
            tab[i][0] = new JButton(Character.toString ((char)(64+i)));
            tab[i][0].setHorizontalAlignment(JLabel.CENTER);
            tab[i][0].setBorder(BorderFactory.createLineBorder(Color.black));
            tab[i][0].setBounds(i*50,0,50,50);
            tab[i][0].setEnabled(false);
            jp.add(tab[i][0]);
        }

        for(int i =1; i<11; i++){
            for(int j =1; j<11; j++){
                tab[i][j] = new VueCase(i,j,null);
                tab[i][j].setBackground(new Color(0,206,209));
                if(tab.equals(tabPlateauGauche)) {
                    if (plateauBateaux[i - 1][j - 1].getBatiment() instanceof PetitBatiment) {
                        tab[i][j].setBackground(Color.GRAY);
                    } else if (plateauBateaux[i - 1][j - 1].getBatiment() instanceof MoyenBatiment) {
                        tab[i][j].setBackground(Color.DARK_GRAY);
                    } else if (plateauBateaux[i - 1][j - 1].getBatiment() instanceof GrandBatiment) {
                        tab[i][j].setBackground(Color.BLACK);
                    }
                }
                else{
                    if (plateauTires[i - 1][j - 1].getToucher()) {
                        if(plateauTires[i - 1][j - 1].getBatiment() == null){
                            tab[i][j].setBackground(new Color(0,0,100));
                        }
                        else{
                            tab[i][j].setBackground(new Color(133,6,6));
                        }
                    }
                }
                tab[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                tab[i][j].setBounds(i*50,j*50,50,50);
                jp.add(tab[i][j]);
            }
        }
    }
}
