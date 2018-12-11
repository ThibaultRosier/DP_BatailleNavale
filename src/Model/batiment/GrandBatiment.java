package model.batiment;

import model.Case;
import model.Joueur;
import model.batiment.Batiment;

public abstract class GrandBatiment extends Batiment {
	
	public GrandBatiment(Joueur j, int nbVie,int nbTir ){
		super(j,nbTir,nbVie,5);
	}

}
