package Vue;

import javax.swing.*;
import java.awt.*;

public class VueNewPartie extends JPanel {

    private JComboBox typePartie;
    private JComboBox epoque;
    private JComboBox tirOrdi;


    public VueNewPartie() {

        JPanel centre = new JPanel();
        centre.setLayout(new GridLayout(4,1,50,50));

        Object[] elements = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};

        typePartie = new JComboBox(elements);
        epoque = new JComboBox(elements);
        tirOrdi = new JComboBox(elements);

        typePartie.setPreferredSize(new Dimension(100,50));
        typePartie.setSize(new Dimension(100,50));

        centre.add(typePartie);
        centre.add(epoque);
        centre.add(tirOrdi);


        JPanel sud = new JPanel();

        JButton launch = new JButton("Lancer la partie");
        JButton retour = new JButton("Retour");

        sud.setLayout(new GridLayout(1,2,100,100));
        sud.add(launch);
        sud.add(retour);

        this.setLayout(new BorderLayout());
        this.add(centre,BorderLayout.CENTER);
        this.add(sud,BorderLayout.SOUTH);

        setVisible(true);
    }
}
