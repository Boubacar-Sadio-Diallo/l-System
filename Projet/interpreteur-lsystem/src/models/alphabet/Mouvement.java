package models.alphabet;

import java.util.LinkedList;
import java.util.Objects;


public abstract class Mouvement extends Symbole {
    protected double valeur;
    protected boolean tourne;

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


    public double getValeur() {
        return this.valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

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
