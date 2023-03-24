package alphabet;
import java.util.LinkedList;

import tortue.Tortue;

public class TournerSensHoraire extends Mouvement {
	private static final Character REPRESENTATION_BASE='-';
	private static final double VALEUR_BASE=90;
	
	public TournerSensHoraire(Character representation, LinkedList<MembreAlpha> evolution ,double valeur)  {
		super(representation,evolution,valeur);
		this.tourne=true;
	}
	public TournerSensHoraire(Character representation, double valeur) {
		super(representation,valeur);
		//this.tourne=true;
	}
	public TournerSensHoraire() {
		this(REPRESENTATION_BASE,VALEUR_BASE);
	}
	public TournerSensHoraire(double valeur) {
		this(REPRESENTATION_BASE,valeur);
	}
	public TournerSensHoraire(TournerSensHoraire membre) {
		this(membre.representation,membre.evolution,membre.valeur);
	}
	@Override
	public void seDessiner(Tortue tortue) {
		tortue.tournerSensHoraire(valeur);
	}
	
}