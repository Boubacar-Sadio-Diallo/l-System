package alphabet;

import java.util.LinkedList;

public class DessinerAvancer extends Affecter {
	private static final char REPRESENTATION_BASE='F';
	private static final int VALEUR_BASE=10;
	
	public DessinerAvancer(char representation, LinkedList<MembreAlpha> evolution, int valeur) {
		super(representation, evolution, valeur);
	}

	public DessinerAvancer(char representation, int valeur) {
		super(representation, valeur);
	}
	
	public DessinerAvancer() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}

	

}

