package model.batiment;

import model.Case;
import model.Joueur;

public abstract class PetitBatiment extends Batiment {

	public PetitBatiment(Joueur j, int nbVie,int nbTir){

		super(j,nbTir,nbVie,2);
	}
}
