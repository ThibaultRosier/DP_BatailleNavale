package Vue;

import javax.swing.*;
import java.awt.*;

public class VueFenetre extends JFrame {

    private  VueMenuPrincipal vm;
    private VueNewPartie vnp;
    private static int LARGEUR = 1000;
    private static int HAUTEUR = 1000;

    public VueFenetre() {
        super("Master and Commander");
        setSize(1000   , 1000);


        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints(0,0,2,1,0.25,0,GridBagConstraints.PAGE_START,GridBagConstraints.VERTICAL,new Insets(1,1,1,1), 0,0);

        vm = new VueMenuPrincipal();
        vnp = new VueNewPartie();

        JLabel titre = new JLabel("Master and Commander");
        titre.setFont(new Font("Sans Serif", Font.PLAIN, 30));


        add(titre,gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy=2;
        gbc.gridwidth=1;
        add(vnp,gbc);

        setVisible(true);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new VueFenetre();

    }
}
