package alphabet;
import java.util.LinkedList;

public class TournerSensTrigo extends DeplacementRect {
	private static final Character REPRESENTATION_BASE='+';
	private static final double VALEUR_BASE=90;
	
	public TournerSensTrigo(Character representation, LinkedList<MembreAlpha> evolution ,double valeur)  {
		super(representation,evolution,valeur);
	}
	public TournerSensTrigo(Character representation, double valeur) {
		super(representation,valeur);
	}
	public TournerSensTrigo() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public TournerSensTrigo(double valeur) {
		this(REPRESENTATION_BASE,valeur);
	}
	
}