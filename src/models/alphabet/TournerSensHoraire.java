package models.alphabet;

import tortue.Tortue;

import java.util.LinkedList;

/**
 * Classe représentant une rotation dans le sens horaire
 */
public class TournerSensHoraire extends Mouvement {
    private static final Character REPRESENTATION_BASE = '-';
    private static final double VALEUR_BASE = 90;

    /**
     * Crée une instance de TournerSensHoraire
     * @param representation représentation du symbole
     * @param evolution liste de Symbole
     * @param valeur angle de rotation
     */
    public TournerSensHoraire(Character representation, LinkedList<Symbole> evolution, double valeur) {
        super(representation, evolution, valeur);
        this.tourne = true;
    }

    public TournerSensHoraire(Character representation, double valeur) {
        super(representation, valeur);
        //this.tourne=true;
    }

    public TournerSensHoraire() {
        this(REPRESENTATION_BASE, VALEUR_BASE);
    }

    public TournerSensHoraire(double valeur) {
        this(REPRESENTATION_BASE, valeur);
    }


    /**
     * Transmet l'instruction de tourner dans le sens horaire à la tortue
     * @param tortue Tortue qui dessine
     */
    @Override
    public void seDessiner(Tortue tortue) {
        tortue.tourner(valeur);
    }

    @Override
    public double getValeur() {
        return super.getValeur();
    }
}