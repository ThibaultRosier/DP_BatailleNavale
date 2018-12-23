package model.client;

import model.server.Partie;
import model.service.IPartie;

public class TestClient implements IPartie{

    public static void main(String[] args) throws Exception {
        String url = "rmi://annuaire-RMI/partieFactory";
        //IPartie partieFactory = (IPartie) IPartie.lookup(url);

        Partie c = Partie.getPartieEnCour();

    }
}
