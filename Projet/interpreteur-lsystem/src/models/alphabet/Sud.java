package models.alphabet;

import java.util.LinkedList;
/**
 * Classe représentant une rotation fixe vers le sud
 */
public class Sud extends Cardinaux {
    private static final Character REPRESENTATION_BASE = '&';
    private static final double VALEUR_BASE = 90;

    public Sud(Character representation, LinkedList<Symbole> evolution) {
        super(representation, evolution, VALEUR_BASE);
        this.tourne = true;
    }

    public Sud(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public Sud() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }




    @Override
    public double getValeur() {
        return super.getValeur();
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