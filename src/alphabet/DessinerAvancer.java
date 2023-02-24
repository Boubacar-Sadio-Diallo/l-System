package alphabet;

import java.util.LinkedList;

public class DessinerAvancer extends Mouvement {
	private static final Character REPRESENTATION_BASE='F';
	private static final int VALEUR_BASE=10;
	
	public DessinerAvancer(Character representation, LinkedList<MembreAlpha> evolution, int valeur) {
		super(representation, evolution, valeur);
		this.dessine=true;
	}

	public DessinerAvancer(Character representation, int valeur) {
		super(representation, valeur);
		this.dessine=true;
	}
	
	public DessinerAvancer() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public DessinerAvancer(int valeur) {
		this(REPRESENTATION_BASE,valeur);
	}

	

}

