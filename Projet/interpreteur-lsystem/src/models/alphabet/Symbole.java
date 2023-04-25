package models.alphabet;

import tortue.Dessin;
import tortue.Tortue;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Classe représentant un Symbole de Lsystem
 */
public class Symbole implements Dessin {
    protected Character representation;
    protected LinkedList<Symbole> evolution;
    protected boolean dessine;

    /**
     * Crée une instance de Symbole
     * @param representation représentation du Symbole
     * @param evolution liste de Symbole
     */
    public Symbole(Character representation, LinkedList<Symbole> evolution) {
        this.representation = representation;
        this.evolution = evolution;
        this.dessine = false;
    }

    public Symbole(Character representation) {
        this(representation, new LinkedList<>());
        this.evolution.add(this);
    }


    /**
     * Renvoie la représentation du Symbole
     * @return un caractère représentant le symbole
     */
    public Character getRepresentation() {
        return representation;
    }

    /**
     * Change la représentation du Symbole
     * @param representation nouvelle représentation du Symbole
     */
    public void setRepresentation(Character representation) {
        this.representation = representation;
    }

    /**
     * Décide si le Symbole dessine
     * @return true si le Symbole dessine, false dinon
     */
    public boolean isDessine() {
        return dessine;
    }

    /**
     * Modifie le booléen qui déterine si le Symbole dessine
     * @param dessine nouveau booléen
     */
    public void setDessine(boolean dessine) {
        this.dessine = dessine;
    }

    /**
     * Renvoie la liste de Symbole qui est l'évolution du symbole
     * @return liste de Symbole
     */
    public LinkedList<Symbole> getEvolution() {
        return evolution;
    }

    /**
     * Modifie la liste de symbole caractérisant l'évolution du symbole par une autre liste de Symbole
     * @param evolution nouvelle évolution sous forme de liste de symbole
     */
    public void setEvolution(LinkedList<Symbole> evolution) {
        this.evolution = evolution;
    }

    /**
     * Modifie la liste de symbole caractérisant l'évolution du symbole par une autre liste composé d'un symbole
     * @param membreEvolution un Symbole
     */
    public void setEvolution(Symbole membreEvolution) {
        LinkedList<Symbole> evolution2 = new LinkedList<>();
        evolution2.add(membreEvolution);
        this.evolution = evolution2;
    }

    /**
     * Ajoute à l'évolution un symbole
     * @param membreEvolution le symbole à ajouter
     */
    public void addEvolution(Symbole membreEvolution) {
        this.evolution.add(membreEvolution);
    }

    /**
     * Transmet à la tortue l'ordre de ne rien faire
     * @param tortue Tortue qui dessine
     */
    @Override
    public void seDessiner(Tortue tortue) {
        tortue.stay();
    }


    /**
     * Renvoie le caractère qui représente le symbole
     * @return Un caractère représentant le symbole
     */
    public String toString() {
        return String.valueOf(this.getRepresentation());

    }

    /**
     * Renvoie la représentation de l'évolution du symbole
     * @return La représentation de l'évolution du symbole
     */
    public String evolutionRepresentation() {
        StringBuilder rep = new StringBuilder(this.getRepresentation() + "=");
        for (Symbole membre : this.evolution) {
            rep.append(membre.getRepresentation());
        }
        return rep.toString();
    }


    @Override
    public boolean equals(Object other){
        if (other==null){
            return false;
        }
        if (!(other instanceof Symbole)){
            return false;
        }
        Symbole symbole=(Symbole) other;
        return this.dessine == symbole.isDessine() && Objects.equals(this.representation,symbole.getRepresentation()) && this.evolutionRepresentation().equals(symbole.evolutionRepresentation());
    }


    @Override
    public int hashCode() {
        return Objects.hash(representation, evolution, dessine);
    }
}