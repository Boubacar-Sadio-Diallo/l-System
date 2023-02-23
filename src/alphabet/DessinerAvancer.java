package alphabet;

import java.util.LinkedList;

public class DessinerAvancer extends DeplacementRect {
	private static final Character REPRESENTATION_BASE='F';
	private static final double VALEUR_BASE=10;
	
	public DessinerAvancer(Character representation, LinkedList<MembreAlpha> evolution, double valeur) {
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

	

}

