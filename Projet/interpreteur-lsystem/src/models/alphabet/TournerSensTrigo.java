package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

public class TournerSensTrigo extends Mouvement {
    private static final Character REPRESENTATION_BASE = '+';
    private static final double VALEUR_BASE = 90;

    public TournerSensTrigo(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, -valeur);
        //this.tourne=true;
    }

    public TournerSensTrigo(Character representation, double valeur) {
        super(representation, -valeur);
        //this.tourne=true;
    }

    public TournerSensTrigo() {
        this(REPRESENTATION_BASE, -VALEUR_BASE);
    }

    public TournerSensTrigo(double valeur) {
        this(REPRESENTATION_BASE, -valeur);
    }



    @Override
    public void seDessiner(Tortue tortue) {
        tortue.tourner(valeur);
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