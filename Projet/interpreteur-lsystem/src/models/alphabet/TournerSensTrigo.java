package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

/**
 * Classe représentant une rotation dans le sens trigonométrique
 */
public class TournerSensTrigo extends Mouvement {
    private static final Character REPRESENTATION_BASE = '+';
    private static final double VALEUR_BASE = -90;

    /**
     * Crée une instance de TournerSensTrigo
     * @param representation représentation du Symbole
     * @param evolution liste de Symbole
     * @param valeur angle de rotation
     */
    public TournerSensTrigo(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
        //this.tourne=true;
    }

    public TournerSensTrigo(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public TournerSensTrigo() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public TournerSensTrigo(double valeur) {
        this(REPRESENTATION_BASE, valeur);
    }

    /**
     * Transmet l'instruction de tourner dans le sens trigonométrique à la tortue
     * @param tortue Tortue qui dessine
     */
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