package models.alphabet;

import java.util.LinkedList;

import tortue.Tortue;

public class DessinerAvancer extends Mouvement {
	private static final Character REPRESENTATION_BASE='F';
	private static final double VALEUR_BASE=10;
	
	public DessinerAvancer(Character representation, LinkedList<Symbole> evolution, double valeur) {
		super(representation, evolution, valeur);
		this.dessine=true;
	}

	public DessinerAvancer(Character representation, double valeur) {
		super(representation, valeur);
		this.dessine=true;
	}
	
	public DessinerAvancer() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public DessinerAvancer(double valeur) {
		this(REPRESENTATION_BASE,valeur);
	}
	public DessinerAvancer(DessinerAvancer membre) {
		this(membre.representation,membre.evolution,membre.valeur);
	}
	@Override
	public void seDessiner(Tortue tortue) {
		tortue.avancerEtTracer((int)this.valeur);
	}

	

}

