package models.alphabet;

import java.util.LinkedList;

public class Nord extends Cardinaux {
    private static final Character REPRESENTATION_BASE = '^';
    private static final double VALEUR_BASE = 90;

    public Nord(Character representation, LinkedList<Symbole> evolution) {
        super(representation, evolution, VALEUR_BASE);
        this.tourne = true;
    }

    public Nord(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public Nord() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public Nord(Nord membre) {
        this(membre.representation, membre.evolution);
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