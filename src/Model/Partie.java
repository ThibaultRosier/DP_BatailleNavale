package model;

import model.batiment.Batiment;
import model.batiment.xviSiecle.Flute;
import model.batiment.xviSiecle.Gabare;
import model.batiment.xviSiecle.Galions;
import model.batiment.xxSiecle.Croiseur;
import model.batiment.xxSiecle.Destroyer;
import model.batiment.xxSiecle.LandingShipDock;

import java.util.ArrayList;
import java.util.Random;

public class Partie {



	public final static int NORMAL = 100;
	public final static int MASTER = 101;

	private static int TYPE_PARTIE;

	public final static int XX = 0;
	public final static int XVI = 1;

	private static int EPOQUE;



	private Joueur joueur1;
	private Joueur joueur2;
	
	private static Partie laPartie = null;

	public static Partie getPartie(){

		if(laPartie == null){
			laPartie = new Partie();
		}
		return laPartie;
	}

	private Partie(){
		joueur2 = new Joueur();
		joueur1 = new Joueur();
		if(TYPE_PARTIE == NORMAL || TYPE_PARTIE == MASTER) {
			switch (EPOQUE) {
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


	private void remplirCampXX(){
		joueur1.remplirCampXX();
		joueur2.remplirCampXX();
	}

	private void remplirCampXVI(){
		joueur1.remplirCampXVI();
		joueur2.remplirCampXVI();
	}

	
	public static void setEpoque(int epoq){
		EPOQUE = epoq;
	}

	public static void setTypePartie(int type){
		TYPE_PARTIE = type;
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

		for(int j = 0; j < Joueur.LARGEUR_CAMP ; j++){
			string+="-";
		}
		string+="\n";

		string += joueur2.toString();

		return string;
	}

}
