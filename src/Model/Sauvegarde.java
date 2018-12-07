package Model;

import javax.swing.*;
import java.io.*;
import java.util.Date;

public class Sauvegarde implements Serializable{

    private String nom;
    private String epoque;
    private String typePartie;
    private String date;

    public Sauvegarde(String nom, String epoque, String typePartie, String date) {
        this.nom = nom;
        this.epoque = epoque;
        this.typePartie = typePartie;
        this.date = date;
    }

    public Sauvegarde(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getEpoque() {
        return epoque;
    }

    public String getTypePartie() {
        return typePartie;
    }

    public String getDate() {
        return date;
    }

    public void serialize(String name) throws IOException {

        File fichier =  new File("./fichier_sauvegarde/"+name+".save") ;

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;

        // sérialization de l'objet
        oos.writeObject(this) ;
    }

    public static Sauvegarde deSerialize(String name) throws IOException, ClassNotFoundException {

        // on simplifie le code en retirant la gestion des exceptions
        File fichier =  new File("./fichier_sauvegarde/"+name+".save") ;

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;

        // désérialization de l'objet
        return (Sauvegarde) ois.readObject() ;
        //System.out.println(m) ;

    }

}
