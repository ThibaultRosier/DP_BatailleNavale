package model.server;

import model.service.Case;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

public class IA extends Joueur {

	private Random r;

	protected IA() throws RemoteException {
		r = new Random();
	}

	public void strategieAleatoire(Case[][] campAdverse){
		Case c = null;
		ArrayList<Case> lesCaseDispo = new ArrayList<Case>();
		int taille1 = campAdverse.length;
		int taille2 = campAdverse[0].length;
		for(int i = 0 ;  i < taille1 ; i++){
			for(int j = 0 ;  j < taille2 ; j++){
				if(!campAdverse[i][j].getToucher()) {
					lesCaseDispo.add(campAdverse[i][j]);
				}
			}
		}

		int choix = r.nextInt(lesCaseDispo.size());


		Partie.caseSelection = lesCaseDispo.get(choix);
		
	}
	
	public Case strategie2(){
		Case c =null;
		
		return c;
		
	}

}
