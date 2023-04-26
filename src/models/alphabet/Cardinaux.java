package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;
/**
 * Classe abstraite représentant les classes qui ont une rotation fixe
 */
public abstract class Cardinaux extends Mouvement {

    /**
     * Instancie un Cardinaux
     * @param representation caractère de représentation
     * @param evolution liste de Symbole
     * @param valeur angle de rotation
     */
    public Cardinaux(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
    }

    public Cardinaux(Character representation, double valeur) {
        super(representation, valeur);
        this.valeur = valeur;
    }

    /**
     * Transmet l'instruction de tourner d'un angle
     * @param tortue Tortue qui dessine
     */
    @Override
    public void seDessiner(Tortue tortue) {
        tortue.setAngle(valeur);
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
