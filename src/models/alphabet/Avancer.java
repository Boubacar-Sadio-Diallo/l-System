package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

/**
 * Classe représentant le Symbole avancer le crayon sans dessiner
 */
public class Avancer extends Mouvement {
    private static final Character REPRESENTATION_BASE = 'f';
    private static final double VALEUR_BASE = 20;

    /**
     * Créer une instance de Avancer
     * @param representation représentation du symbole
     * @param evolution liste de symbole symbolisant l'évolution du symbole
     * @param valeur longueur d'avancement
     */
    public Avancer(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
    }

    /**
     * Créer une instance de Avancer
     * @param representation représentation du symbole
     * @param valeur longueur d'avancement
     */
    public Avancer(Character representation, double valeur) {
        super(representation, valeur);
    }

    /**
     * Créer une instance de Avancer
     */
    public Avancer() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    /**
     * Créer une instance de Avancer
     * @param valeur longueur d'avancement
     */
    public Avancer(double valeur) {
        this(REPRESENTATION_BASE, valeur);
    }

    /**
     * Donne l'instruction d'avancer à une tortue
     * @param tortue Tortue qui dessine
     */
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