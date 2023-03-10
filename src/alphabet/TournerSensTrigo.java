package alphabet;
import java.util.LinkedList;

public class TournerSensTrigo extends Mouvement {
	private static final Character REPRESENTATION_BASE='+';
	private static final int VALEUR_BASE=90;
	
	public TournerSensTrigo(Character representation, LinkedList<MembreAlpha> evolution ,int valeur)  {
		super(representation,evolution,valeur);
		this.tourne=true;
	}
	public TournerSensTrigo(Character representation, int valeur) {
		super(representation,valeur);
		this.tourne=true;
	}
	public TournerSensTrigo() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public TournerSensTrigo(int valeur) {
		this(REPRESENTATION_BASE,valeur);
	}
	
}