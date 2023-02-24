package alphabet;
import java.util.LinkedList;

public class Avancer extends Mouvement {
	private static final Character REPRESENTATION_BASE='f';
	private static final int VALEUR_BASE=10;
	
	public Avancer(Character representation, LinkedList<MembreAlpha> evolution ,int valeur )  {
		super(representation,evolution,valeur);
	}
	public Avancer(Character representation,int valeur) {
		super(representation,valeur);
	}
	public Avancer() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public Avancer(int valeur) {
		this(REPRESENTATION_BASE,valeur);
	}

}