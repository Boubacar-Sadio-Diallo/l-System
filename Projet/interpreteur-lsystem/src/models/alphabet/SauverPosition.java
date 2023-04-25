package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;
/**
 * Classe représentant une restauration de position
 */
public class SauverPosition extends Symbole {

    private static final char REPRESENTATION_BASE = '[';

    public SauverPosition(char representation, LinkedList<Symbole> evolution) {
        super(representation, evolution);
    }

    public SauverPosition(char representation) {
        super(representation);
    }

    public SauverPosition() {
        this(REPRESENTATION_BASE);
    }

    @Override
    public void seDessiner(Tortue tortue) {
        tortue.sauverPosition();
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
