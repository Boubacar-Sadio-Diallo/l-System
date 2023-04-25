package models.alphabet;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Classe abstraite représentant les classes qui ont une valeur déterminante
 */
public abstract class Mouvement extends Symbole {
    protected double valeur;
    protected boolean tourne;

    /**
     * Constructeur pour les classes héritant de Mouvement
     * @param representation représentation du Symbole
     * @param evolution liste de Symbole
     * @param valeur valeur qui peut être l'angle de rotation ou la longueur du trait
     */
    public Mouvement(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution);
        this.valeur = valeur;
        //this.tourne=false;
    }
    /*public boolean isTourne() {
        return tourne;
    }*/

    public Mouvement(Character representation, double valeur) {
        super(representation);
        this.valeur = valeur;
    }

    /**
     * Getter de la valeur
     * @return valeur du Symbole
     */

    public double getValeur() {
        return this.valeur;
    }

    /**
     * Setter de la valeur
     * @param valeur nouvelle valeur
     */
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    /**
     * Décide si l'objet tourne
     * @return true si l'objet tourne, false sinon
     */
    public boolean isTourne() {
        return tourne;
    }


    @Override
    public boolean equals(Object other){
        if (other==null){
            return false;
        }
        if (!(other instanceof Mouvement)){
            return false;
        }
        if(!super.equals(other)) return false;
        Mouvement symbole=(Mouvement) other;
        return valeur== symbole.getValeur() && tourne==symbole.isTourne();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), valeur, tourne);
    }
}
