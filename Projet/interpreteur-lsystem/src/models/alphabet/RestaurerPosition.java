package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

/**
 * Classe représentant une sauvegarde de position
 */
public class RestaurerPosition extends Symbole {

    private static final Character REPRESENTATION_BASE = ']';

    /**
     * Créer une instance de Restaurerposition
     * @param representation représentation du Symbole
     * @param evolution liste de Symbole
     */
    public RestaurerPosition(Character representation, LinkedList<Symbole> evolution) {
        super(representation, evolution);
    }

    public RestaurerPosition(Character representation) {
        super(representation);
    }

    public RestaurerPosition() {
        this(REPRESENTATION_BASE);
    }

    @Override
    public void seDessiner(Tortue tortue) {
        tortue.restaurerPosition();
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