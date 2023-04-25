package models.alphabet;

import java.util.LinkedList;

public class Ouest extends Cardinaux {
    private static final Character REPRESENTATION_BASE = '<';
    private static final double VALEUR_BASE = 180;

    public Ouest(Character representation, LinkedList<Symbole> evolution) {
        super(representation, evolution, VALEUR_BASE);
        this.tourne = true;
    }

    public Ouest(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public Ouest() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public Ouest(Ouest membre) {
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