package Vue;

import Controller.ControllerVueLoad;
import Model.Sauvegarde;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;

public class VueLoad extends JPanel {

    ArrayList<Sauvegarde> lesSauvegardes;

    public VueLoad() {

        lesSauvegardes = new ArrayList<>();

        chargerSave(new File("./fichier_sauvegarde"));

        setLayout(new BorderLayout());

        JLabel loadLabel = new JLabel("Charger une partie");
        loadLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));

        JButton charger = new JButton("Charger");
        JButton retour = new JButton("Retour");
        charger.addActionListener(new ControllerVueLoad("charger",this));
        retour.addActionListener(new ControllerVueLoad("retour",this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.LINE_AXIS));
        buttonPanel.add(charger);
        buttonPanel.add(retour);

        JList liste = new JList();

        DefaultListModel listModel = new DefaultListModel();

        //Remplir le model
        int size = lesSauvegardes.size();
        for(int index=0; index<size; index++)
        {
            listModel.addElement(lesSauvegardes.get(index).getNom()+"        "+lesSauvegardes.get(index).getEpoque()+"       "+lesSauvegardes.get(index).getTypePartie()+"         "+lesSauvegardes.get(index).getDate());
        }

        //Donné le model à la liste
        liste.setModel(listModel);

        JScrollPane js = new JScrollPane(liste);
        js.createVerticalScrollBar();


        add(loadLabel,BorderLayout.NORTH);
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
                try {
                    if(Sauvegarde.deSerialize(listefichiers[i].substring(0, listefichiers[i].length() - 5))!= null) {
                        lesSauvegardes.add(Sauvegarde.deSerialize(listefichiers[i].substring(0, listefichiers[i].length() - 5)));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
