package models.alphabet;

import java.util.LinkedList;

public class Est extends Cardinaux {
    private static final Character REPRESENTATION_BASE = '>';
    private static final double VALEUR_BASE = 0;

    public Est(Character representation, LinkedList<Symbole> evolution) {
        super(representation, evolution, VALEUR_BASE);
        this.tourne = true;
    }

    public Est(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public Est() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public Est(Est membre) {
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