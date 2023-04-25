package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

public class Avancer extends Mouvement {
    private static final Character REPRESENTATION_BASE = 'f';
    private static final double VALEUR_BASE = 20;

    public Avancer(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
    }

    public Avancer(Character representation, double valeur) {
        super(representation, valeur);
    }

    public Avancer() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public Avancer(double valeur) {
        this(REPRESENTATION_BASE, valeur);
    }

    public Avancer(Avancer membre) {
        this(membre.representation, membre.evolution, membre.valeur);
    }

    @Override
    public void seDessiner(Tortue tortue) {
        tortue.avancerSansTracer((int) this.valeur);
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