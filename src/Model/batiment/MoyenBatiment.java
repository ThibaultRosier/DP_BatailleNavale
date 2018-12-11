package model.batiment;

import model.Case;
import model.Joueur;

public abstract class MoyenBatiment extends Batiment {
	
	public MoyenBatiment(Joueur j, int nbVie,int nbTir){
		super(j,nbTir,nbVie,3);

	}
}
