package alphabet;
import java.util.LinkedList;

public class TournerSensHoraire extends DeplacementRect {
	private static final Character REPRESENTATION_BASE='-';
	private static final double VALEUR_BASE=90;
	
	public TournerSensHoraire(Character representation, LinkedList<MembreAlpha> evolution ,double valeur)  {
		super(representation,evolution,valeur);
	}
	public TournerSensHoraire(Character representation, double valeur) {
		super(representation,valeur);
	}
	public TournerSensHoraire() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public TournerSensHoraire(double valeur) {
		this(REPRESENTATION_BASE,valeur);
	}
	
}