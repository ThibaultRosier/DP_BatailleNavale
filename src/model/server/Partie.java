package model.server;

import model.server.batiment.Batiment;
import model.service.Case;
import model.service.IPartie;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Partie extends UnicastRemoteObject implements IPartie{



	public final static int NORMAL = 100;
	public final static int MASTER = 101;


	public final static int XX = 0;
	public final static int XVI = 1;

	public static int Epoque = -1;
	public static int Type_Partie = -1;

	private Joueur joueur1;
	private Joueur joueur2;

	private static Partie partieEnCour = null;


	private Partie(int epoque,int type_Partie) throws RemoteException {
		super();
		joueur2 = new Joueur();
		joueur1 = new Joueur();
		if(type_Partie == NORMAL || type_Partie == MASTER) {
			switch (epoque) {
				case XX:
					remplirCampXX();
					break;
				case XVI:
					remplirCampXVI();
					break;
				default:
					assert (false) : "l'epoque definie n'existe pas le partie ne peut etre cree ";
			}
		}else{
			assert(false):"Le type de partie n'est pas definie la partie ne peut donc etre cree";
		}
	}

	public static Partie getPartieEnCour() throws RemoteException {
		if( partieEnCour == null ){
			partieEnCour = new Partie(Epoque,Type_Partie);
		}
		return partieEnCour;
	}

	private void remplirCampXX() throws RemoteException {
		joueur1.chargerCampXX();
		joueur2.chargerCampXX();
	}

	private void remplirCampXVI() throws RemoteException {
		joueur1.chargerCampXVI();
		joueur2.chargerCampXVI();
	}


	public void tire(Batiment b , Case c){
		assert (b != null):" Aucun batiment selectionner le tire ne peut ce faire";
		assert (c != null):"Aucunnne case cibler le tire ne peut ce faire";

		if(b.getTirRestant() > 0) {
			b.tir();
			c.toucher();
		}
	}

	public void tire(Case c){
		assert (c != null):"Aucunnne case cibler le tire ne peut ce faire";

		c.toucher();
	}

	public Joueur getGagnant() {
		if(joueur1.getNombreTireRestant() <= 0){
			return joueur2;
		}else {
			if (joueur2.getNombreTireRestant() <= 0) {
				return  joueur1;
			}
		}

		return null;
	}

	public String toString(){
		String string = "";

		string += joueur1.toString();

		for(int j = 0; j < Camp.LARGEUR_CAMP ; j++){
			string+="-";
		}
		string+="\n";

		string += joueur2.toString();

		return string;
	}

	public static void main(String [] args) throws RemoteException {
		try {
			// create a RMI registry
			Registry r = LocateRegistry.createRegistry(1099);

			// create and publish car factory server object
			Partie partieFactory = new Partie(XX,NORMAL);
			r.rebind("partie", partieFactory);
			System.err.println("CarFactoryServer is running.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
