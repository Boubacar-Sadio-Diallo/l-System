package models.alphabet;

import java.util.LinkedList;

/**
 * Classe représentant une rotation fixe vers la droite
 */
public class Est extends Cardinaux {
    private static final Character REPRESENTATION_BASE = '>';
    private static final double VALEUR_BASE = 0;

    /**
     * Crée une instance de Est
     * @param representation caractère de représentation
     * @param evolution liste de Symbole
     */
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

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}