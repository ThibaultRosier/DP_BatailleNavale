package model.server.batiment;

import model.server.Case;
import model.server.Joueur;

public abstract class Batiment {
	
	protected int tirRestant;
	protected int nbTire;
	
	protected int taille;

	protected boolean couler;
	
	protected int nbVie;//combien de fois il faut le toucher avant qu'il coule

	protected  Joueur joueur;

	protected Case debutBatiment = null;
	protected boolean vertical;


	public Batiment(int nbTire,int nbVie,int taille){
		assert (nbVie <= taille):"Le nombre de vie d'un batiment ne peut etre superieur a sa taille probleme pour les batiment de type "+this.getClass().getName()+"ici le nombre de vie ne peut etre supperieur a "+taille;
		assert (nbVie <= nbTire):"Le nombre de vie d'un batiment ne peut etre superieur a son nombre de tire "+this.getClass().getName()+" ici le nombre de vie ne peut etre supperieur a "+nbTire;
		debutBatiment = null;
		this.joueur = null;
		couler = false;
		this.nbVie = nbVie;
		this.nbTire = nbTire;
		this.taille = taille;
        this.debutBatiment = debutBatiment;
        this.vertical = false;
		tirRestant = nbTire;
	}


    public Object clone() {
        Object o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la
            // méthode super.clone()
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implémentons
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }


	public void chargerTire(Joueur j){
		joueur = j;
		j.ajouterTire(nbTire);
	}

	public void toucher(){
		nbVie--;
		if(nbVie <= 0){
			couler = true;
			joueur.enleverTir(tirRestant);
		}
	}

	public void tir(){
		joueur.enleverTir(1);
		tirRestant--;
	}

	public int getTaille() {
		return taille;
	}

	public boolean getCouler(){
		return couler;
	}

	public int getTirRestant() {
		return tirRestant;
	}

	public void setDebutBatiment(Case c){
		debutBatiment = c;
	}

	public void mettreVertical(){
		vertical = true;
	}

	public void mettreHorizontal(){
		vertical = false;
	}

	public Case getDebutBatiment(){
		return  debutBatiment;
	}
}
