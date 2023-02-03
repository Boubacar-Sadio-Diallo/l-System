package alphabet;
import java.util.LinkedList;

public class Tourner extends Affecter {
	private static final char REPRESENTATION_BASE='+';
	private static final int VALEUR_BASE=90;
	
	public Tourner(char representation, LinkedList<MembreAlpha> evolution ,int valeur)  {
		super(representation,evolution,valeur);
	}
	public Tourner(char representation, int valeur) {
		super(representation,valeur);
	}
	public Tourner() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	
}