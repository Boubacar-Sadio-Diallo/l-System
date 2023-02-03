package alphabet;
import java.util.LinkedList;

public class Avancer extends Affecter {
	private static final char REPRESENTATION_BASE='f';
	private static final int VALEUR_BASE=10;
	
	public Avancer(char representation, LinkedList<MembreAlpha> evolution ,int valeur )  {
		super(representation,evolution,valeur);
	}
	public Avancer(char representation,int valeur) {
		super(representation,valeur);
	}
	public Avancer() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}

}