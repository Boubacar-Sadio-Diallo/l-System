package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

public class DessinerAvancer extends Mouvement {
    private static final Character REPRESENTATION_BASE = 'F';
    private static final double VALEUR_BASE = 20;

    public DessinerAvancer(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
        this.dessine = true;
    }

    public DessinerAvancer(Character representation, double valeur) {
        super(representation, valeur);
        this.dessine = true;
    }

    public DessinerAvancer() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public DessinerAvancer(double valeur) {
        this(REPRESENTATION_BASE, valeur);
    }

    public DessinerAvancer(DessinerAvancer membre) {
        this(membre.representation, membre.evolution, membre.valeur);
    }

    @Override
    public void seDessiner(Tortue tortue) {
        tortue.avancerEtTracer((int) this.valeur);
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

