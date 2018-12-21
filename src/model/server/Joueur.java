package Model.server;

import Model.server.batiment.xviSiecle.Gabare;
import Model.server.batiment.xviSiecle.Flute;
import Model.server.batiment.xviSiecle.Galions;
import Model.server.batiment.xxSiecle.Croiseur;
import Model.server.batiment.xxSiecle.Destroyer;
import Model.server.batiment.xxSiecle.LandingShipDock;

import java.io.Serializable;

public class Joueur implements Serializable{



    private Camp campJoueur;


    private int nombreTireRestant = 0;

    public int getNombreTireRestant(){
        return nombreTireRestant;
    }

    public void enleverTir(int tirEnMoins){
        nombreTireRestant-=tirEnMoins;
    }

    public void ajouterTire(int nbTire){
        nombreTireRestant += nbTire;
    }

    public void chargerCampXX(){
        campJoueur = new Camp(this,new Croiseur(),new Destroyer(),new LandingShipDock());
    }

    public void chargerCampXVI(){
        campJoueur = new Camp(this,new Galions(),new Flute(),new Gabare());
    }


    public String toString(){
        String string = "";
        Case [][]camp = campJoueur.getCamp();
        for(int i = 0; i < Camp.HAUTEUR_CAMP ; i++){
            for(int j = 0; j < Camp.LARGEUR_CAMP ; j++){
                if(camp[i][j].getBatiment() != null){
                    if(camp[i][j].estUneCaseDebutBatiment() ){
                        string += "D";
                    }else {
                        string += "B";
                    }
                }else{
                    string+="O";
                }
            }
            string+="\n";
        }
        return string;
    }
}
