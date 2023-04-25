package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

public abstract class Cardinaux extends Mouvement {


    public Cardinaux(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
    }

    public Cardinaux(Character representation, double valeur) {
        super(representation, valeur);
        this.valeur = valeur;
    }

    @Override
    public void seDessiner(Tortue tortue) {
        tortue.tourner(valeur);
    }

    public double getValeur() {
        return this.valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
