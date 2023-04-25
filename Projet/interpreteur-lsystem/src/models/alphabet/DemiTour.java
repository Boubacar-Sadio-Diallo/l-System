package models.alphabet;

import java.util.LinkedList;
/**
 * Classe représentant le Symbole faire une rotation de 180°
 */
public class DemiTour extends Mouvement {
    private static final Character REPRESENTATION_BASE = '|';
    private static final double VALEUR_BASE = 180;

    /**
     * Créer une instance de Demitour
     * @param representation representation du symbole
     * @param evolution liste de Symbole
     */
    public DemiTour(Character representation, LinkedList<Symbole> evolution) {
        super(representation, evolution, VALEUR_BASE);
        this.tourne = true;
    }

    public DemiTour(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public DemiTour() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
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