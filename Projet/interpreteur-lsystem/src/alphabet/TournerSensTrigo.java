package alphabet;
import java.util.LinkedList;

import tortue.Tortue;

public class TournerSensTrigo extends Mouvement {
	private static final Character REPRESENTATION_BASE='+';
	private static final double VALEUR_BASE=90;
	
	public TournerSensTrigo(Character representation, LinkedList<MembreAlpha> evolution ,double valeur)  {
		super(representation,evolution,valeur);
		this.tourne=true;
	}
	public TournerSensTrigo(Character representation, double valeur) {
		super(representation,valeur);
		this.tourne=true;
	}
	public TournerSensTrigo() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public TournerSensTrigo(double valeur) {
		this(REPRESENTATION_BASE,valeur);
	}
	@Override
	public void seDessiner(Tortue tortue) {
		tortue.tournerSensTrigo(valeur);
	}
	
}