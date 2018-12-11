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

public class Joueur {

    public final static int LARGEUR_CAMP = 10;
    public final static int HAUTEUR_CAMP = 10;

    private final static int NOMBRE_GRAND = 2;
    private final static int NOMBRE_MOYEN = 3;
    private final static int NOMBRE_PETIT = 6;

    private Case [][] campJoueur;
    private Random random = new Random();

    private int nombreTireRestant = 0;

    public   void remplirCampXX(){
        ArrayList<Batiment> lesBatiments = new ArrayList<Batiment>();
        for(int i = 0; i < NOMBRE_GRAND ; i++){
            lesBatiments.add(new Croiseur(this));
        }

        for(int i = 0; i < NOMBRE_MOYEN ; i++){
            lesBatiments.add(new Destroyer(this));
        }

        for(int i = 0; i < NOMBRE_PETIT ; i++){
            lesBatiments.add(new LandingShipDock(this));
        }

        remplirCamp(lesBatiments);
    }

    public   void remplirCampXVI( ){
        ArrayList<Batiment> lesBatiments = new ArrayList<Batiment>();
        for(int i = 0; i < NOMBRE_GRAND ; i++){
            lesBatiments.add(new Galions(this));
        }

        for(int i = 0; i < NOMBRE_MOYEN ; i++){
            lesBatiments.add(new Flute(this));
        }

        for(int i = 0; i < NOMBRE_PETIT ; i++){
            lesBatiments.add(new Gabare(this));
        }

        remplirCamp(lesBatiments);
    }

    private  void remplirCamp(ArrayList<Batiment> lesBatiments ){
        boolean placer = false;
        int direction,x,y;
        campJoueur = new Case[HAUTEUR_CAMP][LARGEUR_CAMP];
        for(int i = 0; i < HAUTEUR_CAMP ; i++){
            for(int j = 0; j < LARGEUR_CAMP ; j++){
                campJoueur[i][j] = new Case(j,i);
            }
        }
        Batiment batiActu ;
        while(!lesBatiments.isEmpty()){
            placer = false;
            batiActu = lesBatiments.get(0);
            lesBatiments.remove(0);
            while (!placer) {
                direction = random.nextInt(2);
                x = random.nextInt(LARGEUR_CAMP);
                y = random.nextInt(HAUTEUR_CAMP);
                if (direction == 0) {
                    placer = mettreBatimentHorizontal(campJoueur,campJoueur[y][x],batiActu);
                } else {
                    placer = mettreBatimentVertical(campJoueur,campJoueur[y][x],batiActu);
                }
            }
        }
    }



    private boolean mettreBatimentHorizontal(Case[][] camp ,Case c,Batiment b){
        int x = c.getX();
        int y = c.getY();
        if(x + b.getTaille() < LARGEUR_CAMP){
            for(int i = x; i < x+b.getTaille();i++){
                if(camp[y][i].getBatiment() != null){
                    return false;
                }
            }
            b.mettreHorizontal();
            b.setDebutBatiment(c);
            for(int i = x; i < x+b.getTaille();i++){
                camp[y][i].setBatiment(b);
            }
            nombreTireRestant += b.getTirRestant();
            return true;
        }
        return false;
    }

    private boolean mettreBatimentVertical(Case[][] camp ,Case c,Batiment b){
        int x = c.getX();
        int y = c.getY();
        if(y + b.getTaille() < HAUTEUR_CAMP){
            for(int i = y; i < y+b.getTaille();i++){
                if(camp[i][x].getBatiment() != null){
                    return false;
                }
            }
            b.mettreVertical();
            b.setDebutBatiment(c);
            for(int i = y; i < y+b.getTaille();i++){
                camp[i][x].setBatiment(b);
            }
            nombreTireRestant += b.getTirRestant();
            return true;
        }
        return false;
    }

    public int getNombreTireRestant(){
        return nombreTireRestant;
    }

    public void enleverTir(int tirEnMoins){
        nombreTireRestant-=tirEnMoins;
    }

    public void ajouterTire(int nbTire){
        nombreTireRestant += nbTire;
    }
    public String toString(){
        String string = "";

        for(int i = 0; i < HAUTEUR_CAMP ; i++){
            for(int j = 0; j < LARGEUR_CAMP ; j++){
                if(campJoueur[i][j].getBatiment() != null){
                    string+="B";
                }else{
                    string+="O";
                }
            }
            string+="\n";
        }
        return string;
    }
}
