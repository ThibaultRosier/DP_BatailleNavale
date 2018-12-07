package Vue;

import Controller.ControllerVueSave;
import Model.Sauvegarde;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class VueSave extends JPanel {

    ArrayList<Sauvegarde> lesSauvegardes;

    public VueSave() {

        lesSauvegardes = new ArrayList<>();

        chargerSave(new File("./fichier_sauvegarde"));

        setLayout(new BorderLayout());

        JPanel nord = new JPanel();

        JLabel saveLabel = new JLabel("Charger une partie");
        saveLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));

        JButton newSave = new JButton("Nouvelle Sauvegarde");
        newSave.addActionListener(new ControllerVueSave("newSave",this));

        nord.add(saveLabel);
        nord.add(newSave);

        JButton save = new JButton("Sauvegarder");
        JButton retour = new JButton("Retour");
        save.addActionListener(new ControllerVueSave("save",this));
        retour.addActionListener(new ControllerVueSave("retour",this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
        buttonPanel.add(save);
        buttonPanel.add(retour);

        JList liste = new JList();

        DefaultListModel listModel = new DefaultListModel();

        //Remplir le model
        int size = lesSauvegardes.size();
        for(int index=0; index<size; index++)
        {
            listModel.addElement(lesSauvegardes.get(index).getNom());
        }

        //Donné le model à la liste
        liste.setModel(listModel);

        JScrollPane js = new JScrollPane(liste);
        js.createVerticalScrollBar();


        add(nord,BorderLayout.NORTH);
        add(js,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        this.setPreferredSize(new Dimension(800,500));

    }

    private void chargerSave(File repertoire) {
        String [] listefichiers;
        int i;
        listefichiers=repertoire.list();
        for(i=0;i<listefichiers.length;i++){
            if(listefichiers[i].endsWith(".save")){
                lesSauvegardes.add(new Sauvegarde(listefichiers[i].substring(0,listefichiers[i].length()-5)));
            }
        }
    }
}
