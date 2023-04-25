package models.alphabet;

import tortue.Dessin;
import tortue.Tortue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Symbole implements Dessin {
    protected Character representation;
    protected LinkedList<Symbole> evolution;
    protected boolean dessine;

    public Symbole(Character representation, LinkedList<Symbole> evolution) {
        this.representation = representation;
        this.evolution = evolution;
        this.dessine = false;
    }

    public Symbole(Character representation) {
        this(representation, new LinkedList<Symbole>());
        this.evolution.add(this);
    }

    public Symbole(Symbole membre) {
        this.representation = membre.representation;
        this.evolution = membre.evolution;
        this.dessine = membre.dessine;
    }

    public Character getRepresentation() {
        return representation;
    }

    public void setRepresentation(Character representation) {
        this.representation = representation;
    }


    public boolean isDessine() {
        return dessine;
    }

    public void setDessine(boolean dessine) {
        this.dessine = dessine;
    }

    public LinkedList<Symbole> getEvolution() {
        return evolution;
    }

    public void setEvolution(LinkedList<Symbole> evolution) {
        this.evolution = evolution;
    }

    public void setEvolution(Symbole membreEvolution) {
        LinkedList<Symbole> evolution2 = new LinkedList<Symbole>();
        evolution2.add(membreEvolution);
        this.evolution = evolution2;
    }

    public void addEvolution(Symbole membreEvolution) {
        this.evolution.add(membreEvolution);
    }

    @Override
    public void seDessiner(Tortue tortue) {
        tortue.stay();
    }



    public String toString() {
        return String.valueOf(this.getRepresentation());

    }

    public String evolutionRepresentation() {
        String rep = this.getRepresentation() + "=";
        for (Symbole membre : this.evolution) {
            rep += membre.getRepresentation();
        }
        return rep;
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